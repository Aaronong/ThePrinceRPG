package entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import thePrinceGame.Handler;

public abstract class Entity {
	
	// though x and y should be integers, using floats allow us to draw more smoothly
	// better calculations
	protected Handler handler;
	protected float x, y;
	protected int width,height;
	protected Rectangle bounds;
	
	public Entity (Handler handler, float x, float y, int width, int height){
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(12,20,8,10);
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	//Getters and Setters
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
}
