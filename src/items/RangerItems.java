package items;

public class RangerItems {
	private int myBow;
	private int myQuiver;
	private int myArmour;
	private String[] Bow = new String[5];
	private String[] Quiver = new String[5];
	private String[] LeatherArmour = new String[5];
	private int[] BowDex = new int[5];
	private int[] QuiverDex = new int[5];
	private int[] LeatherArmourVit = new int[5];
	private String[] BowDes = new String[5];
	private String[] QuiverDes = new String[5];
	private String[] LeatherArmourDes = new String[5];
	
	public RangerItems(){
		//Set these variables
		myBow = 0;
		myQuiver = 0;
		myArmour = 0;
		
		//Get these variables
		Bow[0] = "Hunter's Bow";
		Bow[1] = "Ryden";
		Bow[2] = "Vaulter 2000";
		Bow[3] = "Red Viper";
		Bow[4] = "StormSinger";
		
		Quiver[0] = "Wooden Quiver";
		Quiver[1] = "Resnick";
		Quiver[2] = "Firebolt 2000";
		Quiver[3] = "Metus";
		Quiver[4] = "Olympus";
		
		LeatherArmour[0] = "Adaman Vest";
		LeatherArmour[1] = "Brigantine";
		LeatherArmour[2] = "Brave Suit";
		LeatherArmour[3] = "Judo Uniform";
		LeatherArmour[4] = "Dark Elven Armour";
		
		BowDex[0] = 5;
		BowDex[1] = 10;
		BowDex[2] = 15;
		BowDex[3] = 20;
		BowDex[4] = 25;
		
		QuiverDex[0] = 3;
		QuiverDex[1] = 6;
		QuiverDex[2] = 9;
		QuiverDex[3] = 12;
		QuiverDex[4] = 15;
		
		LeatherArmourVit[0] = 5;
		LeatherArmourVit[1] = 10;
		LeatherArmourVit[2] = 15;
		LeatherArmourVit[3] = 20;
		LeatherArmourVit[4] = 25;
		
		BowDes[0] = "Dex +5";
		BowDes[1] = "Dex + 10";
		BowDes[2] = "Dex + 15";
		BowDes[3] = "Dex + 20";
		BowDes[4] = "Dex + 25";
		
		QuiverDes[0] = "Dex +3";
		QuiverDes[1] = "Dex +6";
		QuiverDes[2] = "Dex +9";
		QuiverDes[3] = "Dex +12";
		QuiverDes[4] = "Dex +15";
		
		LeatherArmourDes[0] = "Vit +5";
		LeatherArmourDes[1] = "Vit +10";
		LeatherArmourDes[2] = "Vit +15";
		LeatherArmourDes[3] = "Vit +20";
		LeatherArmourDes[4] = "Vit +25";

	}
	
	public void setMyBow (int i){
		myBow = i;
	}
	public void setMyQuiver (int i){
		myQuiver = i;
	}
	public void setMyArmour (int i){
		myArmour = i;
	}
	
	public String getBowName(){
		return Bow[myBow];
	}
	public String getQuiverName(){
		return Quiver[myQuiver];
	}
	public String getArmourName(){
		return LeatherArmour[myArmour];
	}
	public int getBowDex(){
		return BowDex[myBow];
	}
	public int getQuiverDex(){
		return QuiverDex[myQuiver];
	}
	public int getArmourVit(){
		return LeatherArmourVit[myArmour];
	}
	public String getBowDes(){
		return BowDes[myBow];
	}
	public String getQuiverDes(){
		return QuiverDes[myQuiver];
	}
	public String getArmourDes(){
		return LeatherArmourDes[myArmour];
	}

}
