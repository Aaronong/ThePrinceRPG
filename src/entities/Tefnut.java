package entities;

import java.awt.image.BufferedImage;
import gfx.Assets;

class Tefnut extends Monster{
	private static int str = 20;
	private static int dex = 50;
	private static int intel = 72;
	private static int vit = 60;
	private static int exp = 4500;
	private static BufferedImage anim = Assets.tefnut;
	
	Tefnut(){
		super(str,dex,intel,vit, exp, anim, "Tefnut");
		
	}
}
