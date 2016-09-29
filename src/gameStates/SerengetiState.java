package gameStates;

import java.awt.Color;
import java.awt.Graphics;
import java.io.*;

import entities.InnGirl;
import entities.ItemGirl;
import entities.KingMap;
import entities.Player;
import entities.Throne;
import entities.WeaponGuy;
import thePrinceGame.Handler;
import tile.Tile;
import worlds.World;

public class SerengetiState extends State {

	//istantiate player object
	private Player player;
	private World world;
	private int stateID;
	private WeaponGuy weaponGuy;
	private InnGirl innGirl;
	private ItemGirl itemGirl;
	private Throne throne;
	private KingMap king;
	private String text1;
	private String text2;
	private int textDisplay;
	
	public SerengetiState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/serengetiCastle.txt");
		handler.setWorld(world);
		player = world.getEntityManager().getPlayer();
		weaponGuy = new WeaponGuy(handler, Tile.TILEWIDTH* 6.0f, Tile.TILEHEIGHT * 8.0f);
		itemGirl = new ItemGirl(handler, Tile.TILEWIDTH* 14.0f, Tile.TILEHEIGHT * 8.0f);
		innGirl = new InnGirl(handler, Tile.TILEWIDTH* 11.0f, Tile.TILEHEIGHT * 15.0f);
		throne = new Throne(handler, Tile.TILEWIDTH* 10.0f, Tile.TILEHEIGHT * 15.0f);
		king = new KingMap (handler, Tile.TILEWIDTH* 9.0f, Tile.TILEHEIGHT * 15.0f);
		world.getEntityManager().addEntity(weaponGuy);
		world.getEntityManager().addEntity(itemGirl);
		world.getEntityManager().addEntity(innGirl);
		world.getEntityManager().addEntity(throne);
		world.getEntityManager().addEntity(king);
		text1 = "Kingdom spades is under invasion from the neighbouring castles. Your mission is to defeat all the other warlords. This game utilises attack combos. Your enemies will attack you real time. So kill them before they kill you. This is the end of the tutorial. Please find me again when you are level 3 or above. If you beat me then, I will give you the Amazonian Hyper Bugspray that will allow you to traverse upon the Amazon forest unbitten.";
		text2 = "Here is your Amazonian Hyper bugspray, please defeat the next boss in Amazon Castle.";
		textDisplay = 0;
		stateID = 1;
	}
	
	@Override
	public void tick() {
		//System.out.println("x = " + player.getX()+ " y = " + player.getY());
		if (handler.getKeyManager().isSelectr()){
			if (textDisplay != 0)
				textDisplay = 0;
			
			else{
				handler.getData().setX_coord((int)((player.getX()+32)/Tile.TILEWIDTH));
				handler.getData().setY_coord((int)((player.getY()+40)/Tile.TILEHEIGHT));
				handler.getData().setStateID(stateID);
				
				//if within boss talking range
				if (player.getX() <= 610 && player.getX() >= 540 && player.getY() >= 984 && player.getY() <= 1024)
				{
					// if above lvl 3 and no bug spray, fight
					if (handler.getData().getLevel() >= 3 && !handler.getData().isBug_spray()){
						BattleState battleState = new BattleState(handler);
						State.setState(battleState);
					}
					else if (handler.getData().getLevel() >= 3 && handler.getData().isBug_spray()){
						textDisplay = 2;
					}
					else{
						textDisplay = 1;
						handler.getData().setCastle_key(true);
					}
				}
				
	
				else{
					MenuState menuState = new MenuState(handler);
					State.setState(menuState);
				}
			}
			handler.getKeyManager().setSelectr(false);
			
		}
		if (player.getX() > (9.0*Tile.TILEWIDTH) && player.getX() < (12.0*Tile.TILEWIDTH) &&
				player.getY() > (0.0*Tile.TILEWIDTH) && player.getY() < (1.3*Tile.TILEWIDTH))
		{
			//Change game state to Game
			handler.getData().setX_coord(5);
			handler.getData().setY_coord(32);
			GameState gameState = new GameState(handler);
			State.setState(gameState);
		}
		world.tick();
		//player.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		if (textDisplay == 1){
			drawText(g, text1);
		}
		else if (textDisplay == 2){
			drawText(g, text2);
		}
	}
	
	public void drawText(Graphics g, String text){
		g.setColor(Color.black);
		g.fillRect(0, 400, 800, 200);
		int lengthVary = 110;
		int i = 0;
		while (text.length() > 0){
			if (text.length() < lengthVary){
				drawBorderString(g, text, 60, 440+40*i, 2);
				text = text.substring(text.length());
			}
			else{
				drawBorderString(g, text.substring(0, lengthVary), 60, 440+40*i, 2);
				text = text.substring(lengthVary);
			}
			i += 1;
		}
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
	
	@Override
	public int getStateID(){
		return stateID;
	}
	
	@Override
	public Player getPlayer(){
		return player;
	}
}
