package entities;

import java.awt.image.BufferedImage;
import gfx.Assets;

class DesertWanderer extends Monster{
	private static int str = 18;
	private static int dex = 15;
	private static int intel = 18;
	private static int vit = 22;
	private static int exp = 120;
	private static BufferedImage anim = Assets.d_Wanderer;
	
	DesertWanderer(){
		super(str,dex,intel,vit, exp, anim, "Desert Wanderer");
		
	}
}
