package entities;

import java.awt.image.BufferedImage;
import gfx.Assets;

class WaterDjinn extends Monster{
	private static int str = 10;
	private static int dex = 25;
	private static int intel = 36;
	private static int vit = 25;
	private static int exp = 220;
	private static BufferedImage anim = Assets.waterDjinn;
	
	WaterDjinn(){
		super(str,dex,intel,vit, exp, anim, "Water Djinn");
		
	}
}
