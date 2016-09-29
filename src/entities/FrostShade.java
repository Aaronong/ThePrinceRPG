package entities;

import java.awt.image.BufferedImage;
import gfx.Assets;

class FrostShade extends Monster{
	private static int str = 12;
	private static int dex = 20;
	private static int intel = 40;
	private static int vit = 40;
	private static int exp = 340;
	private static BufferedImage anim = Assets.f_Shade;
	
	FrostShade(){
		super(str,dex,intel,vit, exp, anim, "Frost Shade");
		
	}
}
