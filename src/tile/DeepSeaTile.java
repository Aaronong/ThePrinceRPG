package tile;

import gfx.Assets;

public class DeepSeaTile extends Tile {

	public DeepSeaTile(int id) {
		super(Assets.deepSea, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
	
	
}
