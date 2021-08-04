package com.example;

import java.util.List;

import champs.Image;
import champs.Stats;

public class ChampionRead{
	private String id;
	private String key;
    private String title;
	private String blurb;
	private String name;
	private Integer attack;
	private Integer defense;
	private Integer magic;
	private Integer difficulty;
	private String partype;
	
/*
	private Image image;
	private Stats stats;	
	private List<String> tags;*/
	
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
	public String getBlurb(){
		return blurb;
	}
	public void setBlurb(String blurb){
		this.blurb = blurb;
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
/*
	public Image getImage(){
		return image;
	}
	public void setImage(Image image){
		this.image = image;
	}*/
/*
	public Stats getStats(){
		return stats;
	}



	public List<String> getTags(){
		return tags;
	}
*/

}