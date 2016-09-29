package entities;

import java.awt.image.BufferedImage;
import gfx.Assets;

class Theif_B extends Monster{
	private static int str = 8;
	private static int dex = 5;
	private static int intel = 4;
	private static int vit = 5;
	private static int exp = 22;
	private static BufferedImage anim = Assets.theif_B;
	
	Theif_B(){
		super(str,dex,intel,vit, exp, anim, "Theif B");
	}
}
