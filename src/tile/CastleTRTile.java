package tile;

import gfx.Assets;

public class CastleTRTile extends Tile {

	public CastleTRTile(int id) {
		super(Assets.castleTR, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
	
}
