package skills;

public class KnightSkills {
	private String[] skillName = new String[6];
	private String[] skillDes = new String[6];
	private Boolean[] skillType = new Boolean[6];
	private Integer[] skillTarget = new Integer[6];
	private Integer[] skillID = new Integer[6];
	
	public KnightSkills(){
		skillName[0] = "First Aid";
		skillName[1] = "Protect";
		skillName[2] = "Soldier's Valour";
		skillName[3] = "Shield Charge";
		skillName[4] = "StrongHold";
		skillName[5] = "Berserk";
		skillDes[0] = "Heals one ally for 40hp";
		skillDes[1] = "Takes dmg for allies, +50% Def";
		skillDes[2] = "+20% Vit to all allies";
		skillDes[3] = "Deal Atk+Def to all enemies";
		skillDes[4] = "Knight: +20 Vit";
		skillDes[5] = "Deals Atk+3*Def to one enemy";
		skillType[0] = true;
		skillType[1] = true;
		skillType[2] = false;
		skillType[3] = true;
		skillType[4] = false;
		skillType[5] = true;
		// Targets: 1 = enemy, 2 = ally, 3 = all enemy, 4 = all ally, 5 = self, 0 = passive
		skillTarget[0] = 2;
		skillTarget[1] = 35;
		skillTarget[2] = 3;
		skillTarget[3] = 1;
		skillID[0] = 0;
		skillID[1] = 31;
		skillID[2] =32;
		skillID[3] = 33;
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
