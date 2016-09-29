package statics;

import entities.Entity;
import thePrinceGame.Handler;

public abstract class StaticEntity extends Entity {
	
	public StaticEntity(Handler handler, float x, float y, int width, int height){
		super(handler,x,y,width,height);
	}
	
}
