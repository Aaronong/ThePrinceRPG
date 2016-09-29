package entities;

import java.awt.image.BufferedImage;
import gfx.Assets;

class Orc extends Monster{
	private static int str = 12;
	private static int dex = 7;
	private static int intel = 4;
	private static int vit = 10;
	private static int exp = 45;
	private static BufferedImage anim = Assets.orc;
	
	Orc(){
		super(str,dex,intel,vit, exp, anim, "Orc");
		
	}
}
