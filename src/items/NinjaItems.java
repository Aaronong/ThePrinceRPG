package items;

public class NinjaItems {
	private int myShuriken;
	private int myCloak;
	private int myArmour;
	private String[] Shuriken = new String[5];
	private String[] Cloak = new String[5];
	private String[] LightArmour = new String[5];
	private int[] ShurikenDex = new int[5];
	private int[] CloakInt = new int[5];
	private int[] LightArmourVit = new int[5];
	private String[] ShurikenDes = new String[5];
	private String[] CloakDes = new String[5];
	private String[] LightArmourDes = new String[5];
	public NinjaItems(){
		//Set these variables
		myShuriken = 0;
		myCloak = 0;
		myArmour = 0;
		
		//Get these variables
		Shuriken[0] = "Origami Plane";
		Shuriken[1] = "Yamamoto's Kunai";
		Shuriken[2] = "Crystal Ilbi";
		Shuriken[3] = "Balanced Fury";
		Shuriken[4] = "Tsukiyomi's Icicles";
		
		Cloak[0] = "Shinobi's Cloak";
		Cloak[1] = "Yamamoto's Shadow";
		Cloak[2] = "Raven Dispersion";
		Cloak[3] = "Black Hole";
		Cloak[4] = "Tsukiyomi's Shadow";
		
		LightArmour[0] = "Plain Robe";
		LightArmour[1] = "Explorer's moonlight";
		LightArmour[2] = "Dark Chaos Robe";
		LightArmour[3] = "Oriental Fury";
		LightArmour[4] = "Balzag's Requiem";
		
		ShurikenDex[0] = 5;
		ShurikenDex[1] = 10;
		ShurikenDex[2] = 15;
		ShurikenDex[3] = 20;
		ShurikenDex[4] = 25;
		
		CloakInt[0] = 3;
		CloakInt[1] = 6;
		CloakInt[2] = 9;
		CloakInt[3] = 12;
		CloakInt[4] = 15;
		
		LightArmourVit[0] = 5;
		LightArmourVit[1] = 10;
		LightArmourVit[2] = 15;
		LightArmourVit[3] = 20;
		LightArmourVit[4] = 25;
		
		ShurikenDes[0] = "Int +5";
		ShurikenDes[1] = "Int + 10";
		ShurikenDes[2] = "Int + 15";
		ShurikenDes[3] = "Int + 20";
		ShurikenDes[4] = "Int + 25";
		
		CloakDes[0] = "Int +3";
		CloakDes[1] = "Int +6";
		CloakDes[2] = "Int +9";
		CloakDes[3] = "Int +12";
		CloakDes[4] = "Int +15";
		
		LightArmourDes[0] = "Vit +5";
		LightArmourDes[1] = "Vit +10";
		LightArmourDes[2] = "Vit +15";
		LightArmourDes[3] = "Vit +20";
		LightArmourDes[4] = "Vit +25";

	}
	
	public void setMyShuriken (int i){
		myShuriken = i;
	}
	public void setMyCloak (int i){
		myCloak = i;
	}
	public void setMyArmour (int i){
		myArmour = i;
	}
	
	public String getShurikenName(){
		return Shuriken[myShuriken];
	}
	public String getCloakName(){
		return Cloak[myCloak];
	}
	public String getArmourName(){
		return LightArmour[myArmour];
	}
	public int getShurikenDex(){
		return ShurikenDex[myShuriken];
	}
	public int getCloakInt(){
		return CloakInt[myCloak];
	}
	public int getArmourVit(){
		return LightArmourVit[myArmour];
	}
	public String getShurikenDes(){
		return ShurikenDes[myShuriken];
	}
	public String getCloakDes(){
		return CloakDes[myCloak];
	}
	public String getArmourDes(){
		return LightArmourDes[myArmour];
	}

}
