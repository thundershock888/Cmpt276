package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Stats{
	private double mpregen;
	private double attackdamageperlevel;
	private int mp;
	private int attackrange;
	private int hpperlevel;
	private int hp;
	private double hpregen;
	private double mpregenperlevel;
	private int spellblock;
	private int critperlevel;
	private int movespeed;
	private int mpperlevel;
	private int armor;
	private int armorperlevel;
	private int crit;
	private int attackdamage;
	private double attackspeed;
	private double spellblockperlevel;
	private double attackspeedperlevel;
	private double hpregenperlevel;

	public double getMpregen(){
		return mpregen;
	}
	public void setMpregen(double mpregen){
		this.mpregen = mpregen;
	}
	
	public double getAttackdamageperlevel(){
		return attackdamageperlevel;
	}
	public void setAttackdamageperlevel(double attackdamageperlevel){
		this.attackdamageperlevel = attackdamageperlevel;
	}

	public int getMp(){
		return mp;
	}
	public void setMp(int mp){
		this.mp = mp;
	}

	public int getAttackrange(){
		return attackrange;
	}
	public void setAttackrange(int attackrange){
		this.attackrange = attackrange;
	}

	public int getHpperlevel(){
		return hpperlevel;
	}
	public void setHpperlevel(int hpperlevel){
		this.hpperlevel = hpperlevel;
	}
	public int getHp(){
		return hp;
	}
	public void setHp(int hp){
		this.hp = hp;
	}
	public double getHpregen(){
		return hpregen;
	}
	public void setHpregen(double hpregen){
		this.hpregen = hpregen;
	}

	public double getMpregenperlevel(){
		return mpregenperlevel;
	}
	public void setMpregenperlevel(double mpregenperlevel){
		this.mpregenperlevel = mpregenperlevel;
	}
	public int getSpellblock(){
		return spellblock;
	}
	public void setSpellblock(int spellblock){
		this.spellblock = spellblock;
	}
	public int getCritperlevel(){
		return critperlevel;
	}
	public void setCritperlevel(int critperlevel){
		this.critperlevel = critperlevel;
	}

	public int getMovespeed(){
		return movespeed;
	}
	public void setMovespeed(int movespeed){
		this.movespeed = movespeed;
	}
	public int getMpperlevel(){
		return mpperlevel;
	}
	public void setMpperlevel(int mpperlevel){
		this.mpperlevel = mpperlevel;
	}
	public int getArmor(){
		return armor;
	}
	public void setArmor(int armor){
		this.armor = armor;
	}
	public int getArmorperlevel(){
		return armorperlevel;
	}
	public void setArmorperlevel(int armorperlevel){
		this.armorperlevel = armorperlevel;
	}
	public int getCrit(){
		return crit;
	}
	public void setCrit(int crit){
		this.crit = crit;
	}

	public int getAttackdamage(){
		return attackdamage;
	}
	public void setAttackdamage(int attackdamage){
		this.attackdamage = attackdamage;
	}

	public double getAttackspeed(){
		return attackspeed;
	}
	public void setAttackspeed(double attackspeed){
		this.attackspeed = attackspeed;
	}

	public double getSpellblockperlevel(){
		return spellblockperlevel;
	}
	public void setSpellblockperlevel(double spellblockperlevel){
		this.spellblockperlevel = spellblockperlevel;
	}
	public double getAttackspeedperlevel(){
		return attackspeedperlevel;
	}
	public void setAttackspeedperlevel(double attackspeedperlevel){
		this.attackspeedperlevel = attackspeedperlevel;
	}
	public double getHpregenperlevel(){
		return hpregenperlevel;
	}
	public void setHpregenperlevel(double hpregenperlevel){
		this.hpregenperlevel = hpregenperlevel;
	}

	public static void getChampionStats(Stats stats, String name){
		try{
		  JsonNode node = (new ObjectMapper()).readTree(Api.getChampionData(name));

		  stats.setMpregen(node.get("data").get(name).get("stats").get("mpregen").asDouble());
		  stats.setAttackdamageperlevel(node.get("data").get(name).get("stats").get("attackdamageperlevel").asDouble());
		  stats.setMp(node.get("data").get(name).get("stats").get("mp").asInt());
		  stats.setAttackrange(node.get("data").get(name).get("stats").get("attackrange").asInt());
		  stats.setHp(node.get("data").get(name).get("stats").get("hp").asInt());
		  stats.setHpperlevel(node.get("data").get(name).get("stats").get("hpperlevel").asInt());
		  stats.setHpregen(node.get("data").get(name).get("stats").get("hpregen").asDouble());
		  stats.setMpregenperlevel(node.get("data").get(name).get("stats").get("mpregenperlevel").asDouble());
		  stats.setSpellblock(node.get("data").get(name).get("stats").get("spellblock").asInt());
		  stats.setCritperlevel(node.get("data").get(name).get("stats").get("critperlevel").asInt());
		  stats.setMovespeed(node.get("data").get(name).get("stats").get("movespeed").asInt());
		  stats.setMpperlevel(node.get("data").get(name).get("stats").get("mpperlevel").asInt());
		  stats.setArmor(node.get("data").get(name).get("stats").get("armor").asInt());
		  stats.setArmorperlevel(node.get("data").get(name).get("stats").get("armorperlevel").asInt());
		  stats.setCrit(node.get("data").get(name).get("stats").get("crit").asInt());
		  stats.setAttackdamage(node.get("data").get(name).get("stats").get("attackdamage").asInt());
		  stats.setAttackspeed(node.get("data").get(name).get("stats").get("attackspeed").asDouble());
		  stats.setSpellblockperlevel(node.get("data").get(name).get("stats").get("spellblockperlevel").asDouble());
		  stats.setAttackspeedperlevel(node.get("data").get(name).get("stats").get("attackspeedperlevel").asDouble());
		  stats.setHpregenperlevel(node.get("data").get(name).get("stats").get("hpregenperlevel").asDouble());

		}catch(JsonProcessingException e){
		  e.printStackTrace();
		}
	}
}
