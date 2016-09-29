package gfx;

import entities.Entity;
import thePrinceGame.Handler;
import tile.Tile;

public class GameCamera {
	
	private Handler handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handler handler, float xOffset, float yOffset){
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void checkBlankSpace(){
		if(xOffset < 0){
			xOffset = 0;
		}
		
		else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()){
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}
		if(yOffset < 0 ){
			yOffset = 0;
		}
		
		else if (yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight())
			yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
		
	}
	
	public void centerOnEntity(Entity e){
		xOffset = e.getX() - handler.getWidth() /2 + e.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight() /2 + e.getHeight() / 2;
		checkBlankSpace();
	}
	
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	
	//Getters and setters
	public float getxOffset() {
		return xOffset;
	}


	public float getyOffset() {
		return yOffset;
	}



	
}
