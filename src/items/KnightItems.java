package items;

public class KnightItems {
	private int mySpear;
	private int myShield;
	private int myArmour;
	private String[] Spear = new String[5];
	private String[] Shield = new String[5];
	private String[] HeavyArmour = new String[5];
	private int[] SpearStr = new int[5];
	private int[] ShieldVit = new int[5];
	private int[] HeavyArmourVit = new int[5];
	private String[] SpearDes = new String[5];
	private String[] ShieldDes = new String[5];
	private String[] HeavyArmourDes = new String[5];
	public KnightItems(){
		//Set these variables
		mySpear = 0;
		myShield = 0;
		myArmour = 0;
		
		//Get these variables
		Spear[0] = "Fork Spear";
		Spear[1] = "Beryl Impaler";
		Spear[2] = "Renegade Redemption";
		Spear[3] = "Serpent's Tongue";
		Spear[4] = "Dragon's Fury";
		
		Shield[0] = "Wooden Buckler";
		Shield[1] = "Steel Shield";
		Shield[2] = "Adamantium Tower";
		Shield[3] = "Silver Hoflon";
		Shield[4] = "Dragon's Hide";
		
		HeavyArmour[0] = "Blue Corporal";
		HeavyArmour[1] = "Dark Sergeant";
		HeavyArmour[2] = "Jangoon Armour";
		HeavyArmour[3] = "The Commodore";
		HeavyArmour[4] = "Kaiser Brave Mail";
		
		SpearStr[0] = 5;
		SpearStr[1] = 10;
		SpearStr[2] = 15;
		SpearStr[3] = 20;
		SpearStr[4] = 25;
		
		ShieldVit[0] = 3;
		ShieldVit[1] = 6;
		ShieldVit[2] = 9;
		ShieldVit[3] = 12;
		ShieldVit[4] = 15;
		
		HeavyArmourVit[0] = 5;
		HeavyArmourVit[1] = 10;
		HeavyArmourVit[2] = 15;
		HeavyArmourVit[3] = 20;
		HeavyArmourVit[4] = 25;
		
		SpearDes[0] = "Str +5";
		SpearDes[1] = "Str + 10";
		SpearDes[2] = "Str + 15";
		SpearDes[3] = "Str + 20";
		SpearDes[4] = "Str + 25";
		
		ShieldDes[0] = "Vit +3";
		ShieldDes[1] = "Vit +6";
		ShieldDes[2] = "Vit +9";
		ShieldDes[3] = "Vit +12";
		ShieldDes[4] = "Vit +15";
		
		HeavyArmourDes[0] = "Vit +5";
		HeavyArmourDes[1] = "Vit +10";
		HeavyArmourDes[2] = "Vit +15";
		HeavyArmourDes[3] = "Vit +20";
		HeavyArmourDes[4] = "Vit +25";

	}
	
	public void setMySpear (int i){
		mySpear = i;
	}
	public void setMyShield (int i){
		myShield = i;
	}
	public void setMyArmour (int i){
		myArmour = i;
	}
	
	public String getSpearName(){
		return Spear[mySpear];
	}
	public String getShieldName(){
		return Shield[myShield];
	}
	public String getArmourName(){
		return HeavyArmour[myArmour];
	}
	public int getSpearStr(){
		return SpearStr[mySpear];
	}
	public int getShieldStr(){
		return ShieldVit[myShield];
	}
	public int getArmourVit(){
		return HeavyArmourVit[myArmour];
	}
	public String getSpearDes(){
		return SpearDes[mySpear];
	}
	public String getShieldDes(){
		return ShieldDes[myShield];
	}
	public String getArmourDes(){
		return HeavyArmourDes[myArmour];
	}
}
