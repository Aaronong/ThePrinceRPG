package gameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import data.Loader;
import entities.EntityManager;
import entities.Player;
import gfx.Animation;
import gfx.Assets;
import thePrinceGame.Handler;
import thePrinceMain.Game;

public class MenuState extends State {

	// need to find a way  to make the delay work
	private int stateID;
	private int Menu = 0;  // 0 = main menu, 1 = load menu, 2 = chac menu
	private boolean arrow = true; //top/bottom position
	private int character = 0; //in mod 4, returns one of the four heroes
	private int status = 0; // in mod 3, stats inventory skills
	private int save = 1;
	private int stats = 0; // in mod 4, str dex int vit
	private int items = 0; // in mod 3, pri sec armour
	private int skills = 7; // in mod 5, skl 1,2,3,4,5
	private EntityManager entityManager;
	private Animation animDown1;
	private Animation animDown2;
	private Animation animDown3;
	private Animation animDown4;
	
	
	public MenuState(Handler handler){
		super(handler);
		stateID = 6;
		entityManager = new EntityManager(handler, null);
		animDown1 = new Animation(200, Assets.player_down);
		animDown2 = new Animation(200, getCharAnim(handler.getData().getPlayer2_job()));
		animDown3 = new Animation(200, getCharAnim(handler.getData().getPlayer3_job()));
		animDown4 = new Animation(200, getCharAnim(handler.getData().getPlayer4_job()));
		handler.getKeyManager().setUpr(false);
		handler.getKeyManager().setDownr(false);
		handler.getKeyManager().setLeftr(false);
		handler.getKeyManager().setRightr(false);
		handler.getKeyManager().setSelectr(false);
		handler.getKeyManager().setBackr(false);
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		animDown1.tick();
		animDown2.tick();
		animDown3.tick();
		animDown4.tick();
		
		if (Menu == 0){
			if (handler.getKeyManager().isUpr() || handler.getKeyManager().isDownr()){
				arrow = !arrow;
				handler.getKeyManager().setUpr(false);
				handler.getKeyManager().setDownr(false);
			}
				
			else if (handler.getKeyManager().isSelectr()){
				if (arrow)
					Menu = 1;
				else
					Menu = 2;
				handler.getKeyManager().setSelectr(false);
			}
			else if (handler.getKeyManager().isBackr()){
				handler.toWorld();
				handler.getKeyManager().setBackr(false);
			}
		}
		if (Menu == 1){
			if (handler.getKeyManager().isRightr()){
				save += 1;
				if (save == 5)
					save = 1;
				handler.getKeyManager().setRightr(false);
			}
			if (handler.getKeyManager().isDownr()){
				save += 2;
				if (save >= 5)
					save -= 4;
				handler.getKeyManager().setDownr(false);
			}
			if (handler.getKeyManager().isUpr()){
				save -= 2;
				if (save <= 0)
					save += 4;
				handler.getKeyManager().setUpr(false);
			}
			if (handler.getKeyManager().isLeftr()){
				save -= 1;
				if (save == 0)
					save = 4;
				handler.getKeyManager().setLeftr(false);
			}
			if (handler.getKeyManager().isBackr()){
				Menu = 0;
				handler.getKeyManager().setBackr(false);
			}
			if (handler.getKeyManager().isSelectr()){
				if (save == 1)
					handler.getData().saveData(handler.getData().getPath());
				else if (save == 2){
					Loader loadFile = new Loader("res/saveFiles/saveState1.txt");
					handler.setData(loadFile);
				}
				else if (save == 3){
					handler.getData().saveData(handler.getData().getPath());
					System.exit(0);
				}
				else if (save == 4){
					System.exit(0);
				}
				handler.getKeyManager().setSelectr(false);
			}
		}
		if (Menu == 2){
			if (status == 0) // This is the default character page, Stats
			{
				if (stats == 0) // 0 is when no stats is selected
				{
					if (handler.getKeyManager().isBackr())
					{
						Menu = 0;
						handler.getKeyManager().setBackr(false);
					}
					if (handler.getKeyManager().isSelectr()){
						stats = 1;
						handler.getKeyManager().setSelectr(false);
					}
					if (handler.getKeyManager().isRightr())
					{
						character += 1;
						if (character == 4)
							character = 0;
						handler.getKeyManager().setRightr(false);
					}
					if (handler.getKeyManager().isLeftr()){
						character -= 1;
						if (character == -1)
							character = 3;
						handler.getKeyManager().setLeftr(false);
					}
					if (handler.getKeyManager().isUpr()){ //up go to skill
						status -= 1;
						if (status == -1)
							status = 2;
						handler.getKeyManager().setUpr(false);
					}
					if (handler.getKeyManager().isDownr()){ //down go to inventory
						status += 1;
						if (status == 3)
							status = 0;
						handler.getKeyManager().setDownr(false);
					}
				}
				else{ //One of the stats str, dex, int, vit selected
	
					if (handler.getKeyManager().isUpr() || handler.getKeyManager().isDownr()){
						stats += 2;
						handler.getKeyManager().setUpr(false);
						handler.getKeyManager().setDownr(false);
					}
					else if (handler.getKeyManager().isRightr())
					{
						stats += 1;
						handler.getKeyManager().setRightr(false);
					}
					else if (handler.getKeyManager().isLeftr()){
						stats -= 1;
						handler.getKeyManager().setLeftr(false);
					}
					if (stats > 4)
						stats -= 4;
					else if (stats<1)
						stats += 4;
					if (handler.getKeyManager().isBackr())
					{
						stats = 0;
						handler.getKeyManager().setBackr(false);
					}
				}
			}
			if (status == 1) // This is the inventory page
			{
				if (items == 0) // no item selected
				{
					if (handler.getKeyManager().isBackr())
					{
						Menu = 0;
						handler.getKeyManager().setBackr(false);
					}
					if (handler.getKeyManager().isSelectr()){
						stats = 1;
						handler.getKeyManager().setSelectr(false);
					}
					if (handler.getKeyManager().isRightr())
					{
						character += 1;
						if (character == 4)
							character = 0;
						handler.getKeyManager().setRightr(false);
					}
					if (handler.getKeyManager().isLeftr()){
						character -= 1;
						if (character == -1)
							character = 3;
						handler.getKeyManager().setLeftr(false);
					}
					if (handler.getKeyManager().isUpr()){ //up go to skill
						status -= 1;
						if (status == -1)
							status = 2;
						handler.getKeyManager().setUpr(false);
					}
					if (handler.getKeyManager().isDownr()){ //down go to inventory
						status += 1;
						if (status == 3)
							status = 0;
						handler.getKeyManager().setDownr(false);
					}
				}
				else{ // item selecter 1,2,3 pri,sec,armour
					
				}
			}
			if (status == 2) // This is the skill page
			{
				if (skills == 7) // no skill selected
				{
					if (handler.getKeyManager().isBackr())
					{
						Menu = 0;
						handler.getKeyManager().setBackr(false);
					}
					if (handler.getKeyManager().isSelectr()){
						skills = 0;
						handler.getKeyManager().setSelectr(false);
					}
					if (handler.getKeyManager().isRightr())
					{
						character += 1;
						if (character == 4)
							character = 0;
						handler.getKeyManager().setRightr(false);
					}
					if (handler.getKeyManager().isLeftr()){
						character -= 1;
						if (character == -1)
							character = 3;
						handler.getKeyManager().setLeftr(false);
					}
					if (handler.getKeyManager().isUpr()){ //up go to skill
						status -= 1;
						if (status == -1)
							status = 2;
						handler.getKeyManager().setUpr(false);
					}
					if (handler.getKeyManager().isDownr()){ //down go to inventory
						status += 1;
						if (status == 3)
							status = 0;
						handler.getKeyManager().setDownr(false);
					}
				}
				else{ // skill selecter
					if (handler.getKeyManager().isRightr())
					{
						handler.getKeyManager().setRightr(false);
					}
					if (handler.getKeyManager().isLeftr()){
						handler.getKeyManager().setLeftr(false);
					}
					if (handler.getKeyManager().isUpr()){ //up go to skill
						skills -= 1;
						if (skills == -1)
							skills = 5;
						handler.getKeyManager().setUpr(false);
					}					
					if (handler.getKeyManager().isDownr()){ //up go to skill
						skills += 1;
						if (skills == 6)
							skills = 0;
						handler.getKeyManager().setDownr(false);
					}
					if (handler.getKeyManager().isBackr())
					{
						skills = 7;
						handler.getKeyManager().setBackr(false);
					}
					
				}
			}
		}
			
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		if (Menu == 1)
		{
			g.drawImage(Assets.menu1, 0,0, 800,600, null);
			g.drawImage(Assets.menuArrow,30, 200,30,30, null);
			
			g.setFont(new Font("Arial", Font.PLAIN, 20)); 
			g.setColor(new Color (244,212,0)); //yellow
			g.drawString("Gold: "+handler.getData().getGold(), 630, 40);
			drawCharacter(g,0,430,80);
			drawCharacter(g,1,430,180);
			drawCharacter(g,2,430,280);
			drawCharacter(g,3,430,380);
			if (save == 1)
				g.drawImage(Assets.menuArrow,420,487,30,30, null);
			else if (save == 2)
				g.drawImage(Assets.menuArrow,620,487,30,30, null);
			else if (save == 3)
				g.drawImage(Assets.menuArrow,420,527,30,30, null);
			else
				g.drawImage(Assets.menuArrow,620,527,30,30, null);
			//g.drawImage(animDown1.getCurrentFrame(), 430, 30, 64, 64, null);
			//g.drawImage(animDown2.getCurrentFrame(), 430, 130, 64, 64, null);
			//g.drawImage(animDown3.getCurrentFrame(), 430, 230, 64, 64, null);
			//g.drawImage(animDown4.getCurrentFrame(), 430, 330, 64, 64, null);
		}
		else if (Menu == 2)
		{
			g.drawImage(Assets.menu2, 0,0, 800,600, null);
			g.drawImage(Assets.menuArrow,30,370,30,30, null);
			drawCharacter(g,character,470,30);
			if (status == 0){ // draw stats
				g.drawImage(Assets.menuArrow,405,122,30,30, null);
				drawStatus(g);
				drawStats(g);
			}
			else if (status == 1){ // draw items
				g.drawImage(Assets.menuArrow,405,227,30,30, null);
				drawItems(g);
			}
			else if (status == 2){ // draw skills
				g.drawImage(Assets.menuArrow,405,332,30,30, null);
				drawSkills(g);
				drawSkillStats(g);
			}

		}
		else // Main menu, save/load or character info
		{
			g.drawImage(Assets.menu0, 0,0, 800,600, null);
			if (arrow)
				g.drawImage(Assets.menuArrow,30, 200,30,30, null);
			else
				g.drawImage(Assets.menuArrow,30, 370,30,30, null);
		}
		
	}
	
	@Override
	public int getStateID(){
		return stateID;
	}
	
	@Override
	public Player getPlayer(){
		return null;
	}
	
	private BufferedImage[] getCharAnim(int CharID){
		if (CharID == 2)
			return Assets.ranger_down;
		else if (CharID == 3)
			return Assets.knight_down;
		else if (CharID == 4)
			return Assets.magician_down;
		else if (CharID == 5)
			return Assets.pirate_down;
		else if (CharID == 6)
			return Assets.ninja_down;
		else
			return Assets.ranger_down;
	}
	
	private void drawCharacter (Graphics g, int CharID, int x, int y){
		g.setFont(new Font("HelveticaNeue", Font.PLAIN, 20)); 
		g.setColor(new Color(96,159,236)); //pale blue
		if (CharID == 0){
			g.drawImage(animDown1.getCurrentFrame(), x, y, 64, 64, null);
			g.drawString(handler.getData().getPlayer1_name(), x+80, y+30); //x + 80 y + 30
			g.setFont(new Font("HelveticaNeue", Font.BOLD, 14));
			g.drawString(handler.getData().getPlayer1_jobS()+" Lv. "+Integer.toString(handler.getData().getLevel()), x+80, y+50); //x + 80 y + 60
			g.setColor(new Color (32,32,64));  // Empty Bar
			g.fillRect(x+200, y+25, 100, 10);
			g.fillRect(x+200, y+55, 100, 10);
			g.setColor(new Color (178,0,255)); // HP bar Purple
			g.drawString("HP: "+handler.getData().getPlayer1_currHp()+" / "+handler.getData().getPlayer1_hp(), x+200, y+20);
			g.fillRect(x+200, y+25, (100*handler.getData().getPlayer1_currHp()/handler.getData().getPlayer1_hp()), 10);
			g.setColor(new Color (244,212,0)); //MP bar Yellow
			g.drawString("MP: "+handler.getData().getPlayer1_currMp()+" / "+handler.getData().getPlayer1_mp(), x+200, y+50);
			g.fillRect(x+200, y+55, (100*handler.getData().getPlayer1_currMp()/handler.getData().getPlayer1_mp()), 10);
		}
		else if (CharID == 1){
			g.drawImage(animDown2.getCurrentFrame(), x, y, 64, 64, null);
			g.drawString(handler.getData().getPlayer2_name(), x+80, y+30);
			g.setFont(new Font("HelveticaNeue", Font.BOLD, 14));
			g.drawString(handler.getData().getPlayer2_jobS()+" Lv. "+Integer.toString(handler.getData().getLevel()), x+80, y+50); //x + 80 y + 60
			g.setColor(new Color (32,32,64));  // Empty Bar
			g.fillRect(x+200, y+25, 100, 10);
			g.fillRect(x+200, y+55, 100, 10);
			g.setColor(new Color (178,0,255)); // HP bar Purple
			g.drawString("HP: "+handler.getData().getPlayer2_currHp()+" / "+handler.getData().getPlayer2_hp(), x+200, y+20);
			g.fillRect(x+200, y+25, (100*handler.getData().getPlayer2_currHp()/handler.getData().getPlayer2_hp()), 10);
			g.setColor(new Color (244,212,0)); //MP bar Yellow
			g.drawString("MP: "+handler.getData().getPlayer2_currMp()+" / "+handler.getData().getPlayer2_mp(), x+200, y+50);
			g.fillRect(x+200, y+55, (100*handler.getData().getPlayer2_currMp()/handler.getData().getPlayer2_mp()), 10);
		}
		else if (CharID == 2){
			g.drawImage(animDown3.getCurrentFrame(), x, y, 64, 64, null);
			g.drawString(handler.getData().getPlayer3_name(), x+80, y+30);
			g.setFont(new Font("HelveticaNeue", Font.BOLD, 14));
			g.drawString(handler.getData().getPlayer3_jobS()+" Lv. "+Integer.toString(handler.getData().getLevel()), x+80, y+50); //x + 80 y + 60
			g.setColor(new Color (32,32,64));  // Empty Bar
			g.fillRect(x+200, y+25, 100, 10);
			g.fillRect(x+200, y+55, 100, 10);
			g.setColor(new Color (178,0,255)); // HP bar Purple
			g.drawString("HP: "+handler.getData().getPlayer3_currHp()+" / "+handler.getData().getPlayer3_hp(), x+200, y+20);
			g.fillRect(x+200, y+25, (100*handler.getData().getPlayer3_currHp()/handler.getData().getPlayer3_hp()), 10);
			g.setColor(new Color (244,212,0)); //MP bar Yellow
			g.drawString("MP: "+handler.getData().getPlayer3_currMp()+" / "+handler.getData().getPlayer3_mp(), x+200, y+50);
			g.fillRect(x+200, y+55, (100*handler.getData().getPlayer3_currMp()/handler.getData().getPlayer3_mp()), 10);
		}
		else{
			g.drawImage(animDown4.getCurrentFrame(), x, y, 64, 64, null);
			g.drawString(handler.getData().getPlayer4_name(), x+80, y+30);
			g.setFont(new Font("HelveticaNeue", Font.BOLD, 14));
			g.drawString(handler.getData().getPlayer4_jobS()+" Lv. "+Integer.toString(handler.getData().getLevel()), x+80, y+50); //x + 80 y + 60
			g.setColor(new Color (32,32,64));  // Empty Bar
			g.fillRect(x+200, y+25, 100, 10);
			g.fillRect(x+200, y+55, 100, 10);
			g.setColor(new Color (178,0,255)); // HP bar Purple
			g.drawString("HP: "+handler.getData().getPlayer4_currHp()+" / "+handler.getData().getPlayer4_hp(), x+200, y+20);
			g.fillRect(x+200, y+25, (100*handler.getData().getPlayer4_currHp()/handler.getData().getPlayer4_hp()), 10);
			g.setColor(new Color (244,212,0)); //MP bar Yellow
			g.drawString("MP: "+handler.getData().getPlayer4_currMp()+" / "+handler.getData().getPlayer4_mp(), x+200, y+50);
			g.fillRect(x+200, y+55, (100*handler.getData().getPlayer4_currMp()/handler.getData().getPlayer4_mp()), 10);
		}

			
	}
	
	private void drawStatus(Graphics g){
		//uses character int
		g.setFont(new Font("Arial", Font.PLAIN, 20)); 
		g.setColor(new Color (244,212,0)); //yellow
		if (character == 0)
		{
			g.drawString("Str   "+Integer.toString(handler.getData().getPlayer1_str()), 520, 130);
			g.drawString("Dex   "+Integer.toString(handler.getData().getPlayer1_dex()), 620, 130);
			g.drawString("Int   "+Integer.toString(handler.getData().getPlayer1_int()), 520, 160);
			g.drawString("Vit    "+Integer.toString(handler.getData().getPlayer1_vit()), 622, 160);
			g.setColor(new Color (227,70,221)); // magenta
			g.drawString("HP    "+Integer.toString(handler.getData().getPlayer1_hp()), 520, 210);
			g.drawString("MP    "+Integer.toString(handler.getData().getPlayer1_mp()), 620, 210);
			g.drawString("P.Atk "+Integer.toString(handler.getData().getPlayer1_patk()), 519, 240);
			g.drawString("P.Def "+Integer.toString(handler.getData().getPlayer1_pdef()), 619, 240);
			g.drawString("M.Atk "+Integer.toString(handler.getData().getPlayer1_matk()), 520, 270);
			g.drawString("M.Def "+Integer.toString(handler.getData().getPlayer1_mdef()), 620, 270);
			g.drawString("Avoid "+Integer.toString(handler.getData().getPlayer1_avoid())+"%", 522, 300);
			g.drawString("Crit    "+Integer.toString(handler.getData().getPlayer1_crit())+"%", 620, 300);
			g.drawString("Primary: "+handler.getData().getPlayer1_pri(), 520, 340);
			g.drawString("Secondary: "+handler.getData().getPlayer1_sec(), 520, 370);
		}
		else if (character == 1)
		{
			g.drawString("Str "+Integer.toString(handler.getData().getPlayer2_str()), 520, 130);
			g.drawString("Dex "+Integer.toString(handler.getData().getPlayer2_dex()), 620, 130);
			g.drawString("Int "+Integer.toString(handler.getData().getPlayer2_int()), 520, 160);
			g.drawString("Vit  "+Integer.toString(handler.getData().getPlayer2_vit()), 622, 160);
			g.setColor(new Color (227,70,221));
			g.drawString("HP    "+Integer.toString(handler.getData().getPlayer2_hp()), 520, 210);
			g.drawString("MP    "+Integer.toString(handler.getData().getPlayer2_mp()), 620, 210);
			g.drawString("P.Atk "+Integer.toString(handler.getData().getPlayer2_patk()), 519, 240);
			g.drawString("P.Def "+Integer.toString(handler.getData().getPlayer2_pdef()), 619, 240);
			g.drawString("M.Atk "+Integer.toString(handler.getData().getPlayer2_matk()), 520, 270);
			g.drawString("M.Def "+Integer.toString(handler.getData().getPlayer2_mdef()), 620, 270);
			g.drawString("Avoid "+Integer.toString(handler.getData().getPlayer2_avoid())+"%", 522, 300);
			g.drawString("Crit    "+Integer.toString(handler.getData().getPlayer2_crit())+"%", 620, 300);

			g.drawString("Primary: "+handler.getData().getPlayer2_pri(), 520, 340);
			g.drawString("Secondary: "+handler.getData().getPlayer2_sec(), 520, 370);
		}
		else if (character == 2)
		{
			g.drawString("Str "+Integer.toString(handler.getData().getPlayer3_str()), 520, 130);
			g.drawString("Dex "+Integer.toString(handler.getData().getPlayer3_dex()), 620, 130);
			g.drawString("Int "+Integer.toString(handler.getData().getPlayer3_int()), 520, 160);
			g.drawString("Vit  "+Integer.toString(handler.getData().getPlayer3_vit()), 622, 160);
			g.setColor(new Color (227,70,221));
			g.drawString("HP    "+Integer.toString(handler.getData().getPlayer3_hp()), 520, 210);
			g.drawString("MP    "+Integer.toString(handler.getData().getPlayer3_mp()), 620, 210);
			g.drawString("P.Atk "+Integer.toString(handler.getData().getPlayer3_patk()), 519, 240);
			g.drawString("P.Def "+Integer.toString(handler.getData().getPlayer3_pdef()), 619, 240);
			g.drawString("M.Atk "+Integer.toString(handler.getData().getPlayer3_matk()), 520, 270);
			g.drawString("M.Def "+Integer.toString(handler.getData().getPlayer3_mdef()), 620, 270);
			g.drawString("Avoid "+Integer.toString(handler.getData().getPlayer3_avoid())+"%", 522, 300);
			g.drawString("Crit    "+Integer.toString(handler.getData().getPlayer3_crit())+"%", 620, 300);
			g.drawString("Primary: "+handler.getData().getPlayer3_pri(), 520, 340);
			g.drawString("Secondary: "+handler.getData().getPlayer3_sec(), 520, 370);
		}
		else
		{
			g.drawString("Str "+Integer.toString(handler.getData().getPlayer4_str()), 520, 130);
			g.drawString("Dex "+Integer.toString(handler.getData().getPlayer4_dex()), 620, 130);
			g.drawString("Int "+Integer.toString(handler.getData().getPlayer4_int()), 520, 160);
			g.drawString("Vit  "+Integer.toString(handler.getData().getPlayer4_vit()), 622, 160);
			g.setColor(new Color (227,70,221));
			g.drawString("HP    "+Integer.toString(handler.getData().getPlayer4_hp()), 520, 210);
			g.drawString("MP    "+Integer.toString(handler.getData().getPlayer4_mp()), 620, 210);
			g.drawString("P.Atk "+Integer.toString(handler.getData().getPlayer4_patk()), 519, 240);
			g.drawString("P.Def "+Integer.toString(handler.getData().getPlayer4_pdef()), 619, 240);
			g.drawString("M.Atk "+Integer.toString(handler.getData().getPlayer4_matk()), 520, 270);
			g.drawString("M.Def "+Integer.toString(handler.getData().getPlayer4_mdef()), 620, 270);
			g.drawString("Avoid "+Integer.toString(handler.getData().getPlayer4_avoid())+"%", 522, 300);
			g.drawString("Crit    "+Integer.toString(handler.getData().getPlayer4_crit())+"%", 620, 300);
			g.drawString("Primary: "+handler.getData().getPlayer4_pri(), 520, 340);
			g.drawString("Secondary: "+handler.getData().getPlayer4_sec(), 520, 370);
		}
	}
	
	private void drawSkillStats(Graphics g){
		g.setFont(new Font("Arial", Font.BOLD, 14));
		g.setColor(new Color(95,242,138)); //pale green
		if (skills != 7)
		{
			if (character == 0){
				
				for (int s = 0; s < 6; s++){
					if (skills == s){
						g.drawImage(Assets.menuArrow,480,132+40*s,20,20, null);
						g.drawString(handler.getSkillManager().getSkillDes(handler.getData().getPlayer1_job(), s), 475, 460);
					}
				}
			}
			else if (character == 1){
				
				for (int s = 0; s < 6; s++){
					if (skills == s){
						g.drawImage(Assets.menuArrow,480,132+40*s,20,20, null);
						g.drawString(handler.getSkillManager().getSkillDes(handler.getData().getPlayer2_job(), s), 475, 460);
					}
				}
			}
			else if (character == 2){
				
				for (int s = 0; s < 6; s++){
					if (skills == s){
						g.drawImage(Assets.menuArrow,480,132+40*s,20,20, null);
						g.drawString(handler.getSkillManager().getSkillDes(handler.getData().getPlayer3_job(), s), 475, 460);
					}
				}
			}
			else if (character == 3){
				
				for (int s = 0; s < 6; s++){
					if (skills == s){
						g.drawImage(Assets.menuArrow,480,132+40*s,20,20, null);
						g.drawString(handler.getSkillManager().getSkillDes(handler.getData().getPlayer4_job(), s), 475, 460);
					}
				}
			}
		}
	}
	
	private void drawStats(Graphics g){
		g.setFont(new Font("Arial", Font.BOLD, 14));
		g.setColor(new Color(95,242,138)); //pale green
		if (stats == 1)
		{
			g.drawImage(Assets.menuArrow,490,113,20,20, null);
			g.drawString("Str: + (1 P.Atk/0.2 Crit)", 475, 443);
			g.drawString("Pri: + (2.5 P.Atk/0.5 P.Def)", 475, 463);
			g.drawString("Sec: + (1.5 P.Atk)", 475, 483);
		}
		if (stats == 2)
		{
			g.drawImage(Assets.menuArrow,590,113,20,20, null);
			g.drawString("Dex: + (0.4 Crit/0.5 Avd)", 475, 443);
			g.drawString("Pri: + (2.5 P.Atk/0.3 Crit/0.2 Avd)", 475, 463);
			g.drawString("Sec: + (0.2% Crit)", 475, 483);
		}
		if (stats == 3)
		{
			g.drawImage(Assets.menuArrow,490,143,20,20, null);
			g.drawString("Int: + (3 MP/1 M.Atk/1 M.Def)", 475, 443);
			g.drawString("Pri: + (1.5 MP/2.5 M.Atk/1 M.Def)", 475, 463);
			g.drawString("Sec: + (1.5 P.Atk)", 475, 483);
		}
		if (stats == 4)
		{
			g.drawImage(Assets.menuArrow,590,143,20,20, null);
			g.drawString("Vit: + (5 HP/1 P.Def)", 475, 443);
			g.drawString("Pri: + (3 HP/1.5 P.Atk/1 P.Def)", 475, 463);
			g.drawString("Sec: + (2 HP)", 475, 483);
		}
	}
	
	private void drawSkills(Graphics g){
		g.setFont(new Font("Arial", Font.PLAIN, 20)); 
		g.setColor(new Color (227,70,221)); // Magenta
		if (character == 0){
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer1_job(), 0), 520, 150);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer1_job(), 1), 520, 190);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer1_job(), 2), 520, 230);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer1_job(), 3), 520, 270);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer1_job(), 4), 520, 310);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer1_job(), 5), 520, 350);
			g.setFont(new Font("Arial", Font.BOLD, 14));
			g.setColor(new Color (244,212,0)); //yellow
			g.drawString("Lv1. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer1_job(), 0), 670, 150);
			g.drawString("Lv1. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer1_job(), 1), 670, 190);
			g.drawString("Lv3. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer1_job(), 2), 670, 230);
			g.drawString("Lv6. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer1_job(), 3), 670, 270);
			g.drawString("Lv9. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer1_job(), 4), 670, 310);
			g.drawString("Lv12. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer1_job(), 5), 670, 350);
		}
		else if (character == 1){
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer2_job(), 0), 520, 150);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer2_job(), 1), 520, 190);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer2_job(), 2), 520, 230);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer2_job(), 3), 520, 270);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer2_job(), 4), 520, 310);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer2_job(), 5), 520, 350);
			g.setFont(new Font("Arial", Font.BOLD, 14));
			g.setColor(new Color (244,212,0)); //yellow
			g.drawString("Lv1. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer2_job(), 0), 670, 150);
			g.drawString("Lv1. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer2_job(), 1), 670, 190);
			g.drawString("Lv3. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer2_job(), 2), 670, 230);
			g.drawString("Lv6. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer2_job(), 3), 670, 270);
			g.drawString("Lv9. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer2_job(), 4), 670, 310);
			g.drawString("Lv12. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer2_job(), 5), 670, 350);
		}
		else if (character == 2){
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer3_job(), 0), 520, 150);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer3_job(), 1), 520, 190);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer3_job(), 2), 520, 230);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer3_job(), 3), 520, 270);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer3_job(), 4), 520, 310);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer3_job(), 5), 520, 350);
			g.setFont(new Font("Arial", Font.BOLD, 14));
			g.setColor(new Color (244,212,0)); //yellow
			g.drawString("Lv1. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer3_job(), 0), 670, 150);
			g.drawString("Lv1. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer3_job(), 1), 670, 190);
			g.drawString("Lv3. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer3_job(), 2), 670, 230);
			g.drawString("Lv6. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer3_job(), 3), 670, 270);
			g.drawString("Lv9. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer3_job(), 4), 670, 310);
			g.drawString("Lv12. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer3_job(), 5), 670, 350);
		}
		else if (character == 3){
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer4_job(), 0), 520, 150);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer4_job(), 1), 520, 190);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer4_job(), 2), 520, 230);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer4_job(), 3), 520, 270);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer4_job(), 4), 520, 310);
			g.drawString(handler.getSkillManager().getSkillName(handler.getData().getPlayer4_job(), 5), 520, 350);
			g.setFont(new Font("Arial", Font.BOLD, 14));
			g.setColor(new Color (244,212,0)); //yellow
			g.drawString("Lv1. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer4_job(), 0), 670, 150);
			g.drawString("Lv1. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer4_job(), 1), 670, 190);
			g.drawString("Lv3. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer4_job(), 2), 670, 230);
			g.drawString("Lv6. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer4_job(), 3), 670, 270);
			g.drawString("Lv9. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer4_job(), 4), 670, 310);
			g.drawString("Lv12. "+handler.getSkillManager().getSkillTypeStr(handler.getData().getPlayer4_job(), 5), 670, 350);
		}
	}
	
	private void drawItems(Graphics g){
		g.setFont(new Font("Arial", Font.PLAIN, 20)); 
		g.setColor(new Color (227,70,221)); //Magenta
		if (character == 0){
			g.drawString(handler.getItemManager().getItemName(handler.getData().getPlayer1_job(), 1, handler.getData().getPlayer1_pri_eq()), 520, 150);
			g.drawString(handler.getItemManager().getItemName(handler.getData().getPlayer1_job(), 2, handler.getData().getPlayer1_sec_eq()), 520, 230);
			g.drawString(handler.getItemManager().getItemName(handler.getData().getPlayer1_job(), 3, handler.getData().getPlayer1_armour()), 520, 310);
			g.setFont(new Font("Arial", Font.BOLD, 14));
			g.setColor(new Color(95,242,138)); //pale green
			g.drawString(handler.getItemManager().getItemDes(handler.getData().getPlayer1_job(), 1, handler.getData().getPlayer1_pri_eq()), 520, 175);
			g.drawString(handler.getItemManager().getItemDes(handler.getData().getPlayer1_job(), 2, handler.getData().getPlayer1_sec_eq()), 520, 255);
			g.drawString(handler.getItemManager().getItemDes(handler.getData().getPlayer1_job(), 3, handler.getData().getPlayer1_armour()), 520, 335);
		}
		else if (character == 1){
			g.drawString(handler.getItemManager().getItemName(handler.getData().getPlayer2_job(), 1, handler.getData().getPlayer2_pri_eq()), 520, 150);
			g.drawString(handler.getItemManager().getItemName(handler.getData().getPlayer2_job(), 2, handler.getData().getPlayer2_sec_eq()), 520, 230);
			g.drawString(handler.getItemManager().getItemName(handler.getData().getPlayer2_job(), 3, handler.getData().getPlayer2_armour()), 520, 310);
			g.setFont(new Font("Arial", Font.BOLD, 14));
			g.setColor(new Color(95,242,138));
			g.drawString(handler.getItemManager().getItemDes(handler.getData().getPlayer2_job(), 1, handler.getData().getPlayer2_pri_eq()), 520, 175);
			g.drawString(handler.getItemManager().getItemDes(handler.getData().getPlayer2_job(), 2, handler.getData().getPlayer2_sec_eq()), 520, 255);
			g.drawString(handler.getItemManager().getItemDes(handler.getData().getPlayer2_job(), 3, handler.getData().getPlayer2_armour()), 520, 335);
		}
		else if (character == 2){
			g.drawString(handler.getItemManager().getItemName(handler.getData().getPlayer3_job(), 1, handler.getData().getPlayer3_pri_eq()), 520, 150);
			g.drawString(handler.getItemManager().getItemName(handler.getData().getPlayer3_job(), 2, handler.getData().getPlayer3_sec_eq()), 520, 230);
			g.drawString(handler.getItemManager().getItemName(handler.getData().getPlayer3_job(), 3, handler.getData().getPlayer3_armour()), 520, 310);
			g.setFont(new Font("Arial", Font.BOLD, 14));
			g.setColor(new Color(95,242,138));
			g.drawString(handler.getItemManager().getItemDes(handler.getData().getPlayer3_job(), 1, handler.getData().getPlayer3_pri_eq()), 520, 175);
			g.drawString(handler.getItemManager().getItemDes(handler.getData().getPlayer3_job(), 2, handler.getData().getPlayer3_sec_eq()), 520, 255);
			g.drawString(handler.getItemManager().getItemDes(handler.getData().getPlayer3_job(), 3, handler.getData().getPlayer3_armour()), 520, 335);
		}
		else{
			g.drawString(handler.getItemManager().getItemName(handler.getData().getPlayer4_job(), 1, handler.getData().getPlayer4_pri_eq()), 520, 150);
			g.drawString(handler.getItemManager().getItemName(handler.getData().getPlayer4_job(), 2, handler.getData().getPlayer4_sec_eq()), 520, 230);
			g.drawString(handler.getItemManager().getItemName(handler.getData().getPlayer4_job(), 3, handler.getData().getPlayer4_armour()), 520, 310);
			g.setFont(new Font("Arial", Font.BOLD, 14));
			g.setColor(new Color(95,242,138));
			g.drawString(handler.getItemManager().getItemDes(handler.getData().getPlayer4_job(), 1, handler.getData().getPlayer4_pri_eq()), 520, 175);
			g.drawString(handler.getItemManager().getItemDes(handler.getData().getPlayer4_job(), 2, handler.getData().getPlayer4_sec_eq()), 520, 255);
			g.drawString(handler.getItemManager().getItemDes(handler.getData().getPlayer4_job(), 3, handler.getData().getPlayer4_armour()), 520, 335);
		}
	}
	

}
