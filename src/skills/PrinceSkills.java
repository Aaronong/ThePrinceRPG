package skills;

public class PrinceSkills {
	private String[] skillName = new String[6];
	private String[] skillDes = new String[6];
	private Boolean[] skillType = new Boolean[6];
	private Integer[] skillTarget = new Integer[4]; // only active skills
	private Integer[] skillID = new Integer[4];
	
	public PrinceSkills(){
		skillName[0] = "First Aid";
		skillName[1] = "Royal Blood";
		skillName[2] = "Holy Strike";
		skillName[3] = "Soul Force";
		skillName[4] = "Radiance";
		skillName[5] = "Ragnarok";
		skillDes[0] = " Heals one ally for 40hp";
		skillDes[1] = "Prince: +15 Str, +15 Vit";
		skillDes[2] = "Deals 200% dmg to one enemy";
		skillDes[3] = "Heal all allies for 2*Str";
		skillDes[4] = "All allies +20% Str";
		skillDes[5] = "Deal 250% dmg to all enemies";
		skillType[0] = true;
		skillType[1] = false;
		skillType[2] = true;
		skillType[3] = true;
		skillType[4] = false;
		skillType[5] = true;
		// Targets: 1 = enemy, 2 = ally, 3 = all enemy, 4 = all ally, 5 = self, 0 = passive
		skillTarget[0] = 2;
		skillTarget[1] = 1;
		skillTarget[2] = 4;
		skillTarget[3] = 3;
		skillID[0] = 0;
		skillID[1] = 11;
		skillID[2] = 12;
		skillID[3] = 13;
		
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
