package tile;

import gfx.Assets;

public class ItemShopTile extends Tile {

	public ItemShopTile(int id) {
		super(Assets.itemShop, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
	
}

