package tile;

import gfx.Assets;

public class IceTile extends Tile {

	public IceTile(int id) {
		super(Assets.ice, id);
	}
	@Override
	public boolean isSolid(){
		return true;
	}
}
