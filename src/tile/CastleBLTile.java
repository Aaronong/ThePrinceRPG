package tile;

import gfx.Assets;

public class CastleBLTile extends Tile {

	public CastleBLTile(int id) {
		super(Assets.castleBL, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
	
}
