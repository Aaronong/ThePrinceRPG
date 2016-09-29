package skills;

public class MagicianSkills {
	private String[] skillName = new String[6];
	private String[] skillDes = new String[6];
	private Boolean[] skillType = new Boolean[6];
	private Integer[] skillTarget = new Integer[6];
	private Integer[] skillID = new Integer[6];
	
	public MagicianSkills(){
		skillName[0] = "First Aid";
		skillName[1] = "Energy Bolt";
		skillName[2] = "Mana Well";
		skillName[3] = "Healing Rain";
		skillName[4] = "Enlightenment";
		skillName[5] = "Apocalypse";
		skillDes[0] = "Heals one ally for 40hp";
		skillDes[1] = "Deals 200% M.dmg to one enemy";
		skillDes[2] = "+25% mana to all allies";
		skillDes[3] = "Heal all allies for 2.5*Int";
		skillDes[4] = "Magician: +20 Int";
		skillDes[5] = "Deal 250% M.dmg to all enemies";
		skillType[0] = true;
		skillType[1] = true;
		skillType[2] = false;
		skillType[3] = true;
		skillType[4] = false;
		skillType[5] = true;
		// Targets: 1 = enemy, 2 = ally, 3 = all enemy, 4 = all ally, 5 = self, 0 = passive
		skillTarget[0] = 2;
		skillTarget[1] = 1;
		skillTarget[2] = 4;
		skillTarget[3] = 3;
		skillID[0] = 0;
		skillID[1] = 41;
		skillID[2] =42;
		skillID[3] = 43;
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
