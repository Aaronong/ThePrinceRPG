package skills;

public class RangerSkills {
	private String[] skillName = new String[6];
	private String[] skillDes = new String[6];
	private Boolean[] skillType = new Boolean[6];
	private Integer[] skillTarget = new Integer[6];
	private Integer[] skillID = new Integer[6];
	
	public RangerSkills(){
		skillName[0] = "First Aid";
		skillName[1] = "Caltrops";
		skillName[2] = "Wind Flurry";
		skillName[3] = "Fleet Foot";
		skillName[4] = "Jungle Rations";
		skillName[5] = "Storm of Arrows";
		skillDes[0] = "Heals one ally for 40hp";
		skillDes[1] = "Deal 50% dmg per enemy per turn";
		skillDes[2] = "Deals 4*70% dmg to one enemy";
		skillDes[3] = "Ranger: +20 Dex";
		skillDes[4] = "Heal allies for 30% Dex per turn";
		skillDes[5] = "Deal 5*70% dmg to all enemies";
		skillType[0] = true;
		skillType[1] = true;
		skillType[2] = true;
		skillType[3] = false;
		skillType[4] = false;
		skillType[5] = true;
		// Targets: 1 = enemy, 2 = ally, 3 = all enemy, 4 = all ally, 0 = passive, otherwise = battlestatus
		skillTarget[0] = 2;
		skillTarget[1] = 25;
		skillTarget[2] = 1;
		skillTarget[3] = 3;
		skillID[0] = 0;
		skillID[1] = 21;
		skillID[2] =22;
		skillID[3] = 23;
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
