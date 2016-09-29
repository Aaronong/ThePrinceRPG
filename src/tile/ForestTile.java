package tile;


import gfx.Assets;

public class ForestTile extends Tile {

	public ForestTile(int id) {
		super(Assets.forest, id);
	}

	@Override
	public boolean isSolid(){
		return true;
	}
}
