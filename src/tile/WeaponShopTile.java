package tile;

import gfx.Assets;

public class WeaponShopTile extends Tile {

	public WeaponShopTile(int id) {
		super(Assets.weaponShop, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
	
}
