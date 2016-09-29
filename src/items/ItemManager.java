package items;

public class ItemManager { // this class returns the appropriate function

	private PrinceItems princeItems;
	private KnightItems knightItems;
	private RangerItems rangerItems;
	private MagicianItems magicianItems;
	private PirateItems pirateItems;
	private NinjaItems	ninjaItems;
	
	public ItemManager (){
		princeItems = new PrinceItems();
		knightItems = new KnightItems();
		rangerItems = new RangerItems();
		magicianItems = new MagicianItems();
		pirateItems = new PirateItems();
		ninjaItems = new NinjaItems();
		
	}
	
	public String getItemName(int job, int itemType, int itemNum){
		if (job == 1){
			if (itemType == 1){
				princeItems.setMySword(itemNum);
				return princeItems.getSwordName();
			}
			else if (itemType == 2){
				princeItems.setMyShield(itemNum);
				return princeItems.getShieldName();
			}
			else if (itemType == 3){
				princeItems.setMyArmour(itemNum);
				return princeItems.getArmourName();
			}
		}
		else if (job == 2){
			if (itemType == 1){
				rangerItems.setMyBow(itemNum);
				return rangerItems.getBowName();
			}			
			else if (itemType == 2){
				rangerItems.setMyQuiver(itemNum);
				return rangerItems.getQuiverName();
			}
			else if (itemType == 3){
				rangerItems.setMyArmour(itemNum);
				return rangerItems.getArmourName();
			}
		}
		else if (job == 3){
			if (itemType == 1){
				knightItems.setMySpear(itemNum);
				return knightItems.getSpearName();
			}
			else if (itemType == 2){
				knightItems.setMyShield(itemNum);
				return knightItems.getShieldName();
			}
			else if (itemType == 3){
				knightItems.setMyArmour(itemNum);
				return knightItems.getArmourName();
			}
		}
		else if (job == 4){
			if (itemType == 1){
				magicianItems.setMyStaff(itemNum);
				return magicianItems.getStaffName();
			}
			else if (itemType == 2){
				magicianItems.setMyMagicEssence(itemNum);
				return magicianItems.getMagicEssenceName();
			}
			else if (itemType == 3){
				magicianItems.setMyArmour(itemNum);
				return magicianItems.getArmourName();
			}
		}
		else if (job == 5){
			if (itemType == 1){
				pirateItems.setMyAxe(itemNum);
				return pirateItems.getAxeName();
			}
			else if (itemType == 2){
				pirateItems.setMyThrowingAxe(itemNum);
				return pirateItems.getThrowingAxeName();
			}
			else if (itemType == 3){
				pirateItems.setMyArmour(itemNum);
				return pirateItems.getArmourName();
			}
		}
		else{
			if (itemType == 1){
				ninjaItems.setMyShuriken(itemNum);
				return ninjaItems.getShurikenName();
			}
			else if (itemType == 2){
				ninjaItems.setMyCloak(itemNum);
				return ninjaItems.getCloakName();
			}
			else if (itemType == 3){
				ninjaItems.setMyArmour(itemNum);
				return ninjaItems.getArmourName();
			}
		}
		return null;
	}
	
	public String getItemDes(int job, int itemType, int itemNum){
		if (job == 1){
			if (itemType == 1){
				princeItems.setMySword(itemNum);
				return princeItems.getSwordDes();
			}
			else if (itemType == 2){
				princeItems.setMyShield(itemNum);
				return princeItems.getShieldDes();
			}
			else if (itemType == 3){
				princeItems.setMyArmour(itemNum);
				return princeItems.getArmourDes();
			}
		}
		else if (job == 2){
			if (itemType == 1){
				rangerItems.setMyBow(itemNum);
				return rangerItems.getBowDes();
			}			
			else if (itemType == 2){
				rangerItems.setMyQuiver(itemNum);
				return rangerItems.getQuiverDes();
			}
			else if (itemType == 3){
				rangerItems.setMyArmour(itemNum);
				return rangerItems.getArmourDes();
			}
		}
		else if (job == 3){
			if (itemType == 1){
				knightItems.setMySpear(itemNum);
				return knightItems.getSpearDes();
			}
			else if (itemType == 2){
				knightItems.setMyShield(itemNum);
				return knightItems.getShieldDes();
			}
			else if (itemType == 3){
				knightItems.setMyArmour(itemNum);
				return knightItems.getArmourDes();
			}
		}
		else if (job == 4){
			if (itemType == 1){
				magicianItems.setMyStaff(itemNum);
				return magicianItems.getStaffDes();
			}
			else if (itemType == 2){
				magicianItems.setMyMagicEssence(itemNum);
				return magicianItems.getMagicEssenceDes();
			}
			else if (itemType == 3){
				magicianItems.setMyArmour(itemNum);
				return magicianItems.getArmourDes();
			}
		}
		else if (job == 5){
			if (itemType == 1){
				pirateItems.setMyAxe(itemNum);
				return pirateItems.getAxeDes();
			}
			else if (itemType == 2){
				pirateItems.setMyThrowingAxe(itemNum);
				return pirateItems.getThrowingAxeDes();
			}
			else if (itemType == 3){
				pirateItems.setMyArmour(itemNum);
				return pirateItems.getArmourDes();
			}
		}
		else{
			if (itemType == 1){
				ninjaItems.setMyShuriken(itemNum);
				return ninjaItems.getShurikenDes();
			}
			else if (itemType == 2){
				ninjaItems.setMyCloak(itemNum);
				return ninjaItems.getCloakDes();
			}
			else if (itemType == 3){
				ninjaItems.setMyArmour(itemNum);
				return ninjaItems.getArmourDes();
			}
		}
		return null;
	}
}
