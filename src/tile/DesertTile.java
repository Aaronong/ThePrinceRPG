package tile;

import gfx.Assets;

public class DesertTile extends Tile {

	public DesertTile(int id) {
		super(Assets.desert, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
}
