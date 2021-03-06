package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ChampionRead{
	private String id;
	private String key;
    private String title;
	private String lore;
	private String name;
	private Integer attack;
	private Integer defense;
	private Integer magic;
	private Integer difficulty;
	private String partype;
	private String image;
	private String tags;
	private String tags1;
	private String passive;
	private String passiveimg;
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getKey(){
		return key;
	}
	public void setKey(String key){
		this.key = key;
	}

	public String getTitle(){
		return title;
	}

    public void setTitle(String title){
		this.title = title;
	}
	public String getLore(){
		return lore;
	}
	public void setLore(String lore){
		this.lore = lore;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public Integer getInfoAttack(){
		return attack;
	}
	public void setInfoAttack(Integer attack){
		this.attack = attack;
	}
	public Integer getInfoDefense(){
		return defense;
	}
	public void setInfoDefense(Integer defense){
		this.defense = defense;
	}
	public Integer getInfoMagic(){
		return magic;
	}
	public void setInfoMagic(Integer magic){
		this.magic = magic;
	}
	public Integer getInfoDifficulty(){
		return difficulty;
	}
	public void setInfoDifficulty(Integer difficulty){
		this.difficulty = difficulty;
	}
	public String getPartype(){
		return partype;
	}
	public void setPartype(String partype){
		this.partype = partype;
	}
	
	public String getImage(){
		return image;
	}
	public void setImage(String image){
		this.image= image;
	}
	public String getTags(){
		return tags;
	}
	public void setTags(String tags){
		this.tags = tags;
	}
	public String getTags1(){
		return tags1;
	}
	public void setTags1(String tags1){
		this.tags1 = tags1;
	}
	public String getPassive(){
		return passive;
	}
	public void setPassive(String passive){
		this.passive = passive;
	}
	public String getPassiveImg(){
		return passiveimg;
	}
	public void setPassiveImg(String passiveimg){
		this.passiveimg = passiveimg;
	}

	public static void getChampion(ChampionRead championRead, String name){
		try{
		  JsonNode node = (new ObjectMapper()).readTree(Api.getChampionData(name));
		  
		  //System.out.println("champion: "+ node);

		  championRead.setId(node.get("data").get(name).get("id").asText());
		  championRead.setKey(node.get("data").get(name).get("key").asText());
		  championRead.setTitle(node.get("data").get(name).get("title").asText());
		  championRead.setName(node.get("data").get(name).get("name").asText());
		  championRead.setLore(node.get("data").get(name).get("lore").asText());
		  championRead.setInfoAttack(node.get("data").get(name).get("info").get("attack").asInt());
		  championRead.setInfoDefense(node.get("data").get(name).get("info").get("defense").asInt());
		  championRead.setInfoMagic(node.get("data").get(name).get("info").get("magic").asInt());
		  championRead.setInfoDifficulty(node.get("data").get(name).get("info").get("difficulty").asInt());
		  championRead.setPartype(node.get("data").get(name).get("partype").asText());
		  championRead.setImage(node.get("data").get(name).get("image").get("full").asText());
		  championRead.setTags(node.get("data").get(name).get("tags").get(0).asText());
		  championRead.setTags1(node.get("data").get(name).get("tags").get(1).asText());
		  championRead.setPassive(node.get("data").get(name).get("passive").get("name").asText());
		  championRead.setPassiveImg(node.get("data").get(name).get("passive").get("image").get("full").asText());
		}catch(JsonProcessingException e){
		  e.printStackTrace();
		}
}
}
