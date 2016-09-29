package tile;

import java.awt.image.BufferedImage;

import gfx.Assets;

public class PaddyTile extends Tile {

	public PaddyTile(int id) {
		super(Assets.paddy, id);
	}

	@Override
	public boolean isSolid(){
		return true;
	}
}
