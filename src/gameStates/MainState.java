package gameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import data.Loader;
import entities.Player;
import gfx.Animation;
import gfx.Assets;
import thePrinceGame.Handler;

public class MainState extends State {

	// need to find a way  to make the delay work
	private int stateID;
	private int Menu = 0;  // 0 = main menu, 1 = load menu, 2 = chac menu
	private int arrow = 2; //top/mid/bottom position
	private boolean save = true;

	private Animation animDown1;
	private Animation animDown2;
	private Animation animDown3;
	private Animation animDown4;
	
	
	
	public MainState(Handler handler){
		super(handler);
		stateID = 6;
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
				handler.setData(new Loader ("",false));
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
				handler.setData(new Loader("", true));
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

	
	
	

}
