package data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import utils.Utils;

public class Loader {
	
	private String path;
	private int stateID;
	private int x_coord,y_coord;
	private int EXP;
	private int Gold;
	private String player1_name;
	private String player2_name;
	private String player3_name;
	private String player4_name;
	private int [] player1_data = new int [10];
	private int [] player2_data = new int [10];
	private int [] player3_data = new int [10];
	private int [] player4_data = new int [10];
	private int [] item_data = new int [5];
	private boolean castle_key;
	private boolean bug_spray;
	private boolean sun_block;
	private boolean ferry_pass;
	private boolean winter_wear;
	
	private int player1_job;
	private String player1_jobS;
	private int player1_str;
	private int player1_dex;
	private int player1_int;
	private int player1_vit;
	private int player1_pri_eq;
	private int player1_sec_eq;
	private int player1_armour;
	private int player1_currHp;
	private int player1_currMp;
	private int player1_hp;
	private int player1_mp;
	private int player1_patk;
	private int player1_pdef;
	private int player1_matk;
	private int player1_mdef;
	private int player1_crit;
	private int player1_avoid;
	private String player1_pri;
	private String player1_sec;
	
	private int player2_job;
	private String player2_jobS;
	private int player2_str;
	private int player2_dex;
	private int player2_int;
	private int player2_vit;
	private int player2_pri_eq;
	private int player2_sec_eq;
	private int player2_armour;
	private int player2_currHp;
	private int player2_currMp;
	private int player2_hp;
	private int player2_mp;
	private int player2_patk;
	private int player2_pdef;
	private int player2_matk;
	private int player2_mdef;
	private int player2_crit;
	private int player2_avoid;
	private String player2_pri;
	private String player2_sec;
	
	private int player3_job;
	private String player3_jobS;
	private int player3_str;
	private int player3_dex;
	private int player3_int;
	private int player3_vit;
	private int player3_pri_eq;
	private int player3_sec_eq;
	private int player3_armour;
	private int player3_currHp;
	private int player3_currMp;
	private int player3_hp;
	private int player3_mp;
	private int player3_patk;
	private int player3_pdef;
	private int player3_matk;
	private int player3_mdef;
	private int player3_crit;
	private int player3_avoid;
	private String player3_pri;
	private String player3_sec;
	
	private int player4_job;
	private String player4_jobS;
	private int player4_str;
	private int player4_dex;
	private int player4_int;
	private int player4_vit;
	private int player4_pri_eq;
	private int player4_sec_eq;
	private int player4_armour;
	private int player4_currHp;
	private int player4_currMp;
	private int player4_hp;
	private int player4_mp;
	private int player4_patk;
	private int player4_pdef;
	private int player4_matk;
	private int player4_mdef;
	private int player4_crit;
	private int player4_avoid;
	private String player4_pri;
	private String player4_sec;
	
	public Loader (String path, boolean newgame)
	{
		try {
			loadData (path, newgame);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		castle_key = setItem(0);
		bug_spray = setItem(1);
		sun_block = setItem(2);
		ferry_pass = setItem(3);
		winter_wear = setItem(4);
		System.out.println(castle_key);
		
		player1_job = player1_data[0];
		player1_jobS = setJobS(player1_job);
		player1_str = player1_data[1];
		player1_dex = player1_data[2];
		player1_int = player1_data[3];
		player1_vit = player1_data[4];
		player1_pri_eq = player1_data[5];
		player1_sec_eq = player1_data[6];
		player1_armour = player1_data[7];

		player1_hp = setHP(player1_job, player1_vit);
		player1_mp = setMP(player1_job, player1_int);
		setPlayer1_currHp(player1_data[8]);
		player1_currHp = getPlayer1_currHp();
		setPlayer1_currMp(player1_data[9]);
		player1_currMp = getPlayer1_currMp();
		player1_patk = setPatk(player1_job, player1_str, player1_dex);
		player1_pdef = setPdef(player1_job, player1_vit, player1_str);
		player1_matk = setMatk(player1_job, player1_int);
		player1_mdef = setMdef(player1_job, player1_int);
		player1_crit = setCrit(player1_job, player1_str, player1_dex);
		player1_avoid= setAvoid(player1_job, player1_dex);
		player1_pri = setPrimaryAttribute (player1_job);
		player1_sec = setSecondaryAttrubute (player1_job);
		
		player2_job = player2_data[0];
		player2_jobS = setJobS(player2_job);
		player2_str = player2_data[1];
		player2_dex = player2_data[2];
		player2_int = player2_data[3];
		player2_vit = player2_data[4];
		player2_pri_eq = player2_data[5];
		player2_sec_eq = player2_data[6];
		player2_armour = player2_data[7];

		player2_hp = setHP(player2_job, player2_vit);
		player2_mp = setMP(player2_job, player2_int);
		setPlayer2_currHp(player2_data[8]);
		player2_currHp = getPlayer2_currHp();
		setPlayer2_currMp(player2_data[9]);
		player2_currMp = getPlayer2_currMp();
		player2_patk = setPatk(player2_job, player2_str, player2_dex);
		player2_pdef = setPdef(player2_job, player2_vit, player2_str);
		player2_matk = setMatk(player2_job, player2_int);
		player2_mdef = setMdef(player2_job, player2_int);
		player2_crit = setCrit(player2_job, player2_str, player2_dex);
		player2_avoid= setAvoid(player2_job, player2_dex);
		player2_pri = setPrimaryAttribute (player2_job);
		player2_sec = setSecondaryAttrubute (player2_job);
		
		player3_job = player3_data[0];
		player3_jobS = setJobS(player3_job);
		player3_str = player3_data[1];
		player3_dex = player3_data[2];
		player3_int = player3_data[3];
		player3_vit = player3_data[4];
		player3_pri_eq = player3_data[5];
		player3_sec_eq = player3_data[6];
		player3_armour = player3_data[7];
		
		player3_hp = setHP(player3_job, player3_vit);
		player3_mp = setMP(player3_job, player3_int);
		setPlayer3_currHp(player3_data[8]);
		player3_currHp = getPlayer3_currHp();
		setPlayer3_currMp(player3_data[9]);
		player3_currMp = getPlayer3_currMp();
		player3_patk = setPatk(player3_job, player3_str, player3_dex);
		player3_pdef = setPdef(player3_job, player3_vit, player3_str);
		player3_matk = setMatk(player3_job, player3_int);
		player3_mdef = setMdef(player3_job, player3_int);
		player3_crit = setCrit(player3_job, player3_str, player3_dex);
		player3_avoid= setAvoid(player3_job, player3_dex);
		player3_pri = setPrimaryAttribute (player3_job);
		player3_sec = setSecondaryAttrubute (player3_job);
		
		player4_job = player4_data[0];
		player4_jobS = setJobS(player4_job);
		player4_str = player4_data[1];
		player4_dex = player4_data[2];
		player4_int = player4_data[3];
		player4_vit = player4_data[4];
		player4_pri_eq = player4_data[5];
		player4_sec_eq = player4_data[6];
		player4_armour = player4_data[7];

		player4_hp = setHP(player4_job, player4_vit);
		player4_mp = setMP(player4_job, player4_int);
		setPlayer4_currHp(player4_data[8]);
		player4_currHp = getPlayer4_currHp();
		setPlayer4_currMp(player4_data[9]);
		player4_currMp = getPlayer4_currMp();
		player4_patk = setPatk(player4_job, player4_str, player4_dex);
		player4_pdef = setPdef(player4_job, player4_vit, player4_str);
		player4_matk = setMatk(player4_job, player4_int);
		player4_mdef = setMdef(player4_job, player4_int);
		player4_crit = setCrit(player4_job, player4_str, player4_dex);
		player4_avoid= setAvoid(player4_job, player4_dex);
		player4_pri = setPrimaryAttribute (player4_job);
		player4_sec = setSecondaryAttrubute (player4_job);
	}
	
	private void loadData(String path, boolean newgame) throws IOException{
		String file = Utils.loadFile(path,newgame);
		this.path = path;
		String[] tokens = file.split("\\s+");
		stateID = Utils.parseInt(tokens[0]);
		x_coord = Utils.parseInt(tokens[1]);
		y_coord = Utils.parseInt(tokens[2]);
		EXP = Utils.parseInt(tokens[3]);
		Gold = Utils.parseInt(tokens[4]);
		
		for (int k = 0 ; k < 52; k ++){
			if (k % 11 == 5)
				System.out.println(tokens[k]);
			else
				System.out.println(Utils.parseInt(tokens[k]));
		}
		
		player1_name = tokens[5];
		for (int y = 0; y < 10; y++){
			player1_data[y] = Utils.parseInt(tokens[y+6]);
			//System.out.println(player1_data[y]);
		}
		player2_name = tokens[16];
		for (int y = 0; y < 10; y++){
			player2_data[y] = Utils.parseInt(tokens[y+17]);
		}
		player3_name = tokens[27];
		for (int y = 0; y < 10; y++){
			player3_data[y] = Utils.parseInt(tokens[y+28]);
		}
		player4_name = tokens[38];
		for (int y = 0; y < 10; y++){
			player4_data[y] = Utils.parseInt(tokens[y+39]);
		}
		for (int y = 0; y < 5; y++){
			item_data[y] = Utils.parseInt(tokens[y+49]);
		}
	}
		
	public void saveData(String path) {
		StringBuilder saveString = new StringBuilder();
		saveString.append(stateID+"\r\n");
		saveString.append(x_coord+" ");
		saveString.append(y_coord+"\r\n");
		saveString.append(EXP+"\r\n");
		saveString.append(Gold+"\r\n");
		
		saveString.append(player1_name + " ");
		saveString.append(player1_job + " ");
		saveString.append(player1_str + " ");
		saveString.append(player1_dex + " ");
		saveString.append(player1_int + " ");
		saveString.append(player1_vit + " ");
		saveString.append(player1_pri_eq + " ");
		saveString.append(player1_sec_eq + " ");
		saveString.append(player1_armour + " ");
		saveString.append(player1_currHp + " ");
		saveString.append(player1_currMp + "\r\n");
		
		saveString.append(player2_name + " ");
		saveString.append(player2_job + " ");
		saveString.append(player2_str + " ");
		saveString.append(player2_dex + " ");
		saveString.append(player2_int + " ");
		saveString.append(player2_vit + " ");
		saveString.append(player2_pri_eq + " ");
		saveString.append(player2_sec_eq + " ");
		saveString.append(player2_armour + " ");
		saveString.append(player2_currHp + " ");
		saveString.append(player2_currMp + "\r\n");
		
		saveString.append(player3_name + " ");
		saveString.append(player3_job + " ");
		saveString.append(player3_str + " ");
		saveString.append(player3_dex + " ");
		saveString.append(player3_int + " ");
		saveString.append(player3_vit + " ");
		saveString.append(player3_pri_eq + " ");
		saveString.append(player3_sec_eq + " ");
		saveString.append(player3_armour + " ");
		saveString.append(player3_currHp + " ");
		saveString.append(player3_currMp + "\r\n");
		
		saveString.append(player4_name + " ");
		saveString.append(player4_job + " ");
		saveString.append(player4_str + " ");
		saveString.append(player4_dex + " ");
		saveString.append(player4_int + " ");
		saveString.append(player4_vit + " ");
		saveString.append(player4_pri_eq + " ");
		saveString.append(player4_sec_eq + " ");
		saveString.append(player4_armour + " ");
		saveString.append(player4_currHp + " ");
		saveString.append(player4_currMp + "\r\n");

		if (castle_key)
			saveString.append("1 ");
		else
			saveString.append("0 ");
		
		if (bug_spray)
			saveString.append("1 ");
		else
			saveString.append("0 ");
		if (sun_block)
			saveString.append("1 ");
		else
			saveString.append("0 ");
		if (ferry_pass)
			saveString.append("1 ");
		else
			saveString.append("0 ");
		if (winter_wear)
			saveString.append("1 ");
		else
			saveString.append("0 ");
		
		PrintWriter writer;
		try {
			writer = new PrintWriter("saveState.txt", "UTF-8");
			writer.println(saveString);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		URL resourceUrl = getClass().getResource(path);
//		File file;
//		try {
//			file = new File(resourceUrl.toURI());
//			OutputStream output = new FileOutputStream(file);
//			PrintWriter writer = new PrintWriter(output);
//			writer.println(saveString + System.getProperty("line.seperator"));
//			writer.close();
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		

	}
	
	public Loader levelUp(){
		int str = this.getPlayer1_str();
		int dex = this.getPlayer1_dex();
		int intel = this.getPlayer1_int();
		int vit = this.getPlayer1_vit();
		if (this.setPrimaryAttribute(this.getPlayer1_job()) == "Str")
			str += 4;
		else if (this.setSecondaryAttrubute(this.getPlayer1_job()) == "Str")
			str += 3;
		else
			str += 2;
		if (this.setPrimaryAttribute(this.getPlayer1_job()) == "Dex")
			dex += 4;
		else if (this.setSecondaryAttrubute(this.getPlayer1_job()) == "Dex")
			dex += 3;
		else
			dex += 2;
		if (this.setPrimaryAttribute(this.getPlayer1_job()) == "Int")
			intel += 4;
		else if (this.setSecondaryAttrubute(this.getPlayer1_job()) == "Int")
			intel += 3;
		else
			intel += 2;
		if (this.setPrimaryAttribute(this.getPlayer1_job()) == "Vit")
			vit += 4;
		else if (this.setSecondaryAttrubute(this.getPlayer1_job()) == "Vit")
			vit += 3;
		else
			vit += 2;
		
		//generating random stat gain 2 per level
		for (int k = 0; k < 2; k++){
			double randomStat = Math.random();
			if (randomStat < 0.25)
				str += 1;
			else if (randomStat < 0.5)
				dex += 1;
			else if (randomStat < 0.75)
				intel += 1;
			else
				vit += 1;
		}
		
		this.setPlayer1_str(str);
		this.setPlayer1_dex(dex);
		this.setPlayer1_int(intel);
		this.setPlayer1_vit(vit);
		
		str = this.getPlayer2_str();
		dex = this.getPlayer2_dex();
		intel = this.getPlayer2_int();
		vit = this.getPlayer2_vit();
		if (this.setPrimaryAttribute(this.getPlayer2_job()) == "Str")
			str += 4;
		else if (this.setSecondaryAttrubute(this.getPlayer2_job()) == "Str")
			str += 3;
		else
			str += 2;
		if (this.setPrimaryAttribute(this.getPlayer2_job()) == "Dex")
			dex += 4;
		else if (this.setSecondaryAttrubute(this.getPlayer2_job()) == "Dex")
			dex += 3;
		else
			dex += 2;
		if (this.setPrimaryAttribute(this.getPlayer2_job()) == "Int")
			intel += 4;
		else if (this.setSecondaryAttrubute(this.getPlayer2_job()) == "Int")
			intel += 3;
		else
			intel += 2;
		if (this.setPrimaryAttribute(this.getPlayer2_job()) == "Vit")
			vit += 4;
		else if (this.setSecondaryAttrubute(this.getPlayer2_job()) == "Vit")
			vit += 3;
		else
			vit += 2;
		
		//generating random stat gain
		for (int k = 0; k < 5; k++){
			double randomStat = Math.random();
			if (randomStat < 0.25)
				str += 1;
			else if (randomStat < 0.5)
				dex += 1;
			else if (randomStat < 0.75)
				intel += 1;
			else
				vit += 1;
		}
		
		this.setPlayer2_str(str);
		this.setPlayer2_dex(dex);
		this.setPlayer2_int(intel);
		this.setPlayer2_vit(vit);
		
		str = this.getPlayer3_str();
		dex = this.getPlayer3_dex();
		intel = this.getPlayer3_int();
		vit = this.getPlayer3_vit();
		if (this.setPrimaryAttribute(this.getPlayer3_job()) == "Str")
			str += 4;
		else if (this.setSecondaryAttrubute(this.getPlayer3_job()) == "Str")
			str += 3;
		else
			str += 2;
		if (this.setPrimaryAttribute(this.getPlayer3_job()) == "Dex")
			dex += 4;
		else if (this.setSecondaryAttrubute(this.getPlayer3_job()) == "Dex")
			dex += 3;
		else
			dex += 2;
		if (this.setPrimaryAttribute(this.getPlayer3_job()) == "Int")
			intel += 4;
		else if (this.setSecondaryAttrubute(this.getPlayer3_job()) == "Int")
			intel += 3;
		else
			intel += 2;
		if (this.setPrimaryAttribute(this.getPlayer3_job()) == "Vit")
			vit += 4;
		else if (this.setSecondaryAttrubute(this.getPlayer3_job()) == "Vit")
			vit += 3;
		else
			vit += 2;
		
		//generating random stat gain
		for (int k = 0; k < 5; k++){
			double randomStat = Math.random();
			if (randomStat < 0.25)
				str += 1;
			else if (randomStat < 0.5)
				dex += 1;
			else if (randomStat < 0.75)
				intel += 1;
			else
				vit += 1;
		}
		
		this.setPlayer3_str(str);
		this.setPlayer3_dex(dex);
		this.setPlayer3_int(intel);
		this.setPlayer3_vit(vit);
		
		str = this.getPlayer4_str();
		dex = this.getPlayer4_dex();
		intel = this.getPlayer4_int();
		vit = this.getPlayer4_vit();
		if (this.setPrimaryAttribute(this.getPlayer4_job()) == "Str")
			str += 4;
		else if (this.setSecondaryAttrubute(this.getPlayer4_job()) == "Str")
			str += 3;
		else
			str += 2;
		if (this.setPrimaryAttribute(this.getPlayer4_job()) == "Dex")
			dex += 4;
		else if (this.setSecondaryAttrubute(this.getPlayer4_job()) == "Dex")
			dex += 3;
		else
			dex += 2;
		if (this.setPrimaryAttribute(this.getPlayer4_job()) == "Int")
			intel += 4;
		else if (this.setSecondaryAttrubute(this.getPlayer4_job()) == "Int")
			intel += 3;
		else
			intel += 2;
		if (this.setPrimaryAttribute(this.getPlayer4_job()) == "Vit")
			vit += 4;
		else if (this.setSecondaryAttrubute(this.getPlayer4_job()) == "Vit")
			vit += 3;
		else
			vit += 2;
		
		//generating random stat gain
		for (int k = 0; k < 5; k++){
			double randomStat = Math.random();
			if (randomStat < 0.25)
				str += 1;
			else if (randomStat < 0.5)
				dex += 1;
			else if (randomStat < 0.75)
				intel += 1;
			else
				vit += 1;
		}
		
		this.setPlayer4_str(str);
		this.setPlayer4_dex(dex);
		this.setPlayer4_int(intel);
		this.setPlayer4_vit(vit);
		
		this.saveData("res/saveFiles/saveStateTemp.txt");
		return new Loader("res/saveFiles/saveStateTemp.txt", false);
	}
	


	//Getters and Setters

	public int getLevel() {
		if (EXP < 100)
			return 1;
		else if (EXP < 250)
			return 2;
		else if (EXP < 450)
			return 3;
		else if (EXP < 850)
			return 4;
		else if (EXP < 1450)
			return 5;
		else if (EXP < 2250)
			return 6;
		else if (EXP < 3450)
			return 7;
		else if (EXP < 5250)
			return 8;
		else if (EXP < 7650)
			return 9;
		else if (EXP < 10850)
			return 10;
		else if (EXP < 14850)
			return 11;
		else if (EXP < 19650)
			return 12;
		else if (EXP < 25000)
			return 13;
		else if (EXP < 30500)
			return 14;
		return 15;
	}
	
	private boolean setItem (int itemNum){
		if (item_data[itemNum] == 1)
			return true;
		return false;
	}
	
	private String setJobS (int jobNum)
	{
		if (jobNum == 1)
			return "Prince";
		else if (jobNum == 2)
			return "Ranger";
		else if (jobNum == 3)
			return "Knight";
		else if (jobNum == 4)
			return "Magician";
		else if (jobNum == 5)
			return "Pirate";
		return "Ninja";
	}
	
	public String getPlayer1_jobS() {
		return player1_jobS;
	}
	public String getPlayer2_jobS() {
		return player2_jobS;
	}
	public String getPlayer3_jobS() {
		return player3_jobS;
	}
	public String getPlayer4_jobS() {
		return player4_jobS;
	}
	
	public int setHP(int job, int vit){
		if (job ==1 || job ==2 || job == 4)
			return 30+7*vit;
		else if (job == 3)
			return 30+8*vit;
		return 30+5*vit;
	}
	
	
	public int setMP(int job, int intel){
		if (job == 4)
			return (int) (10+4.5*intel);
		return (int) (10+1.5*intel);
		
	}
	public int setPatk(int job, int str, int dex){
		if (job == 1 || job == 5)
			return (int) (10+str*3.5);
		else if (job == 2 || job == 6)
			return (int) (10+str +dex*2.5);
		else if (job == 3)
			return (int) (10+str*2.5);
		return 10+str;
	}
	public int setPdef(int job, int vit, int str){
		if (job == 3)
			return 2*vit;
		else if (job == 1 || job == 5)
			return (int) (vit + str*0.5);
		return vit;
	}
	public int setMatk(int job, int intel){
		if (job == 4)
			return (int) (10+intel*3.5);
		else if (job == 6)
			return (int) (10+intel*2.5);
		return 10+intel;
	}
	public int setMdef(int job, int intel){
		if (job == 4)
			return intel*2;
		else if (job == 6)
			return (int) (intel*1.5);
		return intel;
	}
	public int setCrit(int job, int str, int dex){
		if (job == 2 || job == 6)
			return (int) (str*0.2+dex*0.7);
		else if (job == 5)
			return (int) (str*0.2 + dex*0.6);
		return (int) (str*0.2 + dex*0.4);
	}
	public int setAvoid(int job, int dex){
		if (job == 2 || job == 6)
			return (int) (dex*0.7);
		return (int) (dex*0.5);
	}

	public String setPrimaryAttribute (int job){
		if (job == 1)
			return "Str";
		if (job == 2)
			return "Dex";
		if (job == 3)
			return "Vit";
		if (job == 4)
			return "Int";
		if (job == 5)
			return "Str";
		else
			return "Dex";
	}
	public String setSecondaryAttrubute (int job){
		if (job == 1)
			return "Vit";
		if (job == 2)
			return "Vit";
		if (job == 3)
			return "Str";
		if (job == 4)
			return "Vit";
		if (job == 5)
			return "Dex";
		else
			return "Int";
	}
	
	public int getStateID() {
		return stateID;
	}

	public void setStateID(int stateID) {
		this.stateID = stateID;
	}


	public int getX_coord() {
		return x_coord;
	}


	public void setX_coord(int x_coord) {
		this.x_coord = x_coord;
	}


	public int getY_coord() {
		return y_coord;
	}


	public void setY_coord(int y_coord) {
		this.y_coord = y_coord;
	}


	public int getEXP() {
		return EXP;
	}


	public void setEXP(int eXP) {
		EXP = eXP;
	}


	public int getGold() {
		return Gold;
	}


	public void setGold(int gold) {
		Gold = gold;
	}

	public String getPlayer1_name() {
		return player1_name;
	}


	public void setPlayer1_name(String player1_name) {
		this.player1_name = player1_name;
	}


	public String getPlayer2_name() {
		return player2_name;
	}


	public void setPlayer2_name(String player2_name) {
		this.player2_name = player2_name;
	}


	public String getPlayer3_name() {
		return player3_name;
	}


	public void setPlayer3_name(String player3_name) {
		this.player3_name = player3_name;
	}


	public String getPlayer4_name() {
		return player4_name;
	}


	public void setPlayer4_name(String player4_name) {
		this.player4_name = player4_name;
	}

	public int[] getPlayer1_data() {
		return player1_data;
	}

	public void setPlayer1_data(int[] player1_data) {
		this.player1_data = player1_data;
	}

	public int[] getPlayer2_data() {
		return player2_data;
	}

	public void setPlayer2_data(int[] player2_data) {
		this.player2_data = player2_data;
	}

	public int[] getPlayer3_data() {
		return player3_data;
	}

	public void setPlayer3_data(int[] player3_data) {
		this.player3_data = player3_data;
	}

	public int[] getPlayer4_data() {
		return player4_data;
	}

	public void setPlayer4_data(int[] player4_data) {
		this.player4_data = player4_data;
	}

	public int getPlayer1_job() {
		return player1_job;
	}

	public void setPlayer1_job(int player1_job) {
		this.player1_job = player1_job;
	}

	public int getPlayer1_str() {
		return player1_str;
	}

	public void setPlayer1_str(int player1_str) {
		this.player1_str = player1_str;
	}

	public int getPlayer1_dex() {
		return player1_dex;
	}

	public void setPlayer1_dex(int player1_dex) {
		this.player1_dex = player1_dex;
	}

	public int getPlayer1_int() {
		return player1_int;
	}

	public void setPlayer1_int(int player1_int) {
		this.player1_int = player1_int;
	}

	public int getPlayer1_vit() {
		return player1_vit;
	}

	public void setPlayer1_vit(int player1_vit) {
		this.player1_vit = player1_vit;
	}

	public int getPlayer1_pri_eq() {
		return player1_pri_eq;
	}

	public void setPlayer1_pri_eq(int player1_pri_eq) {
		this.player1_pri_eq = player1_pri_eq;
	}

	public int getPlayer1_sec_eq() {
		return player1_sec_eq;
	}

	public void setPlayer1_sec_eq(int player1_sec_eq) {
		this.player1_sec_eq = player1_sec_eq;
	}

	public int getPlayer1_armour() {
		return player1_armour;
	}

	public void setPlayer1_armour(int player1_armour) {
		this.player1_armour = player1_armour;
	}

	public int getPlayer2_job() {
		return player2_job;
	}

	public void setPlayer2_job(int player2_job) {
		this.player2_job = player2_job;
	}

	public int getPlayer2_str() {
		return player2_str;
	}

	public void setPlayer2_str(int player2_str) {
		this.player2_str = player2_str;
	}

	public int getPlayer2_dex() {
		return player2_dex;
	}

	public void setPlayer2_dex(int player2_dex) {
		this.player2_dex = player2_dex;
	}

	public int getPlayer2_int() {
		return player2_int;
	}

	public void setPlayer2_int(int player2_int) {
		this.player2_int = player2_int;
	}

	public int getPlayer2_vit() {
		return player2_vit;
	}

	public void setPlayer2_vit(int player2_vit) {
		this.player2_vit = player2_vit;
	}

	public int getPlayer2_pri_eq() {
		return player2_pri_eq;
	}

	public void setPlayer2_pri_eq(int player2_pri_eq) {
		this.player2_pri_eq = player2_pri_eq;
	}

	public int getPlayer2_sec_eq() {
		return player2_sec_eq;
	}

	public void setPlayer2_sec_eq(int player2_sec_eq) {
		this.player2_sec_eq = player2_sec_eq;
	}

	public int getPlayer2_armour() {
		return player2_armour;
	}

	public void setPlayer2_armour(int player2_armour) {
		this.player2_armour = player2_armour;
	}

	public int getPlayer3_job() {
		return player3_job;
	}

	public void setPlayer3_job(int player3_job) {
		this.player3_job = player3_job;
	}

	public int getPlayer3_str() {
		return player3_str;
	}

	public void setPlayer3_str(int player3_str) {
		this.player3_str = player3_str;
	}

	public int getPlayer3_dex() {
		return player3_dex;
	}

	public void setPlayer3_dex(int player3_dex) {
		this.player3_dex = player3_dex;
	}

	public int getPlayer3_int() {
		return player3_int;
	}

	public void setPlayer3_int(int player3_int) {
		this.player3_int = player3_int;
	}

	public int getPlayer3_vit() {
		return player3_vit;
	}

	public void setPlayer3_vit(int player3_vit) {
		this.player3_vit = player3_vit;
	}

	public int getPlayer3_pri_eq() {
		return player3_pri_eq;
	}

	public void setPlayer3_pri_eq(int player3_pri_eq) {
		this.player3_pri_eq = player3_pri_eq;
	}

	public int getPlayer3_sec_eq() {
		return player3_sec_eq;
	}

	public void setPlayer3_sec_eq(int player3_sec_eq) {
		this.player3_sec_eq = player3_sec_eq;
	}

	public int getPlayer3_armour() {
		return player3_armour;
	}

	public void setPlayer3_armour(int player3_armour) {
		this.player3_armour = player3_armour;
	}

	public int getPlayer4_job() {
		return player4_job;
	}

	public void setPlayer4_job(int player4_job) {
		this.player4_job = player4_job;
	}

	public int getPlayer4_str() {
		return player4_str;
	}

	public void setPlayer4_str(int player4_str) {
		this.player4_str = player4_str;
	}

	public int getPlayer4_dex() {
		return player4_dex;
	}

	public void setPlayer4_dex(int player4_dex) {
		this.player4_dex = player4_dex;
	}

	public int getPlayer4_int() {
		return player4_int;
	}

	public void setPlayer4_int(int player4_int) {
		this.player4_int = player4_int;
	}

	public int getPlayer4_vit() {
		return player4_vit;
	}

	public void setPlayer4_vit(int player4_vit) {
		this.player4_vit = player4_vit;
	}

	public int getPlayer4_pri_eq() {
		return player4_pri_eq;
	}

	public void setPlayer4_pri_eq(int player4_pri_eq) {
		this.player4_pri_eq = player4_pri_eq;
	}

	public int getPlayer4_sec_eq() {
		return player4_sec_eq;
	}

	public void setPlayer4_sec_eq(int player4_sec_eq) {
		this.player4_sec_eq = player4_sec_eq;
	}

	public int getPlayer4_armour() {
		return player4_armour;
	}

	public void setPlayer4_armour(int player4_armour) {
		this.player4_armour = player4_armour;
	}

	public int getPlayer1_hp() {
		return player1_hp;
	}

	public void setPlayer1_hp(int player1_hp) {
		this.player1_hp = setHP(player1_job, player1_vit);
	}

	public int getPlayer1_mp() {
		return player1_mp;
	}

	public void setPlayer1_mp(int player1_mp) {
		this.player1_mp = player1_mp;
	}

	public int getPlayer1_patk() {
		return player1_patk;
	}

	public void setPlayer1_patk(int player1_patk) {
		this.player1_patk = player1_patk;
	}

	public int getPlayer1_pdef() {
		return player1_pdef;
	}

	public void setPlayer1_pdef(int player1_pdef) {
		this.player1_pdef = player1_pdef;
	}

	public int getPlayer1_matk() {
		return player1_matk;
	}

	public void setPlayer1_matk(int player1_matk) {
		this.player1_matk = player1_matk;
	}

	public int getPlayer1_mdef() {
		return player1_mdef;
	}

	public void setPlayer1_mdef(int player1_mdef) {
		this.player1_mdef = player1_mdef;
	}

	public int getPlayer1_crit() {
		return player1_crit;
	}

	public void setPlayer1_crit(int player1_crit) {
		this.player1_crit = player1_crit;
	}

	public int getPlayer1_avoid() {
		return player1_avoid;
	}

	public void setPlayer1_avoid(int player1_avoid) {
		this.player1_avoid = player1_avoid;
	}

	public int getPlayer2_hp() {
		return player2_hp;
	}

	public void setPlayer2_hp(int player2_hp) {
		this.player2_hp = setHP(player2_job, player2_vit);
	}

	public int getPlayer2_mp() {
		return player2_mp;
	}

	public void setPlayer2_mp(int player2_mp) {
		this.player2_mp = player2_mp;
	}

	public int getPlayer2_patk() {
		return player2_patk;
	}

	public void setPlayer2_patk(int player2_patk) {
		this.player2_patk = player2_patk;
	}

	public int getPlayer2_pdef() {
		return player2_pdef;
	}

	public void setPlayer2_pdef(int player2_pdef) {
		this.player2_pdef = player2_pdef;
	}

	public int getPlayer2_matk() {
		return player2_matk;
	}

	public void setPlayer2_matk(int player2_matk) {
		this.player2_matk = player2_matk;
	}

	public int getPlayer2_mdef() {
		return player2_mdef;
	}

	public void setPlayer2_mdef(int player2_mdef) {
		this.player2_mdef = player2_mdef;
	}

	public int getPlayer2_crit() {
		return player2_crit;
	}

	public void setPlayer2_crit(int player2_crit) {
		this.player2_crit = player2_crit;
	}

	public int getPlayer2_avoid() {
		return player2_avoid;
	}

	public void setPlayer2_avoid(int player2_avoid) {
		this.player2_avoid = player2_avoid;
	}

	public int getPlayer3_hp() {
		return player3_hp;
	}

	public void setPlayer3_hp(int player3_hp) {
		this.player3_hp = setHP(player3_job, player3_vit);
	}

	public int getPlayer3_mp() {
		return player3_mp;
	}

	public void setPlayer3_mp(int player3_mp) {
		this.player3_mp = player3_mp;
	}

	public int getPlayer3_patk() {
		return player3_patk;
	}

	public void setPlayer3_patk(int player3_patk) {
		this.player3_patk = player3_patk;
	}

	public int getPlayer3_pdef() {
		return player3_pdef;
	}

	public void setPlayer3_pdef(int player3_pdef) {
		this.player3_pdef = player3_pdef;
	}

	public int getPlayer3_matk() {
		return player3_matk;
	}

	public void setPlayer3_matk(int player3_matk) {
		this.player3_matk = player3_matk;
	}

	public int getPlayer3_mdef() {
		return player3_mdef;
	}

	public void setPlayer3_mdef(int player3_mdef) {
		this.player3_mdef = player3_mdef;
	}

	public int getPlayer3_crit() {
		return player3_crit;
	}

	public void setPlayer3_crit(int player3_crit) {
		this.player3_crit = player3_crit;
	}

	public int getPlayer3_avoid() {
		return player3_avoid;
	}

	public void setPlayer3_avoid(int player3_avoid) {
		this.player3_avoid = player3_avoid;
	}

	public int getPlayer4_hp() {
		return player4_hp;
	}

	public void setPlayer4_hp(int player4_hp) {
		this.player4_hp = setHP(player4_job, player4_vit);
	}

	public int getPlayer4_mp() {
		return player4_mp;
	}

	public void setPlayer4_mp(int player4_mp) {
		this.player4_mp = player4_mp;
	}

	public int getPlayer4_patk() {
		return player4_patk;
	}

	public void setPlayer4_patk(int player4_patk) {
		this.player4_patk = player4_patk;
	}

	public int getPlayer4_pdef() {
		return player4_pdef;
	}

	public void setPlayer4_pdef(int player4_pdef) {
		this.player4_pdef = player4_pdef;
	}

	public int getPlayer4_matk() {
		return player4_matk;
	}

	public void setPlayer4_matk(int player4_matk) {
		this.player4_matk = player4_matk;
	}

	public int getPlayer4_mdef() {
		return player4_mdef;
	}

	public void setPlayer4_mdef(int player4_mdef) {
		this.player4_mdef = player4_mdef;
	}

	public int getPlayer4_crit() {
		return player4_crit;
	}

	public void setPlayer4_crit(int player4_crit) {
		this.player4_crit = player4_crit;
	}

	public int getPlayer4_avoid() {
		return player4_avoid;
	}

	public void setPlayer4_avoid(int player4_avoid) {
		this.player4_avoid = player4_avoid;
	}

	public String getPlayer1_pri() {
		return player1_pri;
	}

	public String getPlayer1_sec() {
		return player1_sec;
	}

	public String getPlayer2_pri() {
		return player2_pri;
	}

	public String getPlayer2_sec() {
		return player2_sec;
	}

	public String getPlayer3_pri() {
		return player3_pri;
	}

	public String getPlayer3_sec() {
		return player3_sec;
	}

	public String getPlayer4_pri() {
		return player4_pri;
	}

	public String getPlayer4_sec() {
		return player4_sec;
	}

	public boolean isCastle_key() {
		return castle_key;
	}

	public void setCastle_key(boolean castle_key) {
		this.castle_key = castle_key;
	}

	public boolean isBug_spray() {
		return bug_spray;
	}

	public void setBug_spray(boolean bug_spray) {
		this.bug_spray = bug_spray;
	}

	public boolean isSun_block() {
		return sun_block;
	}

	public void setSun_block(boolean sun_block) {
		this.sun_block = sun_block;
	}

	public boolean isFerry_pass() {
		return ferry_pass;
	}

	public void setFerry_pass(boolean ferry_pass) {
		this.ferry_pass = ferry_pass;
	}

	public boolean isWinter_wear() {
		return winter_wear;
	}

	public void setWinter_wear(boolean winter_wear) {
		this.winter_wear = winter_wear;
	}

	public int getPlayer1_currHp() {
		return this.player1_currHp;
	}

	public void setPlayer1_currHp(int player1_currHp) {
		this.player1_currHp = Math.min(player1_currHp, getPlayer1_hp());
		this.player1_currHp = Math.max(this.player1_currHp, 0);
	}

	public int getPlayer1_currMp() {
		return player1_currMp;
	}

	public void setPlayer1_currMp(int player1_currMp) {
		this.player1_currMp = Math.min(player1_currMp,player1_mp);
		this.player1_currMp = Math.max(this.player1_currMp, 0);
	}

	public int getPlayer2_currHp() {
		return player2_currHp;
	}

	public void setPlayer2_currHp(int player2_currHp) {
		this.player2_currHp = Math.min(player2_currHp, player2_hp);
		this.player2_currHp = Math.max(this.player2_currHp, 0);
	}

	public int getPlayer2_currMp() {
		return player2_currMp;
	}

	public void setPlayer2_currMp(int player2_currMp) {
		this.player2_currMp = Math.min(player2_currMp,player2_mp);
		this.player2_currMp = Math.max(this.player2_currMp, 0);
	}

	public int getPlayer3_currHp() {
		return player3_currHp;
	}

	public void setPlayer3_currHp(int player3_currHp) {
		this.player3_currHp = Math.min(player3_currHp, player3_hp);
		this.player3_currHp = Math.max(this.player3_currHp, 0);
	}

	public int getPlayer3_currMp() {
		return player3_currMp;
	}

	public void setPlayer3_currMp(int player3_currMp) {
		this.player3_currMp = Math.min(player3_currMp,player3_mp);
		this.player3_currMp = Math.max(this.player3_currMp, 0);
	}

	public int getPlayer4_currHp() {
		return player4_currHp;
	}

	public void setPlayer4_currHp(int player4_currHp) {
		this.player4_currHp = Math.min(player4_currHp, player4_hp);
		this.player4_currHp = Math.max(this.player4_currHp, 0);
	}

	public int getPlayer4_currMp() {
		return player4_currMp;
	}

	public void setPlayer4_currMp(int player4_currMp) {
		this.player4_currMp = Math.min(player4_currMp,player4_mp);
		this.player4_currMp = Math.max(this.player4_currMp, 0);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}


	

}
