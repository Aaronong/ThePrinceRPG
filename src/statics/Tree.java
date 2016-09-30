package statics;

import java.awt.Graphics;

import gfx.Assets;
import thePrinceGame.Handler;
import tile.Tile;

public class Tree extends StaticEntity {
	public Tree(Handler handler, float x, float y){
		super(handler,x,y,Tile.TILEWIDTH,Tile.TILEHEIGHT);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
}
