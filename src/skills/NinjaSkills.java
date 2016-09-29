package skills;

public class NinjaSkills {
	private String[] skillName = new String[6];
	private String[] skillDes = new String[6];
	private Boolean[] skillType = new Boolean[6];
	private Integer[] skillTarget = new Integer[6];
	private Integer[] skillID = new Integer[6];
	
	public NinjaSkills(){
		skillName[0] = "First Aid";
		skillName[1] = "Byakugan";
		skillName[2] = "Saisei No Jutsu";
		skillName[3] = "Chidori";
		skillName[4] = "Kyuin Jutsu";
		skillName[5] = "Amaterasu";
		skillDes[0] = "Heals one ally for 40hp";
		skillDes[1] = "Ninja: Lifesteal, Crit, Avoid + 15%";
		skillDes[2] = "Heal one ally for (Dex + Int)*3";
		skillDes[3] = "Deal 400% P.dmg to one enemy";
		skillDes[4] = "Ninja: +20% Lifesteal";
		skillDes[5] = "Deal 600% M.dmg to all enemies";
		skillType[0] = true;
		skillType[1] = false;
		skillType[2] = true;
		skillType[3] = true;
		skillType[4] = false;
		skillType[5] = true;
		// Targets: 1 = enemy, 2 = ally, 3 = all enemy, 4 = all ally, 5 = self, 0 = passive
		skillTarget[0] = 2;
		skillTarget[1] = 2;
		skillTarget[2] = 1;
		skillTarget[3] = 3;
		skillID[0] = 0;
		skillID[1] = 61;
		skillID[2] =62;
		skillID[3] = 63;
		
	}
	
	public String getSkillName (int skillNum){
		return skillName[skillNum];
	}
	
	public String getSkillDes (int skillNum){
		return skillDes[skillNum];
	}
	public Boolean getSkillType (int skillNum){
		return skillType[skillNum];
	}
	public String getSkillTypeStr (int skillNum){
		if (skillType[skillNum]){
			return "Active";
		}
		return "Passive";
	}
	public int getSkillTarget (int skillNum){
		return skillTarget[skillNum];
	}
	public Integer getSkillID(int skillNum) {
		return skillID[skillNum];
	}
}
