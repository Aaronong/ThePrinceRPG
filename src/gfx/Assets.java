package gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 32, height = 32;
	
	public static BufferedImage menu0,menu1,menu2,mainMenu,createCharacterMenu,mainMenuLoad,menuArrow,selectionArrow;
	
	public static BufferedImage plainsBG,forestBG,desertBG,seaBG,tundraBG,
			player1_battle, player2_battle, player3_battle, player4_battle;
	
	public static BufferedImage deepSea, itemShop, weaponShop, inn,
	castleTL, castleBL, castleTR, castleBR, castleFloor, castleWall, castleDoor,
	grass, paddy,
	forest, tree, amazonDungeon,
	desert, cactus, gobiDungeon,
	water, marsh, atlantisDungeon,
	ice, iceTree, iceDungeon;
	
	public static BufferedImage theif_A, theif_B, orc, amaWarrior, xena, xenaMap,
							d_Bat, d_Wanderer, camaxtli, camaxtliMap, skeleton,
							waterDjinn, tefnut, tefnutMap, f_Giant, f_Shade, ymir,
							ymirMap,
							weaponGuy, itemGirl, innGirl, throne, king, kingMap;
	
	public static BufferedImage rangerPack, knightPack, magicianPack, piratePack, ninjaPack;
	
	public static BufferedImage[] battleArrows, battleArrowsOutlined;
	
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	
	public static BufferedImage[] ranger_down;
	public static BufferedImage[] ranger_up;
	public static BufferedImage[] ranger_left;
	public static BufferedImage[] ranger_right;
	
	public static BufferedImage[] knight_down;
	public static BufferedImage[] knight_up;
	public static BufferedImage[] knight_left;
	public static BufferedImage[] knight_right;
	
	public static BufferedImage[] magician_down;
	public static BufferedImage[] magician_up;
	public static BufferedImage[] magician_left;
	public static BufferedImage[] magician_right;
	
	public static BufferedImage[] pirate_down;
	public static BufferedImage[] pirate_up;
	public static BufferedImage[] pirate_left;
	public static BufferedImage[] pirate_right;
	
	public static BufferedImage[] ninja_down;
	public static BufferedImage[] ninja_up;
	public static BufferedImage[] ninja_left;
	public static BufferedImage[] ninja_right;
	
	public static void init(){
		SpriteSheet tileset = new SpriteSheet(ImageLoader.loadImage("/textures/Tileset.png"));
		SpriteSheet gsSprites = new SpriteSheet(ImageLoader.loadImage("/textures/goldensunSprites.png"));
		SpriteSheet graveBossSprites = new SpriteSheet(ImageLoader.loadImage("/textures/graveBossSprites.png"));
		SpriteSheet randomSprites = new SpriteSheet(ImageLoader.loadImage("/textures/randomSprites.png"));
		SpriteSheet worldSprites = new SpriteSheet(ImageLoader.loadImage("/textures/WorldEWYSprites.png"));
		SpriteSheet gravemonstersSprites = new SpriteSheet(ImageLoader.loadImage("/textures/gravemonstersSprites.png"));
		SpriteSheet loadSaveMenu = new SpriteSheet(ImageLoader.loadImage("/textures/loadSave.png"));
		SpriteSheet characterMenu = new SpriteSheet(ImageLoader.loadImage("/textures/characterMenu.png"));
		
		//Menu
		menu1 = loadSaveMenu.crop(0, 0, 800, 600);
		menu2 = characterMenu.crop(0, 0, 800, 600);
		menu0 = (ImageLoader.loadImage("/textures/openMenu.png"));
		mainMenu = ImageLoader.loadImage("/textures/mainMenu.png");
		mainMenuLoad = ImageLoader.loadImage("/textures/mainMenuLoad.png");
		createCharacterMenu = ImageLoader.loadImage("/textures/characterCreation.png");
		menuArrow = ImageLoader.loadImage("/textures/menuArrow.png");
		selectionArrow = ImageLoader.loadImage("/textures/BattleBG/SelectionArrow.png");
		battleArrows = new BufferedImage[4];
		// x = 0, 170, 340, 510 y = 485,325,165,0  125x125
		battleArrows[0] = ImageLoader.loadImage("/textures/BattleBG/BlueUpArrow.png"); // Blue Up
		battleArrows[1] = ImageLoader.loadImage("/textures/BattleBG/RedDownArrow.png"); // Red down
		battleArrows[2] = ImageLoader.loadImage("/textures/BattleBG/GreenLeftArrow.png"); // Green left
		battleArrows[3] =  ImageLoader.loadImage("/textures/BattleBG/YellowRightArrow.png"); // Yellow right
		
		battleArrowsOutlined = new BufferedImage[4];
		battleArrowsOutlined[0] = ImageLoader.loadImage("/textures/BattleBG/BlueUpArrowOutline.png"); // Blue Up
		battleArrowsOutlined[1] = ImageLoader.loadImage("/textures/BattleBG/RedDownArrowOutline.png"); // Red down
		battleArrowsOutlined[2] = ImageLoader.loadImage("/textures/BattleBG/GreenLeftArrowOutline.png"); // Green left
		battleArrowsOutlined[3] =  ImageLoader.loadImage("/textures/BattleBG/YellowRightArrowOutline.png"); // Yellow right
		
		
		//Battle Background
		plainsBG = (ImageLoader.loadImage("/textures/BattleBG/plainsBG.png"));
		forestBG = (ImageLoader.loadImage("/textures/BattleBG/jungleBG.png"));
		desertBG = (ImageLoader.loadImage("/textures/BattleBG/DesertBG.png"));
		seaBG = (ImageLoader.loadImage("/textures/BattleBG/seaBG.png"));
		tundraBG = (ImageLoader.loadImage("/textures/BattleBG/tundraBG.png"));
		
		player1_battle = (ImageLoader.loadImage("/textures/BattleBG/player1Battle.png"));
		player2_battle = (ImageLoader.loadImage("/textures/BattleBG/player2Battle.png"));
		player3_battle = (ImageLoader.loadImage("/textures/BattleBG/player3Battle.png"));
		player4_battle = (ImageLoader.loadImage("/textures/BattleBG/player4Battle.png"));
		
		//Player Animations
		player_down = new BufferedImage[4];
		player_down[0] = gsSprites.crop(0, 0, width, height);
		player_down[1] = gsSprites.crop(width, 0, width, height);
		player_down[2] = gsSprites.crop(width * 2, 0, width, height);
		player_down[3] = gsSprites.crop(width, 0, width, height);
		
		player_up = new BufferedImage[4];
		player_up[0] = gsSprites.crop(0, height * 3, width, height);
		player_up[1] = gsSprites.crop(width, height * 3, width, height);
		player_up[2] = gsSprites.crop(width * 2, height * 3, width, height);
		player_up[3] = gsSprites.crop(width, height * 3, width, height);
		
		player_left = new BufferedImage[4];
		player_left[0] = gsSprites.crop(0, height, width, height);
		player_left[1] = gsSprites.crop(width, height, width, height);
		player_left[2] = gsSprites.crop(width * 2, height, width, height);
		player_left[3] = gsSprites.crop(width, height, width, height);
		
		player_right = new BufferedImage[4];
		player_right[0] = gsSprites.crop(0, height * 2, width, height);
		player_right[1] = gsSprites.crop(width, height * 2, width, height);
		player_right[2] = gsSprites.crop(width * 2, height * 2, width, height);
		player_right[3] = gsSprites.crop(width, height * 2, width, height);
		
		//RangerPack
		rangerPack = gsSprites.crop(6*width, 0, 3*width, 4*height);
		ranger_down = new BufferedImage[4];
		ranger_down[0] = rangerPack.getSubimage(0, 0, width, height);
		ranger_down[1] = rangerPack.getSubimage(width, 0, width, height);
		ranger_down[2] = rangerPack.getSubimage(width * 2, 0, width, height);
		ranger_down[3] = rangerPack.getSubimage(width, 0, width, height);
		
		ranger_up = new BufferedImage[4];
		ranger_up[0] = rangerPack.getSubimage(0, height * 3, width, height);
		ranger_up[1] = rangerPack.getSubimage(width, height * 3, width, height);
		ranger_up[2] = rangerPack.getSubimage(width * 2, height * 3, width, height);
		ranger_up[3] = rangerPack.getSubimage(width, height * 3, width, height);
		
		ranger_left = new BufferedImage[4];
		ranger_left[0] = rangerPack.getSubimage(0, height, width, height);
		ranger_left[1] = rangerPack.getSubimage(width, height, width, height);
		ranger_left[2] = rangerPack.getSubimage(width * 2, height, width, height);
		ranger_left[3] = rangerPack.getSubimage(width, height, width, height);
		
		ranger_right = new BufferedImage[4];
		ranger_right[0] = rangerPack.getSubimage(0, height * 2, width, height);
		ranger_right[1] = rangerPack.getSubimage(width, height * 2, width, height);
		ranger_right[2] = rangerPack.getSubimage(width * 2, height * 2, width, height);
		ranger_right[3] = rangerPack.getSubimage(width, height * 2, width, height);
		
		//KnightPack
		knightPack = graveBossSprites.crop(6*width, 4*height, 3*width, 4*height);
		
		knight_down = new BufferedImage[4];
		knight_down[0] = knightPack.getSubimage(0, 0, width, height);
		knight_down[1] = knightPack.getSubimage(width, 0, width, height);
		knight_down[2] = knightPack.getSubimage(width * 2, 0, width, height);
		knight_down[3] = knightPack.getSubimage(width, 0, width, height);
		
		knight_up = new BufferedImage[4];
		knight_up[0] = knightPack.getSubimage(0, height * 3, width, height);
		knight_up[1] = knightPack.getSubimage(width, height * 3, width, height);
		knight_up[2] = knightPack.getSubimage(width * 2, height * 3, width, height);
		knight_up[3] = knightPack.getSubimage(width, height * 3, width, height);
		
		knight_left = new BufferedImage[4];
		knight_left[0] = knightPack.getSubimage(0, height, width, height);
		knight_left[1] = knightPack.getSubimage(width, height, width, height);
		knight_left[2] = knightPack.getSubimage(width * 2, height, width, height);
		knight_left[3] = knightPack.getSubimage(width, height, width, height);
		
		knight_right = new BufferedImage[4];
		knight_right[0] = knightPack.getSubimage(0, height * 2, width, height);
		knight_right[1] = knightPack.getSubimage(width, height * 2, width, height);
		knight_right[2] = knightPack.getSubimage(width * 2, height * 2, width, height);
		knight_right[3] = knightPack.getSubimage(width, height * 2, width, height);
		
		//MagicianPack
		magicianPack = gsSprites.crop(9*width, 0, width*3, 4*height);
		
		magician_down = new BufferedImage[4];
		magician_down[0] = magicianPack.getSubimage(0, 0, width, height);
		magician_down[1] = magicianPack.getSubimage(width, 0, width, height);
		magician_down[2] = magicianPack.getSubimage(width * 2, 0, width, height);
		magician_down[3] = magicianPack.getSubimage(width, 0, width, height);
		
		magician_up = new BufferedImage[4];
		magician_up[0] = magicianPack.getSubimage(0, height * 3, width, height);
		magician_up[1] = magicianPack.getSubimage(width, height * 3, width, height);
		magician_up[2] = magicianPack.getSubimage(width * 2, height * 3, width, height);
		magician_up[3] = magicianPack.getSubimage(width, height * 3, width, height);
		
		magician_left = new BufferedImage[4];
		magician_left[0] = magicianPack.getSubimage(0, height, width, height);
		magician_left[1] = magicianPack.getSubimage(width, height, width, height);
		magician_left[2] = magicianPack.getSubimage(width * 2, height, width, height);
		magician_left[3] = magicianPack.getSubimage(width, height, width, height);
		
		magician_right = new BufferedImage[4];
		magician_right[0] = magicianPack.getSubimage(0, height * 2, width, height);
		magician_right[1] = magicianPack.getSubimage(width, height * 2, width, height);
		magician_right[2] = magicianPack.getSubimage(width * 2, height * 2, width, height);
		magician_right[3] = magicianPack.getSubimage(width, height * 2, width, height);
		
		//PiratePack
		piratePack = worldSprites.crop(6*width, 0, 3*width, 4*height);
		
		pirate_down = new BufferedImage[4];
		pirate_down[0] = piratePack.getSubimage(0, 0, width, height);
		pirate_down[1] = piratePack.getSubimage(width, 0, width, height);
		pirate_down[2] = piratePack.getSubimage(width * 2, 0, width, height);
		pirate_down[3] = piratePack.getSubimage(width, 0, width, height);
		
		pirate_up = new BufferedImage[4];
		pirate_up[0] = piratePack.getSubimage(0, height * 3, width, height);
		pirate_up[1] = piratePack.getSubimage(width, height * 3, width, height);
		pirate_up[2] = piratePack.getSubimage(width * 2, height * 3, width, height);
		pirate_up[3] = piratePack.getSubimage(width, height * 3, width, height);
		
		pirate_left = new BufferedImage[4];
		pirate_left[0] = piratePack.getSubimage(0, height, width, height);
		pirate_left[1] = piratePack.getSubimage(width, height, width, height);
		pirate_left[2] = piratePack.getSubimage(width * 2, height, width, height);
		pirate_left[3] = piratePack.getSubimage(width, height, width, height);
		
		pirate_right = new BufferedImage[4];
		pirate_right[0] = piratePack.getSubimage(0, height * 2, width, height);
		pirate_right[1] = piratePack.getSubimage(width, height * 2, width, height);
		pirate_right[2] = piratePack.getSubimage(width * 2, height * 2, width, height);
		pirate_right[3] = piratePack.getSubimage(width, height * 2, width, height);
		
		
		//NinjaPack
		ninjaPack = graveBossSprites.crop(0, 4*height, 3*width, 4*height);

		ninja_down = new BufferedImage[4];
		ninja_down[0] = ninjaPack.getSubimage(0, 0, width, height);
		ninja_down[1] = ninjaPack.getSubimage(width, 0, width, height);
		ninja_down[2] = ninjaPack.getSubimage(width * 2, 0, width, height);
		ninja_down[3] = ninjaPack.getSubimage(width, 0, width, height);
		
		ninja_up = new BufferedImage[4];
		ninja_up[0] = ninjaPack.getSubimage(0, height * 3, width, height);
		ninja_up[1] = ninjaPack.getSubimage(width, height * 3, width, height);
		ninja_up[2] = ninjaPack.getSubimage(width * 2, height * 3, width, height);
		ninja_up[3] = ninjaPack.getSubimage(width, height * 3, width, height);
		
		ninja_left = new BufferedImage[4];
		ninja_left[0] = ninjaPack.getSubimage(0, height, width, height);
		ninja_left[1] = ninjaPack.getSubimage(width, height, width, height);
		ninja_left[2] = ninjaPack.getSubimage(width * 2, height, width, height);
		ninja_left[3] = ninjaPack.getSubimage(width, height, width, height);
		
		ninja_right = new BufferedImage[4];
		ninja_right[0] = ninjaPack.getSubimage(0, height * 2, width, height);
		ninja_right[1] = ninjaPack.getSubimage(width, height * 2, width, height);
		ninja_right[2] = ninjaPack.getSubimage(width * 2, height * 2, width, height);
		ninja_right[3] = ninjaPack.getSubimage(width, height * 2, width, height);
		
		
		//NPC and Static Monsters
		
		//Serengeti
		theif_A = worldSprites.crop(9*width, 2*height, 3*width, height);
		theif_B = worldSprites.crop(3*width, 2*height, 3*width, height);
		
		//Amazon
		orc = gravemonstersSprites.crop(6*width, 2*height, 3*width, height);
		amaWarrior = randomSprites.crop(0, 2*height, 3*width, height);
		xena = randomSprites.crop(9*width, 2*height, 3*width, height);
		xenaMap = randomSprites.crop(10*width, 0, width, height);
		
		//Gobi
		d_Bat = gravemonstersSprites.crop(9*width, 2*height, 3*width, height);
		d_Wanderer = graveBossSprites.crop(6*width, 2*height, 3*width, height);
		camaxtli = graveBossSprites.crop(3*width, 2*height, 3*width, height);
		camaxtliMap = graveBossSprites.crop(4*width, 0, width, height);
		
		
		//Atlantis
		skeleton = gravemonstersSprites.crop(3*width, 2*height, 3*width, height);
		waterDjinn = gravemonstersSprites.crop(0, 6*height, 3*width, height);
		tefnut = gsSprites.crop(3*width, 6*height, 3*width, height);
		tefnutMap = gsSprites.crop(4*width, 4*height, width, height);
		
		//Jotenheim
		f_Giant = randomSprites.crop(3*width, 2*height, 3*width, height);
		f_Shade = gravemonstersSprites.crop(0, 2*height, 3*width, height);
		ymir = gsSprites.crop(0, 6*height, 3*width, height);
		ymirMap = gsSprites.crop(1, 4*height, width, height);
		
		//NPC
		weaponGuy = gsSprites.crop(4*width, 0, width, height);
		itemGirl = randomSprites.crop(4*width, 4*height, width, height);
		innGirl = worldSprites.crop(width, 0, width, height);
		throne = ImageLoader.loadImage("/textures/throne.png");
		SpriteSheet kingSheet = new SpriteSheet(ImageLoader.loadImage("/textures/king.png"));
		
		kingMap = kingSheet.crop(width, 0, width, height);
		king = kingSheet.crop(0, 2*height, 3*width, height);
		
		
		// Common TileSet
		deepSea = tileset.crop(0, height*4, width, height);
		itemShop = tileset.crop(14*width, 17*height, width, height);
		weaponShop = tileset.crop(12 * width, 17 * height, width, height);
		inn = tileset.crop(8*width, 3*height, width, height);
		castleTL = tileset.crop(0, 12*height, width, height);
		castleBL = tileset.crop(3*width, 12*height, width, height);
		castleTR = tileset.crop(1*width, 12*height, width, height);
		castleBR = tileset.crop(4*width, 12*height, width, height);
		castleFloor = tileset.crop(3*width, height, width, height);
		castleWall = tileset.crop(11*width, 13*height, width, height);
		castleDoor = tileset.crop(18*width, 3*height, width, height);
		
		//Great Plains TileSet
		grass = tileset.crop(0, 0, width, height);
		paddy = tileset.crop(10*width, 18*height, width, height);
		
		//Amazon Forest Tileset
		forest = tileset.crop(8*width, 10*height, width, height);
		tree = tileset.crop(2*width, height, width, height);
		amazonDungeon = tileset.crop(15*width, 3*height, width, height);
		
		//Gobi Desert Tileset
		desert = tileset.crop(9*width, 10*height, width, height);
		cactus = tileset.crop(15*width, 16*height, width, height);
		gobiDungeon = tileset.crop(16*width, 4*height, width, height);
		
		//Atlantis Ocean Tileset
		water = tileset.crop(width*6, height*10, width, height);
		marsh = tileset.crop(14*width, 8*height, width, height);
		atlantisDungeon = tileset.crop(21*width, 7*height, width, height);
		
		//North Pole TileSet
		ice = tileset.crop(width*18, height*5, width, height);
		iceTree = tileset.crop(9*width, 7*height, width, height);
		iceDungeon = tileset.crop(15*width, 8*height, width, height);
		
		
	}
	
}
