package tile;

import gfx.Assets;

public class CastleBRTile extends Tile {

	public CastleBRTile(int id) {
		super(Assets.castleBR, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
	
}
