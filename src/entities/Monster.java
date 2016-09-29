package entities;

import java.awt.image.BufferedImage;



public class Monster {
	private String monster_name;
	private int monster_str,monster_dex,monster_int,monster_vit;
	private int monster_hp, monster_mp, monster_currHp, monster_currMp;
	private int monster_patk;
	private int monster_pdef;
	private int monster_matk;
	private int monster_mdef;
	private int monster_crit;
	private int monster_avoid;
	private double attack_delay;
	private int monster_exp;
	private BufferedImage[] monster_anim;
	private int width = 32;
	private int height = 32;
	
	public Monster (int str,int dex,int intel,int vit,int exp, BufferedImage anim, String name){
		monster_anim = new BufferedImage[4];
		monster_anim[0] = anim.getSubimage(0, 0, width, height);
		monster_anim[1] = anim.getSubimage(width,0,width,height);
		monster_anim[2] = anim.getSubimage(width*2,0,width,height);
		monster_anim[3] = anim.getSubimage(width,0,width,height);
		monster_name = name;
		monster_str = str;
		monster_dex = dex;
		monster_int = intel;
		monster_vit = vit;
		monster_hp = setHP(monster_vit);
		monster_mp = setMP(monster_int);
		monster_currHp = monster_hp;
		monster_currMp = monster_mp;
		monster_patk = setPatk(monster_str, monster_dex);
		monster_pdef = setPdef(monster_vit, monster_str);
		monster_matk = setMatk(monster_int);
		monster_mdef = setMdef(monster_int);
		monster_crit = setCrit(monster_str, monster_dex);
		monster_avoid= setAvoid(monster_dex);
		attack_delay = setDelay(monster_dex);
		monster_exp = exp;
	}
	
	
	private int setHP(int vit){
		return 30+5*vit;
	}
	private int setMP(int intel){
		return (int) (10+1.5*intel);
	}
	private int setPatk(int str, int dex){
		return (int) (10+str);
	}
	private int setPdef(int vit, int str){
		return vit;
	}
	private int setMatk(int intel){
		return (int) (10+intel);
	}
	private int setMdef(int intel){
		return intel;
	}
	private int setCrit(int str, int dex){
		return (int) (str*0.2 + dex*0.4);
	}
	private int setAvoid(int dex){
		return (int) (dex*0.5);
	}
	private double setDelay(int dex){
		return 15.0 - (1.3*dex)/50;
	}


	public int getMonster_str() {
		return monster_str;
	}


	public void setMonster_str(int monster_str) {
		this.monster_str = monster_str;
	}


	public int getMonster_dex() {
		return monster_dex;
	}


	public void setMonster_dex(int monster_dex) {
		this.monster_dex = monster_dex;
	}


	public int getMonster_int() {
		return monster_int;
	}


	public void setMonster_int(int monster_int) {
		this.monster_int = monster_int;
	}


	public int getMonster_vit() {
		return monster_vit;
	}


	public void setMonster_vit(int monster_vit) {
		this.monster_vit = monster_vit;
	}


	public int getMonster_hp() {
		return monster_hp;
	}


	public void setMonster_hp(int monster_hp) {
		this.monster_hp = monster_hp;
	}


	public int getMonster_mp() {
		return monster_mp;
	}


	public void setMonster_mp(int monster_mp) {
		this.monster_mp = monster_mp;
	}


	public int getMonster_currHp() {
		return monster_currHp;
	}


	public void setMonster_currHp(int monster_currHp) {
		this.monster_currHp = Math.max(0, monster_currHp);
	}


	public int getMonster_currMp() {
		return monster_currMp;
	}


	public void setMonster_currMp(int monster_currMp) {
		this.monster_currMp = monster_currMp;
	}


	public int getMonster_patk() {
		return monster_patk;
	}


	public void setMonster_patk(int monster_patk) {
		this.monster_patk = monster_patk;
	}


	public int getMonster_pdef() {
		return monster_pdef;
	}


	public void setMonster_pdef(int monster_pdef) {
		this.monster_pdef = monster_pdef;
	}


	public int getMonster_matk() {
		return monster_matk;
	}


	public void setMonster_matk(int monster_matk) {
		this.monster_matk = monster_matk;
	}


	public int getMonster_mdef() {
		return monster_mdef;
	}


	public void setMonster_mdef(int monster_mdef) {
		this.monster_mdef = monster_mdef;
	}


	public int getMonster_crit() {
		return monster_crit;
	}


	public void setMonster_crit(int monster_crit) {
		this.monster_crit = monster_crit;
	}


	public int getMonster_avoid() {
		return monster_avoid;
	}


	public void setMonster_avoid(int monster_avoid) {
		this.monster_avoid = monster_avoid;
	}


	public double getAttack_delay() {
		return attack_delay;
	}


	public void setAttack_delay(double attack_delay) {
		this.attack_delay = attack_delay;
	}


	public BufferedImage[] getMonster_anim() {
		return monster_anim;
	}


	public void setMonster_anim(BufferedImage[] monster_anim) {
		this.monster_anim = monster_anim;
	}


	public String getMonster_name() {
		return monster_name;
	}


	public void setMonster_name(String monster_name) {
		this.monster_name = monster_name;
	}

	public int getMonster_exp() {
		return monster_exp;
	}


	public void setMonster_exp(int monster_exp) {
		this.monster_exp = monster_exp;
	}
	
}
