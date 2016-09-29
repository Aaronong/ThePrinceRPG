package skills;

public class PirateSkills {
	private String[] skillName = new String[6];
	private String[] skillDes = new String[6];
	private Boolean[] skillType = new Boolean[6];
	private Integer[] skillTarget = new Integer[6];
	private Integer[] skillID = new Integer[6];
	
	public PirateSkills(){
		skillName[0] = "First Aid";
		skillName[1] = "Swashbuckler";
		skillName[2] = "Whirling Axes";
		skillName[3] = "Mjonir's Tempest";
		skillName[4] = "Rampage";
		skillName[5] = "Admiral's Roar";
		skillDes[0] = "Heals one ally for 40hp";
		skillDes[1] = "Pirate: Atk +50% Def -20%";
		skillDes[2] = "Deal 180% dmg to all enemies";
		skillDes[3] = "+20% dmg to All allies";
		skillDes[4] = "Strike one enemy 4x for 100% dmg";
		skillDes[5] = "All enemies -50% def";
		skillType[0] = true;
		skillType[1] = false;
		skillType[2] = true;
		skillType[3] = false;
		skillType[4] = true;
		skillType[5] = true;
		// Targets: 1 = enemy, 2 = ally, 3 = all enemy, 4 = all ally, 5 = self, 0 = passive
		skillTarget[0] = 2;
		skillTarget[1] = 3;
		skillTarget[2] = 1;
		skillTarget[3] = 55;
		skillID[0] = 0;
		skillID[1] = 51;
		skillID[2] =52;
		skillID[3] = 53;
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
