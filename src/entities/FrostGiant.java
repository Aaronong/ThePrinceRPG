package entities;

import java.awt.image.BufferedImage;
import gfx.Assets;

class FrostGiant extends Monster{
	private static int str = 40;
	private static int dex = 20;
	private static int intel = 12;
	private static int vit = 40;
	private static int exp = 400;
	private static BufferedImage anim = Assets.f_Giant;
	
	FrostGiant(){
		super(str,dex,intel,vit, exp, anim, "Frost Giant");
		
	}
}
