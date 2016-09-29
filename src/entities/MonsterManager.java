package entities;

public class MonsterManager {
	private int tileID;
	public MonsterManager(int _TileID){
		this.tileID = _TileID;
	}
	
	public Monster getMonster(){
		double rolldice = Math.random();
		if (tileID == 11){
			if (rolldice < 0.6)
				return new Theif_A();
			else
				return new Theif_B();
		}
		if (tileID == 21){
			if (rolldice < 0.6)
				return new Orc();
			else
				return new AmazonWarrior();
		}
		if (tileID == 31){
			if (rolldice < 0.6)
				return new DesertBat();
			else
				return new DesertWanderer();
		}
		if (tileID == 41 || tileID == 42){
			if (rolldice < 0.6)
				return new Skeleton();
			else
				return new WaterDjinn();
		}
		if (tileID == 51){
			if (rolldice < 0.6)
				return new FrostGiant();
			else
				return new FrostShade();
		}
		return new Xena();
	}
	
	public Monster getBoss (int bossNum, int enemyNum){
		if (bossNum == 5){
			if (enemyNum == 0)
				return new FrostGiant();
			else if (enemyNum == 1)
				return new Ymir();
			else if (enemyNum == 2)
				return new FrostShade();
		}
		else if (bossNum == 2){
			if (enemyNum == 0)
				return new Orc();
			else if (enemyNum == 1)
				return new Xena();
			else if (enemyNum == 2)
				return new AmazonWarrior();
		}
		else if (bossNum == 3){
			if (enemyNum == 0)
				return new DesertBat();
			else if (enemyNum == 1)
				return new Camaxtli();
			else if (enemyNum == 2)
				return new DesertWanderer();
		}
		else if (bossNum == 4){
			if (enemyNum == 0)
				return new Skeleton();
			else if (enemyNum == 1)
				return new Tefnut();
			else if (enemyNum == 2)
				return new WaterDjinn();
		}
		else{
			if (enemyNum == 0)
				return new Theif_A();
			else if (enemyNum == 1)
				return new King();
			else
				return new Theif_B();
		}
		return null;
	}
}
