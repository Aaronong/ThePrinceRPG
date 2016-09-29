package tile;

import gfx.Assets;

public class CastleTile2 extends Tile {

	public CastleTile2(int id) {
		super(Assets.castleFloor, id);
	}
	@Override
	public boolean isSolid(){
		return true;
	}
}
