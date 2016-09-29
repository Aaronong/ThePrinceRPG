package tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import thePrinceGame.Handler;

public class Tile {
	
	//STATIC STUFF HERE
	
	public static Tile[] tiles = new Tile[128];
	public static Tile deepSeaTile = new DeepSeaTile(99);
	public static Tile castleTile2 = new CastleTile2(88);
	public static Tile innTile = new InnTile(60);
	public static Tile itemShopTile = new ItemShopTile(61);
	public static Tile weaponShopTile = new WeaponShopTile(62);
	public static Tile castleTL = new CastleTLTile(63);
	public static Tile castleTR = new CastleTRTile(64);
	public static Tile castleBL = new CastleBLTile(65);
	public static Tile castleBR = new CastleBRTile(66);
	public static Tile castleFloorTile = new CastleFloorTile(67);
	public static Tile castleDoorTile = new CastleDoorTile(68);
	public static Tile castleWallTile = new CastleWallTile(69);
	public static Tile grassTile = new GrassTile(11);
	public static Tile paddyTile = new PaddyTile(12);
	public static Tile forestTile = new ForestTile(21);
	public static Tile treeTile = new TreeTile(22);
	public static Tile amazonDungeonTile = new AmazonDungeon(23);
	public static Tile desertTile = new DesertTile(31);
	public static Tile cactusTile = new CactusTile(32);
	public static Tile gobiDungeonTile = new GobiDungeon(33);
	public static Tile waterTile = new WaterTile(41);
	public static Tile marshTile = new MarshTile(42);
	public static Tile atlantisDungeonTile = new AtlantisDungeon(43);
	public static Tile iceTile = new IceTile(51);
	public static Tile iceTreeTile = new IceTreeTile(52);
	public static Tile iceDungeonTile = new IceDungeon(53);
	
	//Class
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render (Graphics g, int x, int y){
		g.drawImage(texture, x,y, TILEWIDTH,TILEHEIGHT, null);
	}
	
	public boolean isSolid(){
		//Cant walk through solid Objects
		return false;
	}
	
	public int getID(){
		return id;
	}
}
