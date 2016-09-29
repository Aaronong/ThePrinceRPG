package tile;

import gfx.Assets;

public class CactusTile extends Tile {

	public CactusTile(int id) {
		super(Assets.cactus, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
}