package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import gfx.Assets;
import thePrinceGame.Handler;


public class InnGirl extends Creature {

	private BufferedImage stand;


	public InnGirl(Handler handler, float x, float y) {
	super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	
	//Static
	stand = Assets.innGirl;
	}
	
	@Override
	public void tick() {
	}
	
	
	@Override
	public void render(Graphics g) {
		g.drawImage(stand, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

	}

}
	
