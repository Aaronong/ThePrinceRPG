package gameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entities.EntityManager;
import entities.Player;
import gfx.Animation;
import gfx.Assets;
import thePrinceGame.Handler;
import thePrinceMain.Game;

public class MainState extends State {

	// need to find a way  to make the delay work
	private int stateID;
	private int Menu = 0;  // 0 = main menu, 1 = load menu, 2 = chac menu
	private int arrow = 2; //top/mid/bottom position
	private int character = 0; //in mod 6, returns one of the six heroes
	private int status = 0; // in mod 3, stats inventory skills
	private boolean save = true;
	private int stats = 0; // in mod 4, str dex int vit
	private int items = 0; // in mod 3, pri sec armour
	private int skills = 7; // in mod 5, skl 1,2,3,4,5
	private EntityManager entityManager;
	private Animation animDown1;
	private Animation animDown2;
	private Animation animDown3;
	private Animation animDown4;
	private Animation animAllDown1;
	private Animation animAllDown2;
	private Animation animAllDown3;
	private Animation animAllDown4;
	private Animation animAllDown5;
	private Animation animAllDown6;
	
	
	
	public MainState(Handler handler){
		super(handler);
		stateID = 6;
		entityManager = new EntityManager(handler, null);
		animDown1 = new Animation(200, Assets.player_down);
		animDown2 = new Animation(200, getCharAnim(handler.getData().getPlayer2_job()));
		animDown3 = new Animation(200, getCharAnim(handler.getData().getPlayer3_job()));
		animDown4 = new Animation(200, getCharAnim(handler.getData().getPlayer4_job()));
		animAllDown1 = new Animation(200, Assets.player_down);
		animAllDown2 = new Animation(200, Assets.ranger_down);
		animAllDown3 = new Animation(200, Assets.knight_down);
		animAllDown4 = new Animation(200, Assets.magician_down);
		animAllDown5 = new Animation(200, Assets.pirate_down);
		animAllDown6 = new Animation(200, Assets.ninja_down);
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
			if (handler.getKeyManager().isUpr()){
				arrow -= 1;
				handler.getKeyManager().setUpr(false);
				if (arrow == 0)
					arrow =3;
			}
			
			if (handler.getKeyManager().isDownr()){
				arrow += 1;
				handler.getKeyManager().setDownr(false);
				if (arrow == 4)
					arrow =1;
			}
				
			if (handler.getKeyManager().isSelectr()){
					Menu = arrow;
				handler.getKeyManager().setSelectr(false);
			}
			
		}
		if (Menu == 1){ //load
			if (handler.getKeyManager().isSelectr()){
				handler.toWorld();
				handler.getKeyManager().setSelectr(false);
			}
			if (handler.getKeyManager().isBackr()){
				Menu = 0;
				handler.getKeyManager().setBackr(false);
				
			}
		}
		if (Menu ==3){
			System.exit(0);
		}
		if (Menu == 2){ //new
			if (handler.getKeyManager().isSelectr()){
				handler.toWorld();
				handler.getKeyManager().setSelectr(false);
			}
		}
			
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		if (Menu == 1)
		{
			g.drawImage(Assets.mainMenuLoad, 0,0, 800,600, null);
			g.drawImage(Assets.menuArrow,40, 160,30,30, null);

			g.setFont(new Font("Arial", Font.PLAIN, 20)); 
			g.setColor(new Color (244,212,0)); //yellow
			g.drawString("Gold: "+handler.getData().getGold(), 630, 40);
			drawCharacter(g,0,430,80);
			drawCharacter(g,1,430,180);
			drawCharacter(g,2,430,280);
			drawCharacter(g,3,430,380);
			if (save == true)
				g.drawImage(Assets.menuArrow,455,487,30,30, null);
			else
				g.drawImage(Assets.menuArrow,600,487,30,30, null);
			//g.drawImage(animDown1.getCurrentFrame(), 430, 30, 64, 64, null);
			//g.drawImage(animDown2.getCurrentFrame(), 430, 130, 64, 64, null);
			//g.drawImage(animDown3.getCurrentFrame(), 430, 230, 64, 64, null);
			//g.drawImage(animDown4.getCurrentFrame(), 430, 330, 64, 64, null);
		}
		else if (Menu == 2)
		{
			g.drawImage(Assets.createCharacterMenu, 0,0, 800,600, null);
			g.setFont(new Font("Arial", Font.PLAIN, 20)); 
			g.setColor(new Color (244,212,0)); //yellow
			drawCharacter(g,0,30,130);
			drawCharacter(g,1,30,230);
			drawCharacter(g,2,30,330);
			drawCharacter(g,3,30,430);

		}
		else // Main menu, save/load or character info
		{
			g.drawImage(Assets.mainMenu, 0,0, 800,600, null);
			if (arrow == 1)
				g.drawImage(Assets.menuArrow,40, 160,30,30, null);
			else if (arrow == 2)
				g.drawImage(Assets.menuArrow,40, 300,30,30, null);
			else if (arrow == 3)
				g.drawImage(Assets.menuArrow,40, 430,30,30, null);
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
