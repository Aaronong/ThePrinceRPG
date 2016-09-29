package tile;

import gfx.Assets;

public class IceTreeTile extends Tile {
	public IceTreeTile(int id) {
		super(Assets.iceTree, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
	
}
