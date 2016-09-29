package tile;

import gfx.Assets;

public class CastleTLTile extends Tile {

	public CastleTLTile(int id) {
		super(Assets.castleTL, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
	
}
