package gameStates;

import java.awt.Graphics;

import entities.Player;
import thePrinceGame.Handler;

public abstract class State {
	
	private static State currentState = null;
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
	public abstract int getStateID();
	
	public abstract Player getPlayer();
	
	//CLASS
	
	protected Handler handler;

	public State(Handler handler){
		this.handler = handler;
	}
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
