package entities;

import java.awt.image.BufferedImage;
import gfx.Assets;

class Camaxtli extends Monster{
	private static int str = 36;
	private static int dex = 30;
	private static int intel = 36;
	private static int vit = 44;
	private static int exp = 2500;
	private static BufferedImage anim = Assets.camaxtli;
	
	Camaxtli(){
		super(str,dex,intel,vit, exp, anim, "Camaxtli");
		
	}
}
