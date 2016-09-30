package gameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

import data.Loader;
import entities.Monster;
import entities.MonsterManager;
import entities.Player;
import gfx.Animation;
import gfx.Assets;
import thePrinceGame.Handler;

public class BattleState extends State {

	private MonsterManager monsterManager;
	private Animation animLeft1;
	private Animation animLeft2;
	private Animation animLeft3;
	private Animation animLeft4;
	private Monster[] monsters  = new Monster[4];
	private Animation[] monsterAnimations = new Animation[4];
	private ArrayList<Thread> monsterThreads = new ArrayList<Thread>();
	private int stateID;
	private int activePlayer;  // 1,2,3,4 for each player
	private BufferedImage background;
	private int numEnemy; //2,3,4
	private double rolldice;
	private int x_coord,y_coord,TileID;
	private String[] skillNames = new String[6];
	private int[][] skillsCombos;
	private int[] playerCombo;
	private int comboNum;
	private int[] playerJobs = new int[4];
	private int playerTarget = 0;
	private int enemyTarget = 0;
	private int skillID = 0;
	private boolean p_magic = false;
	private double p_crit = 0;
	private boolean[] deadEnemy = {false,false,false,false};
	private boolean[] deadAlly = {false,false,false,false};
	private int runAway;
	
	public BattleState (Handler handler){
		super(handler);
		//stateID = 7;
		stateID = handler.getData().getStateID();
		
		animLeft1 = new Animation(200, Assets.player_left);
		animLeft2 = new Animation(200, getCharAnim(handler.getData().getPlayer2_job()));
		animLeft3 = new Animation(200, getCharAnim(handler.getData().getPlayer3_job()));
		animLeft4 = new Animation(200, getCharAnim(handler.getData().getPlayer4_job()));
		x_coord = handler.getData().getX_coord();
		y_coord = handler.getData().getY_coord();
		TileID = handler.getWorld().getTile(x_coord, y_coord).getID();
		monsterManager = new MonsterManager(TileID);
		background = getBackground();
		activePlayer = 1;
		handler.getKeyManager().setUpr(false);
		handler.getKeyManager().setDownr(false);
		handler.getKeyManager().setLeftr(false);
		handler.getKeyManager().setRightr(false);
		handler.getKeyManager().setSelectr(false);
		handler.getKeyManager().setBackr(false);
		
		playerJobs[0] = handler.getData().getPlayer1_job();
		playerJobs[1] = handler.getData().getPlayer2_job();
		playerJobs[2] = handler.getData().getPlayer3_job();
		playerJobs[3] = handler.getData().getPlayer4_job();

		if (stateID == 0){
			rolldice = Math.random();
			if (rolldice > 0.3)
				numEnemy = 2;
			else if (rolldice > 0.7)
				numEnemy = 3;
			else
				numEnemy = 4;
			
			for (int i = 0; i < numEnemy; i++){
				monsters[i] = monsterManager.getMonster();
				monsterAnimations[i] = new Animation (200, monsters[i].getMonster_anim());
				monsterThreads.add(monstart(i));
			}
		}
		else{
			numEnemy = 3;
			for (int k = 0 ; k < 3; k++){
				monsters[k] = monsterManager.getBoss(stateID, k);
				System.out.println(monsters[k]);
				System.out.println(monsters[k].getMonster_dex());
				monsterAnimations[k] = new Animation (200, monsters[k].getMonster_anim());
				monsterThreads.add(monstart(k));
			}
		}
		
		skillsCombos = new int[6][3];
		playerCombo = new int [3];
		generateCombos();
		
	}
	
	@SuppressWarnings("deprecation")
	public void tick(){
		boolean win = true;
		for (int j = 0 ; j < numEnemy ; j++){ //true if dead
			if (!deadEnemy[j]) //if any alive(false)
				win = false; 
		}
		if (win){
			for (Thread t: monsterThreads)
				t.stop();
			//exp function + update variables
			winBattle();
			if (stateID == 1)
				handler.getData().setCastle_key(true);
			handler.toWorld();
		}
		boolean lose = true;
		for (boolean b: deadAlly){ //true if dead
			if (!b) //if any alive(false)
				lose = false; 
		}
		if (lose){
			for (Thread t: monsterThreads)
				t.stop();
			//reset in town function
			loseBattle();
			handler.toWorld();
		}
		animLeft1.tick();
		animLeft2.tick();
		animLeft3.tick();
		animLeft4.tick();
		for (int i = 0; i < numEnemy; i++){
			monsterAnimations[i].tick();
		}
		if (playerTarget==0 && enemyTarget ==0){
			if (handler.getKeyManager().isBackr()){
				comboNum -= 1;
				if (comboNum < 0)
					comboNum = 0;
				handler.getKeyManager().setBackr(false);
			}
			if (handler.getKeyManager().isUpr() && comboNum <3){
				playerCombo[comboNum] = 1;
				comboNum += 1;
				handler.getKeyManager().setUpr(false);
			}
			else if (handler.getKeyManager().isDownr() && comboNum <3){
				playerCombo[comboNum] = 2;
				comboNum += 1;
				handler.getKeyManager().setDownr(false);
			}
			else if (handler.getKeyManager().isLeftr() && comboNum <3){
				playerCombo[comboNum] = 3;
				comboNum += 1;
				handler.getKeyManager().setLeftr(false);
			}
			else if (handler.getKeyManager().isRightr() && comboNum <3){
				playerCombo[comboNum] = 4;
				comboNum += 1;
				handler.getKeyManager().setRightr(false);
			}
			if (handler.getKeyManager().isSelectr()){ //player makes move
				makePlayerMove();
				skillsCombos = new int[6][3];
				playerCombo = new int [3];
				comboNum = 0;
				generateCombos();
				handler.getKeyManager().setSelectr(false);
			}
		}
		else{
			if (handler.getKeyManager().isSelectr() || playerTarget == 9 || enemyTarget == 9){
				executePlayerMove();
				do{
					activePlayer += 1;
					if (activePlayer == 5)
						activePlayer = 1;
				}
				while (deadAlly[activePlayer-1] == true);
				playerTarget = 0;
				enemyTarget = 0;
				handler.getKeyManager().setSelectr(false);
			}
			if (handler.getKeyManager().isUpr()){
				if (playerTarget == 0){
					do{
						enemyTarget -= 1;
						if (enemyTarget == 0)
							enemyTarget = numEnemy;
						}
					while(deadEnemy[enemyTarget-1]);
				}
				else if (enemyTarget == 0){
					do{
						playerTarget -= 1;
						if (playerTarget == 0)
							playerTarget = 4;
						}
					while(deadAlly[playerTarget - 1]);
				}
				handler.getKeyManager().setUpr(false);
			}
			if (handler.getKeyManager().isDownr()){
				if (playerTarget == 0){
					do{
						enemyTarget += 1;
						if (enemyTarget == numEnemy+1)
							enemyTarget = 1;
						}
					while(deadEnemy[enemyTarget-1]);
				}
				else if (enemyTarget == 0){
					do{
						playerTarget += 1;
						if (playerTarget == 5)
							playerTarget = 1;
						}
					while(deadAlly[playerTarget - 1]);
				}
				handler.getKeyManager().setDownr(false);
			}

		}
	}
	
	@Override
	public void render(Graphics g){
		g.drawImage(background, 0, 0, 800, 459, null);
		g.drawImage(getBattleMenu(), 0, 0, 800, 600, null);
		drawCharacters(g);
		drawMonsters(g);
		drawOptions(g);
		drawCombo(g);
		drawPlayerMove(g);
	}
	
	@SuppressWarnings("deprecation")
	private void makePlayerMove(){
		for (int x=0; x < 6; x++){
			System.out.println("largest x = " + (x));
			System.out.println("combo run = " + Arrays.toString(skillsCombos[runAway]));
			System.out.println("combo move = " + Arrays.toString(playerCombo));
			if(Arrays.equals(skillsCombos[x], playerCombo)){
				System.out.println("The combo is matched");
				System.out.println("x = " + x);
				System.out.println("runAway = " + runAway);
				if (x == 0){
					enemyTarget = 1;
					while (deadEnemy[enemyTarget-1])
						enemyTarget += 1;
					skillID = 1;
					System.out.println("Now targetting enemy");
				}
				else if (x == runAway){
					System.out.println("RUN AWAY");
					if (Math.random() < Math.random()){
						for (Thread t: monsterThreads)
							t.stop();
						handler.toWorld(); //go back to game state without changing anything
					}
				}
				else{
					int move = handler.getSkillManager().getSkillTarget(playerJobs[activePlayer - 1], x-1);
					System.out.println("PlayerJob = "+playerJobs[activePlayer - 1]+" skillnum = "+(x-1));
					skillID = handler.getSkillManager().getSkillID(playerJobs[activePlayer - 1], x-1);
					if (move == 1){
						enemyTarget = 1;
						while (deadEnemy[enemyTarget-1])
							enemyTarget += 1;
						System.out.println("now targetting enemy");
					}
					else if (move == 2){
						playerTarget = 1;
						while (deadAlly[playerTarget-1])
							playerTarget += 1; //should nvr go full circle
						System.out.println("now targetting ally");
					}
					else if (move == 3){
						enemyTarget = 9;
						System.out.println("now targetting all enemies");
					}
					else if (move == 4){
						playerTarget = 9;
						System.out.println("now targetting all allies");
					}
				}
			}
		}
	}
	
	private void executePlayerMove(){ // this will be updated
		//calculated dmg of player without defense
		int skilldmg = playerDmg();
		
		if (playerTarget == 1 || playerTarget == 9){
			// attack variable between 80% and 120%
			double attackVariable = Math.random()*0.4 + 0.8;
			// crit chance
			int crit = 1;
			if (Math.random() < p_crit) // updated in playerDmg function
				crit = 2;
			int hp = handler.getData().getPlayer1_currHp();
			hp+= skilldmg*crit*attackVariable;
			handler.getData().setPlayer1_currHp(hp);
		}
		if (playerTarget == 2 || playerTarget == 9){
			// attack variable between 80% and 120%
			double attackVariable = Math.random()*0.4 + 0.8;
			// crit chance
			int crit = 1;
			if (Math.random() < p_crit) // updated in playerDmg function
				crit = 2;
			int hp = handler.getData().getPlayer2_currHp();
			hp+= skilldmg*crit*attackVariable;
			handler.getData().setPlayer2_currHp(hp);
		}
		if (playerTarget == 3 || playerTarget == 9){
			// attack variable between 80% and 120%
			double attackVariable = Math.random()*0.4 + 0.8;
			// crit chance
			int crit = 1;
			if (Math.random() < p_crit) // updated in playerDmg function
				crit = 2;
			int hp = handler.getData().getPlayer3_currHp();
			hp+= skilldmg*crit*attackVariable;
			handler.getData().setPlayer3_currHp(hp);
		}
		if (playerTarget == 4 || playerTarget == 9){
			// attack variable between 80% and 120%
			double attackVariable = Math.random()*0.4 + 0.8;
			// crit chance
			int crit = 1;
			if (Math.random() < p_crit/100) // updated in playerDmg function
				crit = 2;
			int hp = handler.getData().getPlayer4_currHp();
			hp+= skilldmg*crit*attackVariable;
			handler.getData().setPlayer4_currHp(hp);
		}
		if (enemyTarget == 9){
			for (int i = 0; i < numEnemy; i++){
				// attack variable between 80% and 120%
				//double attackVariable = Math.random()*0.4 + 0.8;
				// crit chance
//				int crit = 1;
//				if (Math.random() < p_crit) // updated in playerDmg function
//					crit = 2;
				int hp = monsters[i].getMonster_currHp();
				if (p_magic)
				{
					double def = monsters[i].getMonster_mdef();
					hp -= (Math.max(((double) (skilldmg) - 0.5*def),0))*(1-(def/200))/3;
				}
				else
				{
					double def = monsters[i].getMonster_mdef();
					hp -= (Math.max(((double) (skilldmg) - 0.5*def),0))*(1-(def/200))/3;
					}
				if (hp <= 0)
					deadEnemy[i] = true;
				monsters[i].setMonster_currHp(hp);
			}
		}
		else if (enemyTarget != 0){
			// attack variable between 80% and 120%
			double attackVariable = Math.random()*0.4 + 0.8;
			// crit chance
			int crit = 1;
			if (Math.random() < p_crit) // updated in playerDmg function
				crit = 2;
			int hp = monsters[enemyTarget - 1].getMonster_currHp();
			if (p_magic)
				hp -= (skilldmg-monsters[enemyTarget - 1].getMonster_mdef())*crit*attackVariable;
			else
				hp -= (Math.max(skilldmg-monsters[enemyTarget -1].getMonster_pdef(),0))*crit*attackVariable;
			if (hp <= 0)
				deadEnemy[enemyTarget-1] = true;
			monsters[enemyTarget - 1].setMonster_currHp(hp);
		}
	}
	
	private BufferedImage[] getCharAnim(int CharID){
		if (CharID == 2)
			return Assets.ranger_left;
		else if (CharID == 3)
			return Assets.knight_left;
		else if (CharID == 4)
			return Assets.magician_left;
		else if (CharID == 5)
			return Assets.pirate_left;
		else if (CharID == 6)
			return Assets.ninja_left;
		else
			return Assets.ranger_left;
	}
	
	private BufferedImage getBackground (){
		if (TileID == 11 || stateID == 1){
			return Assets.plainsBG;
		}
		else if (TileID == 21 || stateID == 2){
			return Assets.forestBG;
		}
		else if (TileID == 31 || stateID == 3){
			return Assets.desertBG;
		}
		else if (TileID == 41 || stateID == 4){
			return Assets.seaBG;
		}
		else if (TileID == 51 || stateID == 5){
			return Assets.tundraBG;
		}
		return Assets.plainsBG;
	}
	
	private BufferedImage getBattleMenu(){
		if (activePlayer == 1){
			return Assets.player1_battle;
		}
		else if (activePlayer == 2){
			return Assets.player2_battle;
		}
		else if (activePlayer == 3){
			return Assets.player3_battle;
		}
		return Assets.player4_battle;
	}
	
	private void drawMonsters(Graphics g){
		for (int i = 0; i < numEnemy; i++){
			if(monsters[i].getMonster_currHp() != 0){
				g.drawImage(monsterAnimations[i].getCurrentFrame(),280-i*50,160+i*70,64,64,null);
				g.setFont(new Font("HelveticaNeue", Font.BOLD, 14));
				g.setColor(Color.black);  // Empty Bar
				g.fillRect(160-i*50,200+i*70, 102, 8);
				drawBorderString(g,monsters[i].getMonster_name(), 160-i*50, 182+i*70, 2);
				drawBorderString(g,"HP: "+monsters[i].getMonster_currHp()+" / "+monsters[i].getMonster_hp(),160-i*50, 197+i*70, 1);
				g.setColor(new Color (0,157,41)); //HP bar green
				g.fillRect(161-i*50,201+i*70, 100*monsters[i].getMonster_currHp()/monsters[i].getMonster_hp(), 6);
			}
		}
	}
	
	private void drawPlayerMove(Graphics g){
		if (playerTarget != 0){
			g.drawImage(Assets.selectionArrow, 490+50*playerTarget, 70+70*playerTarget,20,20,null);
		}
		else if (enemyTarget != 0){
			g.drawImage(Assets.selectionArrow, 350-50*enemyTarget, 70+70*enemyTarget,20,20,null);
		}
	}
	
	private void drawCharacters (Graphics g){
		g.setFont(new Font("HelveticaNeue", Font.BOLD, 16));
		
		g.drawString(handler.getData().getPlayer1_name(), 140, 500); //x + 80 y + 30
		if (handler.getData().getPlayer1_currHp() != 0){
			g.drawImage(animLeft1.getCurrentFrame(), 520, 160, 64, 64, null);
		}
		
		g.drawString(handler.getData().getPlayer2_name(), 140, 527);
		if (handler.getData().getPlayer2_currHp() != 0){
			g.drawImage(animLeft2.getCurrentFrame(), 570, 230, 64, 64, null);
		}
		
		g.drawString(handler.getData().getPlayer3_name(), 140, 554);
		if (handler.getData().getPlayer3_currHp() != 0){
			g.drawImage(animLeft3.getCurrentFrame(), 620, 300, 64, 64, null);
		}
		
		g.drawString(handler.getData().getPlayer4_name(), 140, 581);
		if (handler.getData().getPlayer4_currHp() != 0){
			g.drawImage(animLeft4.getCurrentFrame(), 670, 370, 64, 64, null);
		}
			
		g.setFont(new Font("HelveticaNeue", Font.BOLD, 14));
		g.setColor(Color.black);  // Empty Bar
		for (int x= 0; x <2 ; x ++){
			for (int y = 0; y < 4; y++){
				g.fillRect(x*110+209, y*27+494, 102, 8);
			}
		}
		
		
		g.setColor(new Color (0,157,41)); // HP bar Purple
		drawBorderString(g,"HP: "+handler.getData().getPlayer1_currHp()+" / "+handler.getData().getPlayer1_hp(), 210, 493,1);
		g.fillRect(210, 495, (100*handler.getData().getPlayer1_currHp()/handler.getData().getPlayer1_hp()), 6);
		drawBorderString(g,"HP: "+handler.getData().getPlayer2_currHp()+" / "+handler.getData().getPlayer2_hp(), 210, 27+493,1);
		g.fillRect(210, 27+495, (100*handler.getData().getPlayer2_currHp()/handler.getData().getPlayer2_hp()), 6);
		drawBorderString(g,"HP: "+handler.getData().getPlayer3_currHp()+" / "+handler.getData().getPlayer3_hp(), 210, 54+493,1);
		g.fillRect(210, 54+495, (100*handler.getData().getPlayer3_currHp()/handler.getData().getPlayer3_hp()), 6);
		drawBorderString(g,"HP: "+handler.getData().getPlayer4_currHp()+" / "+handler.getData().getPlayer4_hp(), 210, 81+493,1);
		g.fillRect(210, 81+495, (100*handler.getData().getPlayer4_currHp()/handler.getData().getPlayer4_hp()), 6);
		
		g.setColor(new Color (57,190,230)); //MP bar Yellow
		drawBorderString(g,"MP: "+handler.getData().getPlayer1_currMp()+" / "+handler.getData().getPlayer1_mp(), 320, 493,2);
		g.fillRect(320, 495, (100*handler.getData().getPlayer1_currMp()/handler.getData().getPlayer1_mp()), 6);
		drawBorderString(g,"MP: "+handler.getData().getPlayer2_currMp()+" / "+handler.getData().getPlayer2_mp(), 320, 27+493,2);
		g.fillRect(320, 27+495, (100*handler.getData().getPlayer2_currMp()/handler.getData().getPlayer2_mp()), 6);
		drawBorderString(g,"MP: "+handler.getData().getPlayer3_currMp()+" / "+handler.getData().getPlayer3_mp(), 320, 54+493,2);
		g.fillRect(320, 54+495, (100*handler.getData().getPlayer3_currMp()/handler.getData().getPlayer3_mp()), 6);
		drawBorderString(g,"MP: "+handler.getData().getPlayer4_currMp()+" / "+handler.getData().getPlayer4_mp(), 320, 81+493,2);
		g.fillRect(320, 81+495, (100*handler.getData().getPlayer4_currMp()/handler.getData().getPlayer4_mp()), 6);

	}
	private void drawBorderString(Graphics g,String string,int x, int y, int color){
		g.setColor(new Color (41,36,24));
		g.drawString(string, x+1, y+1);
		g.drawString(string, x-1, y-1);
		g.drawString(string, x+1, y-1);
		g.drawString(string, x-1, y+1);
		g.drawString(string, x+1, y);
		g.drawString(string, x-1, y);
		g.drawString(string, x, y-1);
		g.drawString(string, x, y+1);
		if (color == 1)
			g.setColor(new Color (98,198,82)); // HP bar Green
		else if (color == 2)
			g.setColor(new Color (57,190,230)); //MP bar Blue
		g.drawString(string, x, y);
	}
	
	private void drawOptions(Graphics g){
		runAway = 0;
		int job = playerJobs[activePlayer-1];
		int counter = 1;
		skillNames[0] = "Attack";
		
		for (int i = 0; i < getOptions(handler.getData().getLevel()); i++){
			if (handler.getSkillManager().getSkillType(job, i)){
				skillNames[counter] = handler.getSkillManager().getSkillName(job, i);
				counter += 1;
			}
		}
		skillNames[counter] = "Run";
		runAway = counter;
		
		for (int x = 0; x < counter + 1; x++){
			drawBorderString(g, skillNames[x], 540, 485 + 20*x ,1);
			for (int y = 0; y < 3; y++){
				//drawBorderString(g, String.valueOf(skillsCombos[x][y]),700+30*y,485 + 20*x,1);
				g.drawImage(Assets.battleArrowsOutlined[skillsCombos[x][y] - 1], 693+30*y,471 + 20*x,20,20, null);
			}
		}
	}
	
	private void drawCombo(Graphics g){
		//g.setColor(new Color (148,129,82));
		//g.fillRect(365, 429, 150, 30);
		drawBorderString(g, "Combo: ", 515,449,2);
		for (int x = 0; x < comboNum; x++){
			g.drawImage(Assets.battleArrowsOutlined[playerCombo[x]-1], 570+30*x, 434,23,23, null);
		}
	}
	
	private Thread monstart(int i){
		Thread t = new Thread()
		{
			@Override
			public void run()
			{
				//monsterAttack();
				while(monsters[i].getMonster_currHp() > 0){
					
					double randomAttack = Math.random();
					// attack variable between 80% and 120%
					double attackVariable = Math.random()*0.4 + 0.8;
					// crit chance
					int crit = 1;
					if (Math.random() < monsters[i].getMonster_crit())
						crit = 2;
					if (randomAttack < 0.25 && !deadAlly[0]){
						int dmg = monDmg(i,1);
						dmg = (int) (dmg * attackVariable * crit);
						int hp = handler.getData().getPlayer1_currHp();
						hp -= dmg;
						if (hp<=0)
							deadAlly[0] = true;
						handler.getData().setPlayer1_currHp(hp);
					}
					else if (randomAttack < 0.50 && !deadAlly[1]){
						int dmg = monDmg(i,2);
						dmg = (int) (dmg * attackVariable * crit);
						int hp = handler.getData().getPlayer2_currHp();
						hp -= dmg;
						if (hp<=0)
							deadAlly[1] = true;
						handler.getData().setPlayer2_currHp(hp);
					}
					else if (randomAttack < 0.75 && !deadAlly[2]){
						int dmg = monDmg(i,3);
						dmg = (int) (dmg * attackVariable * crit);
						int hp = handler.getData().getPlayer3_currHp();
						hp -= dmg;
						if (hp<=0)
							deadAlly[2] = true;
						handler.getData().setPlayer3_currHp(hp);
					}
					else{
						int dmg = monDmg(i,4);
						dmg = (int) (dmg * attackVariable * crit);
						int hp = handler.getData().getPlayer4_currHp();
						hp -= dmg;
						if (hp<=0)
							deadAlly[3] = true;
						handler.getData().setPlayer4_currHp(hp);
					}
					try {
						double threadrandom = Math.random()*0.4+.08;
						Thread.sleep((long) (monsters[i].getAttack_delay()*threadrandom*1000));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
		return t;
	}
	
	private int playerDmg (){
		int p_dmg = 0;
		int str = 0;
		int m_dmg = 0;
		int def = 0;
		int intel = 0;
		int dex = 0;
		double dmg = 0;
		p_crit = 0;
		p_magic = false;
		if (activePlayer == 1){
			p_dmg = handler.getData().getPlayer1_patk();
			str = handler.getData().getPlayer1_str();
			p_crit = handler.getData().getPlayer1_crit()/100.0;
		}
		
		else if (activePlayer == 2){
			p_dmg = handler.getData().getPlayer2_patk();
			m_dmg = handler.getData().getPlayer2_matk();
			def = handler.getData().getPlayer2_pdef();
			intel = handler.getData().getPlayer2_int();
			dex = handler.getData().getPlayer2_dex();
			p_crit = handler.getData().getPlayer2_crit()/100.0;
		}
		else if (activePlayer == 3){
			p_dmg = handler.getData().getPlayer3_patk();
			m_dmg = handler.getData().getPlayer3_matk();
			def = handler.getData().getPlayer3_pdef();
			intel = handler.getData().getPlayer3_int();
			dex = handler.getData().getPlayer3_dex();
			p_crit = handler.getData().getPlayer3_crit()/100.0;
		}
		else if (activePlayer == 4){
			p_dmg = handler.getData().getPlayer4_patk();
			m_dmg = handler.getData().getPlayer4_matk();
			def = handler.getData().getPlayer4_pdef();
			intel = handler.getData().getPlayer4_int();
			dex = handler.getData().getPlayer4_dex();
			p_crit = handler.getData().getPlayer4_crit()/100.0;
		}
		
		//heal 40hp
		if (skillID == 0){
			return 40;
		}
		//normal attack
		else if (skillID == 1){
			if (m_dmg > p_dmg){
				p_magic = true;
				dmg = m_dmg;
			}
			dmg = p_dmg;
		}
		else if (skillID == 11){
			dmg = p_dmg*2;
		}
		else if (skillID == 12){
			dmg = str*2;
		}
		else if (skillID == 13){
			dmg = 2.5*p_dmg;
		}
		else if (skillID == 21){
			dmg = p_dmg*0.5;
		}
		else if (skillID == 22){
			dmg = p_dmg*0.7;
		}
		else if (skillID == 23){
			dmg = 0.7*p_dmg;
		}
		else if (skillID == 32){
			dmg = p_dmg+def;
		}
		else if (skillID == 33){
			dmg = p_dmg+3*def;
		}
		else if (skillID == 41){
			dmg = m_dmg*2;
			p_magic = true;
		}
		else if (skillID == 42){
			dmg = 2.5*intel;
		}
		else if (skillID == 43){
			dmg = 2.5*m_dmg;
			p_magic = true;
		}
		else if (skillID == 51){
			dmg = p_dmg*1.8;
		}
		else if (skillID == 52){
			dmg = p_dmg;
		}
		else if (skillID == 61){
			dmg = (dex+intel)*3;
		}
		else if (skillID == 62){
			dmg = p_dmg*4;
		}
		else if (skillID == 63){
			dmg = 6*m_dmg;
		}
		System.out.println("skillID = "+skillID);
		System.out.println("dmg = "+dmg);
		return (int) dmg;
	}
	
	private int monDmg (int monster, int player){
		boolean magicAttack = false;
		int monDmg = 0;
		if (monsters[monster].getMonster_matk() > monsters[monster].getMonster_patk()){
			magicAttack = true;
			monDmg = monsters[monster].getMonster_matk();
		}
		else{
			monDmg = monsters[monster].getMonster_patk();
		}
		if (magicAttack){
			if (player == 1){
				double def = handler.getData().getPlayer1_mdef();
				monDmg -= (Math.max(((double) (monDmg) - 0.5*def),0))*(1-(def/200))/3;
			}
			else if (player == 2){
				double def = handler.getData().getPlayer2_mdef();
				monDmg -= (Math.max(((double) (monDmg) - 0.5*def),0))*(1-(def/200))/3;
			}
			else if (player == 3){
				double def = handler.getData().getPlayer3_mdef();
				monDmg -= (Math.max(((double) (monDmg) - 0.5*def),0))*(1-(def/200))/3;
			}
			else if (player == 4){
				double def = handler.getData().getPlayer3_mdef();
				monDmg -= (Math.max(((double) (monDmg) - 0.5*def),0))*(1-(def/200))/3;
			}
		}
		else{
			if (player == 1){
				double def = handler.getData().getPlayer1_pdef();
				monDmg -= (Math.max(((double) (monDmg) - 0.5*def),0))*(1-(def/200))/3;
			}
			else if (player == 2){
				double def = handler.getData().getPlayer2_pdef();
				monDmg -= (Math.max(((double) (monDmg) - 0.5*def),0))*(1-(def/200))/3;
			}
			else if (player == 3){
				double def = handler.getData().getPlayer3_pdef();
				monDmg -= (Math.max(((double) (monDmg) - 0.5*def),0))*(1-(def/200))/3;
			}
			else if (player == 4){
				double def = handler.getData().getPlayer3_pdef();
				monDmg -= (Math.max(((double) (monDmg) - 0.5*def),0))*(1-(def/200))/3;
			}
		}
		return Math.max(monDmg, 0);
	}
	
	private int getOptions (int level){
		if (level < 3)
			return 2;
		else if (level < 6)
			return 3;
		else if (level < 9)
			return 4;
		else if (level < 12)
			return 5;
		return 6;
	}
	
	private void generateCombos(){
		for (int x = 0; x < 6; x++){
			for (int y = 0; y < 3; y++){
				double r = Math.random();
				if (r < 0.25)
					skillsCombos [x][y] = 1;
				else if (r < 0.5)
					skillsCombos [x][y] = 2;
				else if (r < 0.75)
					skillsCombos [x][y] = 3;
				else
					skillsCombos [x][y] = 4;
			}
			
		}
		for (int x = 0; x < 5; x++){
			for (int y = x+1; y < 6; y++){
				if (Arrays.equals(skillsCombos[x], skillsCombos[y])){
					generateCombos();
					break;
				}
			}
		}
	}
	
	private void loseBattle(){
		//lose 10% gold respawn nearest city
		if (TileID == 11){
			handler.getData().setStateID(1);
		}
		else if (TileID == 21 || TileID == 22){
			handler.getData().setStateID(2);
		}
		else if (TileID == 31 || TileID == 32){
			handler.getData().setStateID(3);
		}
		else if (TileID == 41 || TileID == 42){
			handler.getData().setStateID(4);
		}
		else if (TileID == 51 || TileID == 52){
			handler.getData().setStateID(5);
		}
		handler.getData().setX_coord(11);
		handler.getData().setY_coord(11);
		handler.getData().setPlayer1_currHp(handler.getData().getPlayer1_hp()/2);
		handler.getData().setPlayer2_currHp(handler.getData().getPlayer2_hp()/2);
		handler.getData().setPlayer3_currHp(handler.getData().getPlayer3_hp()/2);
		handler.getData().setPlayer4_currHp(handler.getData().getPlayer4_hp()/2);
		handler.getData().setPlayer1_currMp(handler.getData().getPlayer1_mp()/2);
		handler.getData().setPlayer2_currMp(handler.getData().getPlayer2_mp()/2);
		handler.getData().setPlayer3_currMp(handler.getData().getPlayer3_mp()/2);
		handler.getData().setPlayer4_currMp(handler.getData().getPlayer4_mp()/2);
	}
	private void winBattle(){
		//update boss drops
		if (stateID == 1)
			handler.getData().setBug_spray(true);
		else if (stateID == 2)
			handler.getData().setSun_block(true);
		else if (stateID == 3)
			handler.getData().setFerry_pass(true);
		else if (stateID == 4)
			handler.getData().setWinter_wear(true);
		int monExp = 0;
		String path = handler.getData().getPath(); //store path to save file
		for (int i = 0 ; i<numEnemy ; i++){
			monExp += monsters[i].getMonster_exp();
		}
		int o_level = handler.getData().getLevel();
		int exp = handler.getData().getEXP();
		handler.getData().setEXP(exp+monExp);
		int n_level = handler.getData().getLevel();
		if (n_level > o_level){
			Loader newLoad = handler.getData().levelUp(); // create temporary save file
			newLoad.setPath(path); //change path back to permanent save file
			handler.setData(newLoad);
		}
		int gold = handler.getData().getGold();
		gold += (int) ((double) (monExp) *0.65);
		handler.getData().setGold(gold);
	}
	
	@Override
	public int getStateID(){
		return stateID;
	}
	
	@Override
	public Player getPlayer(){
		return null;
	}
}
