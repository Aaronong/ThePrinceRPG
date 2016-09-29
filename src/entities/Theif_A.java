package entities;

import java.awt.image.BufferedImage;
import gfx.Assets;

class Theif_A extends Monster{
	private static int str = 5;
	private static int dex = 7;
	private static int intel = 4;
	private static int vit = 5;
	private static int exp = 18;
	private static BufferedImage anim = Assets.theif_A;
	
	Theif_A(){
		super(str,dex,intel,vit, exp, anim, "Theif A");
	}
}
