package entities;

import java.awt.Graphics;

import thePrinceGame.Handler;
import tile.Tile;

public class Creature extends Entity{

	public static final int Default_STR = 10;
	public static final int Default_DEX = 10;
	public static final int Default_INT = 10;
	public static final int Default_VIT = 10;
	public static final float Default_SPD = 10.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;
	
	protected int Str;
	protected int Dex;
	protected int Int;
	protected int Vit;
	
	protected float speed;
	protected float xMove, yMove;
	


	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		speed = Default_SPD;
		// Initiate stats here Str = Default_STR; 
	}

	public void move(){
		moveX();
		moveY();
		
	}
	
	public void moveX(){
		if (xMove > 0){//Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width)/ Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height)/ Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
			
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bounds.x)/ Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height)/ Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
		
	}
	
	public void moveY(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y+= yMove;
			}else{
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
			
			
		}else if (yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y+= yMove;
			}else{
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
		
	}
	
	protected boolean collisionWithTile(int x, int y){
		if (handler.getWorld().getTile(x, y).getID() == 68){
			System.out.println(handler.getData().isCastle_key());
			if (handler.getData().isCastle_key())
				return false;
			
		}
		if (handler.getWorld().getTile(x, y).getID() == 21){
			System.out.println(handler.getData().isBug_spray());
			if (handler.getData().isBug_spray())
				return false;
		}
		if (handler.getWorld().getTile(x, y).getID() == 31){
			System.out.println(handler.getData().isSun_block());
			if (handler.getData().isSun_block())
				return false;
		}
		if (handler.getWorld().getTile(x, y).getID() == 41){
			System.out.println(handler.getData().isFerry_pass());
			if (handler.getData().isFerry_pass())
				return false;
		}
		if (handler.getWorld().getTile(x, y).getID() == 51){
			System.out.println(handler.getData().isWinter_wear());
			if (handler.getData().isWinter_wear())
				return false;
		}
		
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		
	}
	
	//Getters and Setters
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	
}
