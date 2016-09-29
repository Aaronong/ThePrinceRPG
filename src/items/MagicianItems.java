package items;

public class MagicianItems {
	private int myStaff;
	private int myMagicEssence;
	private int myArmour;
	private String[] Staff = new String[5];
	private String[] MagicEssence = new String[5];
	private String[] LightArmour = new String[5];
	private int[] StaffInt = new int[5];
	private int[] MagicEssenceInt = new int[5];
	private int[] LightArmourVit = new int[5];
	private String[] StaffDes = new String[5];
	private String[] MagicEssenceDes = new String[5];
	private String[] LightArmourDes = new String[5];
	
	public MagicianItems(){
		//Set these variables
		myStaff = 0;
		myMagicEssence = 0;
		myArmour = 0;
		
		//Get these variables
		Staff[0] = "Oak Staff";
		Staff[1] = "Wizard's pride";
		Staff[2] = "Manabreaker";
		Staff[3] = "Dark Laevateinn";
		Staff[4] = "Seraphim";
		
		MagicEssence[0] = "Rabbit's Foot";
		MagicEssence[1] = "Magic Mushroom";
		MagicEssence[2] = "Timeless Myst";
		MagicEssence[3] = "Fairy Dust";
		MagicEssence[4] = "Phoenix Teardrop";
		
		LightArmour[0] = "Plain Robe";
		LightArmour[1] = "Explorer's moonlight";
		LightArmour[2] = "Dark Chaos Robe";
		LightArmour[3] = "Oriental Fury";
		LightArmour[4] = "Balzag's Requiem";
		
		StaffInt[0] = 5;
		StaffInt[1] = 10;
		StaffInt[2] = 15;
		StaffInt[3] = 20;
		StaffInt[4] = 25;
		
		MagicEssenceInt[0] = 3;
		MagicEssenceInt[1] = 6;
		MagicEssenceInt[2] = 9;
		MagicEssenceInt[3] = 12;
		MagicEssenceInt[4] = 15;
		
		LightArmourVit[0] = 5;
		LightArmourVit[1] = 10;
		LightArmourVit[2] = 15;
		LightArmourVit[3] = 20;
		LightArmourVit[4] = 25;
		
		StaffDes[0] = "Int +5";
		StaffDes[1] = "Int + 10";
		StaffDes[2] = "Int + 15";
		StaffDes[3] = "Int + 20";
		StaffDes[4] = "Int + 25";
		
		MagicEssenceDes[0] = "Int +3";
		MagicEssenceDes[1] = "Int +6";
		MagicEssenceDes[2] = "Int +9";
		MagicEssenceDes[3] = "Int +12";
		MagicEssenceDes[4] = "Int +15";
		
		LightArmourDes[0] = "Vit +5";
		LightArmourDes[1] = "Vit +10";
		LightArmourDes[2] = "Vit +15";
		LightArmourDes[3] = "Vit +20";
		LightArmourDes[4] = "Vit +25";

	}
	
	public void setMyStaff (int i){
		myStaff = i;
	}
	public void setMyMagicEssence (int i){
		myMagicEssence = i;
	}
	public void setMyArmour (int i){
		myArmour = i;
	}
	
	public String getStaffName(){
		return Staff[myStaff];
	}
	public String getMagicEssenceName(){
		return MagicEssence[myMagicEssence];
	}
	public String getArmourName(){
		return LightArmour[myArmour];
	}
	public int getStaffInt(){
		return StaffInt[myStaff];
	}
	public int getMagicEssenceInt(){
		return MagicEssenceInt[myMagicEssence];
	}
	public int getArmourVit(){
		return LightArmourVit[myArmour];
	}
	public String getStaffDes(){
		return StaffDes[myStaff];
	}
	public String getMagicEssenceDes(){
		return MagicEssenceDes[myMagicEssence];
	}
	public String getArmourDes(){
		return LightArmourDes[myArmour];
	}

}
