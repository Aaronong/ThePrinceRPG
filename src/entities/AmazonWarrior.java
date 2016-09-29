package entities;

import java.awt.image.BufferedImage;
import gfx.Assets;

class AmazonWarrior extends Monster{
	private static int str = 11;
	private static int dex = 15;
	private static int intel = 8;
	private static int vit = 12;
	private static int exp = 65;
	private static BufferedImage anim = Assets.amaWarrior;
	
	AmazonWarrior(){
		super(str,dex,intel,vit, exp, anim, "Amazon Warrior");
		
	}
}
