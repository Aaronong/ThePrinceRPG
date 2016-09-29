package entities;

import java.awt.image.BufferedImage;
import gfx.Assets;

class DesertBat extends Monster{
	private static int str = 15;
	private static int dex = 24;
	private static int intel = 14;
	private static int vit = 12;
	private static int exp = 90;
	private static BufferedImage anim = Assets.d_Bat;
	
	DesertBat(){
		super(str,dex,intel,vit, exp, anim, "Desert Bat");
		
	}
}
