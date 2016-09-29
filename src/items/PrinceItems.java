package items;

public class PrinceItems {
	private int mySword;
	private int myShield;
	private int myArmour;
	private String[] Sword = new String[5];
	private String[] Shield = new String[5];
	private String[] HeavyArmour = new String[5];
	private int[] SwordStr = new int[5];
	private int[] ShieldVit = new int[5];
	private int[] HeavyArmourVit = new int[5];
	private String[] SwordDes = new String[5];
	private String[] ShieldDes = new String[5];
	private String[] HeavyArmourDes = new String[5];
	
	public PrinceItems(){
		//Set these variables
		mySword = 0;
		myShield = 0;
		myArmour = 0;
		
		//Get these variables
		Sword[0] = "Rapier";
		Sword[1] = "Hero's Gladius";
		Sword[2] = "Onyx Blade";
		Sword[3] = "Astral Blaze";
		Sword[4] = "Dragon's Wraith";
		
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
		
		SwordStr[0] = 5;
		SwordStr[1] = 10;
		SwordStr[2] = 15;
		SwordStr[3] = 20;
		SwordStr[4] = 25;
		
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
		
		SwordDes[0] = "Str +5";
		SwordDes[1] = "Str + 10";
		SwordDes[2] = "Str + 15";
		SwordDes[3] = "Str + 20";
		SwordDes[4] = "Str + 25";
		
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
	
	public void setMySword (int i){
		mySword = i;
	}
	public void setMyShield (int i){
		myShield = i;
	}
	public void setMyArmour (int i){
		myArmour = i;
	}
	
	public String getSwordName(){
		return Sword[mySword];
	}
	public String getShieldName(){
		return Shield[myShield];
	}
	public String getArmourName(){
		return HeavyArmour[myArmour];
	}
	public int getSwordStr(){
		return SwordStr[mySword];
	}
	public int getShieldStr(){
		return ShieldVit[myShield];
	}
	public int getArmourVit(){
		return HeavyArmourVit[myArmour];
	}
	public String getSwordDes(){
		return SwordDes[mySword];
	}
	public String getShieldDes(){
		return ShieldDes[myShield];
	}
	public String getArmourDes(){
		return HeavyArmourDes[myArmour];
	}
	
}
