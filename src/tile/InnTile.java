package tile;

import gfx.Assets;

public class InnTile extends Tile {

	public InnTile(int id) {
		super(Assets.inn, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
	
}