package tile;

import gfx.Assets;

public class CastleWallTile extends Tile {

	public CastleWallTile(int id) {
		super(Assets.castleWall, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
	
}