package skills;

public class SkillManager { // this class returns the appropriate function

	private PrinceSkills princeSkills;
	private KnightSkills knightSkills;
	private RangerSkills rangerSkills;
	private MagicianSkills magicianSkills;
	private PirateSkills pirateSkills;
	private NinjaSkills	ninjaSkills;
	
	public SkillManager (){
		princeSkills = new PrinceSkills();
		knightSkills = new KnightSkills();
		rangerSkills = new RangerSkills();
		magicianSkills = new MagicianSkills();
		pirateSkills = new PirateSkills();
		ninjaSkills = new NinjaSkills();
		
	}
	
	public String getSkillName(int job, int skillNum){
		if (job == 1){
			return princeSkills.getSkillName(skillNum);
		}
		else if (job == 2){
			return rangerSkills.getSkillName(skillNum);
		}
		else if (job == 3){
			return knightSkills.getSkillName(skillNum);
		}
		else if (job == 4){
			return magicianSkills.getSkillName(skillNum);
		}
		else if (job == 5){
			return pirateSkills.getSkillName(skillNum);
		}
		else if (job == 6){
			return ninjaSkills.getSkillName(skillNum);
		}
		return rangerSkills.getSkillName(skillNum);
	}
	
	public String getSkillDes(int job, int skillNum){
		if (job == 1){
			return princeSkills.getSkillDes(skillNum);
		}
		else if (job == 2){
			return rangerSkills.getSkillDes(skillNum);
		}
		else if (job == 3){
			return knightSkills.getSkillDes(skillNum);
		}
		else if (job == 4){
			return magicianSkills.getSkillDes(skillNum);
		}
		else if (job == 5){
			return pirateSkills.getSkillDes(skillNum);
		}
		else if (job == 6){
			return ninjaSkills.getSkillDes(skillNum);
		}
		return null;
	}
	
	public boolean getSkillType(int job, int skillNum){
		if (job == 1){
			return princeSkills.getSkillType(skillNum);
		}
		else if (job == 2){
			return rangerSkills.getSkillType(skillNum);
		}
		else if (job == 3){
			return knightSkills.getSkillType(skillNum);
		}
		else if (job == 4){
			return magicianSkills.getSkillType(skillNum);
		}
		else if (job == 5){
			return pirateSkills.getSkillType(skillNum);
		}
		else if (job == 6){
			return ninjaSkills.getSkillType(skillNum);
		}
		return false;
	}
	
	public String getSkillTypeStr(int job, int skillNum){
		if (job == 1){
			return princeSkills.getSkillTypeStr(skillNum);
		}
		else if (job == 2){
			return rangerSkills.getSkillTypeStr(skillNum);
		}
		else if (job == 3){
			return knightSkills.getSkillTypeStr(skillNum);
		}
		else if (job == 4){
			return magicianSkills.getSkillTypeStr(skillNum);
		}
		else if (job == 5){
			return pirateSkills.getSkillTypeStr(skillNum);
		}
		else if (job == 6){
			return ninjaSkills.getSkillTypeStr(skillNum);
		}
		return null;
	}
	
	public int getSkillTarget(int job, int skillNum){
		if (job == 1){
			return princeSkills.getSkillTarget(skillNum);
		}
		else if (job == 2){
			return rangerSkills.getSkillTarget(skillNum);
		}
		else if (job == 3){
			return knightSkills.getSkillTarget(skillNum);
		}
		else if (job == 4){
			return magicianSkills.getSkillTarget(skillNum);
		}
		else if (job == 5){
			return pirateSkills.getSkillTarget(skillNum);
		}
		else if (job == 6){
			return ninjaSkills.getSkillTarget(skillNum);
		}
		return 0;
	}
	public int getSkillID(int job, int skillNum){
		if (job == 1){
			return princeSkills.getSkillID(skillNum);
		}
		else if (job == 2){
			return rangerSkills.getSkillID(skillNum);
		}
		else if (job == 3){
			return knightSkills.getSkillID(skillNum);
		}
		else if (job == 4){
			return magicianSkills.getSkillID(skillNum);
		}
		else if (job == 5){
			return pirateSkills.getSkillID(skillNum);
		}
		else if (job == 6){
			return ninjaSkills.getSkillID(skillNum);
		}
		return 0;
	}
}
