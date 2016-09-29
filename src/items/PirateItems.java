package items;

public class PirateItems {
	private int myAxe;
	private int myThrowingAxe;
	private int myArmour;
	private String[] Axe = new String[5];
	private String[] ThrowingAxe = new String[5];
	private String[] LeatherArmour = new String[5];
	private int[] AxeStr = new int[5];
	private int[] ThrowingAxeDex = new int[5];
	private int[] LeatherArmourVit = new int[5];
	private String[] AxeDes = new String[5];
	private String[] ThrowingAxeDes = new String[5];
	private String[] LeatherArmourDes = new String[5];
	public PirateItems(){
		//Set these variables
		myAxe = 0;
		myThrowingAxe = 0;
		myArmour = 0;
		
		//Get these variables
		Axe[0] = "Lumberjack";
		Axe[1] = "Demon Axe";
		Axe[2] = "Balrog's Helios";
		Axe[3] = "The Riser";
		Axe[4] = "Terminus Devastator";
		
		ThrowingAxe[0] = "Blue Counter";
		ThrowingAxe[1] = "Crescent Moon";
		ThrowingAxe[2] = "Reverse Tomahawk";
		ThrowingAxe[3] = "Umbra Skyrender";
		ThrowingAxe[4] = "Tempest Butterfly";
		
		LeatherArmour[0] = "Adaman Vest";
		LeatherArmour[1] = "Brigantine";
		LeatherArmour[2] = "Brave Suit";
		LeatherArmour[3] = "Judo Uniform";
		LeatherArmour[4] = "Dark Elven Armour";
		
		AxeStr[0] = 5;
		AxeStr[1] = 10;
		AxeStr[2] = 15;
		AxeStr[3] = 20;
		AxeStr[4] = 25;
		
		ThrowingAxeDex[0] = 3;
		ThrowingAxeDex[1] = 6;
		ThrowingAxeDex[2] = 9;
		ThrowingAxeDex[3] = 12;
		ThrowingAxeDex[4] = 15;
		
		LeatherArmourVit[0] = 5;
		LeatherArmourVit[1] = 10;
		LeatherArmourVit[2] = 15;
		LeatherArmourVit[3] = 20;
		LeatherArmourVit[4] = 25;
		
		AxeDes[0] = "Str +5";
		AxeDes[1] = "Str + 10";
		AxeDes[2] = "Str + 15";
		AxeDes[3] = "Str + 20";
		AxeDes[4] = "Str + 25";
		
		ThrowingAxeDes[0] = "Dex +3";
		ThrowingAxeDes[1] = "Dex +6";
		ThrowingAxeDes[2] = "Dex +9";
		ThrowingAxeDes[3] = "Dex +12";
		ThrowingAxeDes[4] = "Dex +15";
		
		LeatherArmourDes[0] = "Vit +5";
		LeatherArmourDes[1] = "Vit +10";
		LeatherArmourDes[2] = "Vit +15";
		LeatherArmourDes[3] = "Vit +20";
		LeatherArmourDes[4] = "Vit +25";

	}
	
	public void setMyAxe (int i){
		myAxe = i;
	}
	public void setMyThrowingAxe (int i){
		myThrowingAxe = i;
	}
	public void setMyArmour (int i){
		myArmour = i;
	}
	
	public String getAxeName(){
		return Axe[myAxe];
	}
	public String getThrowingAxeName(){
		return ThrowingAxe[myThrowingAxe];
	}
	public String getArmourName(){
		return LeatherArmour[myArmour];
	}
	public int getAxeStr(){
		return AxeStr[myAxe];
	}
	public int getThrowingAxeDex(){
		return ThrowingAxeDex[myThrowingAxe];
	}
	public int getArmourVit(){
		return LeatherArmourVit[myArmour];
	}
	public String getAxeDes(){
		return AxeDes[myAxe];
	}
	public String getThrowingAxeDes(){
		return ThrowingAxeDes[myThrowingAxe];
	}
	public String getArmourDes(){
		return LeatherArmourDes[myArmour];
	}

}

