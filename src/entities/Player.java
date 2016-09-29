package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import gfx.Animation;
import gfx.Assets;
import thePrinceGame.Handler;

public class Player extends Creature {
	
	//Animations
	private Animation animDown;
	private Animation animUp;
	private Animation animLeft;
	private Animation animRight;
	private BufferedImage stand;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		bounds.x = 22;
		bounds.y = 40;
		bounds.width = 18;
		bounds.height = 24;
		
		//Animations
		animDown = new Animation(200, Assets.player_down);
		animUp = new Animation(200, Assets.player_up);
		animLeft = new Animation(200, Assets.player_left);
		animRight = new Animation(200, Assets.player_right);
		
		//Static
		stand = Assets.player_down[1];
	}
	
	@Override
	public void tick() {
		//Animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		// remember to cast to int
		
		//Pass in width and height to resize from 32pixel to width pixel
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		/*		g.setColor(Color.red);
				g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
						(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
						bounds.width, bounds.height);*/
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0){
			return animLeft.getCurrentFrame();
		}else if(xMove > 0){
			return animRight.getCurrentFrame();
		}else if (yMove < 0 ){
			return animUp.getCurrentFrame();
		}else if (yMove > 0){
			return animDown.getCurrentFrame();
		}else{
			return stand;
		}
	}


}
