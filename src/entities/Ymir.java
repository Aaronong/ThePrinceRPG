package entities;

import java.awt.image.BufferedImage;
import gfx.Assets;

class Ymir extends Monster{
	private static int str = 60;
	private static int dex = 50;
	private static int intel = 60;
	private static int vit = 80;
	private static int exp = 6000;
	private static BufferedImage anim = Assets.ymir;
	
	Ymir(){
		super(str,dex,intel,vit, exp, anim, "Ymir");
		
	}
}
