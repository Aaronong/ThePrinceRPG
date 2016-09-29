package entities;

import java.awt.image.BufferedImage;
import gfx.Assets;

class Skeleton extends Monster{
	private static int str = 25;
	private static int dex = 32;
	private static int intel = 6;
	private static int vit = 30;
	private static int exp = 180;
	private static BufferedImage anim = Assets.skeleton;
	
	Skeleton(){
		super(str,dex,intel,vit, exp, anim, "Davy Jones");
		
	}
}
