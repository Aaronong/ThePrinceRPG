package tile;

import gfx.Assets;
import thePrinceGame.Handler;

public class CastleDoorTile extends Tile {

	public CastleDoorTile(int id) {
		super(Assets.castleDoor, id);
	}
	@Override
	public boolean isSolid(){
		return true;
	}

}