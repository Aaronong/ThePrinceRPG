package entities;

import java.awt.image.BufferedImage;
import gfx.Assets;

class King extends Monster{
	private static int str = 16;
	private static int dex = 10;
	private static int intel = 8;
	private static int vit = 10;
	private static int exp = 100;
	private static BufferedImage anim = Assets.king;
	
	King(){
		super(str,dex,intel,vit, exp, anim, "Amazon Warrior");
		
	}
}
