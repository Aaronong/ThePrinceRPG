package entities;

import java.awt.image.BufferedImage;
import gfx.Assets;

class Xena extends Monster{
	private static int str = 22;
	private static int dex = 30;
	private static int intel = 16;
	private static int vit = 24;
	private static int exp = 700;
	private static BufferedImage anim = Assets.xena;
	
	Xena(){
		super(str,dex,intel,vit, exp, anim, "Xena");
		
	}
}
