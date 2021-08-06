package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Spells {
    private String name;
    private String name1;
    private String name2;
    private String name3;
    /*private String description;
    private String tooltip;*/

    public String getName0(){
        return name;
    }
    public void setName0(String name){
        this.name = name;
    }
    public String getName1(){
        return name1;
    }
    public void setName1(String name1){
        this.name1 = name1;
    }
    public String getName2(){
        return name2;
    }
    public void setName2(String name2){
        this.name2 = name2;
    }
    public String getName3(){
        return name3;
    }
    public void setName3(String name3){
        this.name3 = name3;
    }

    public static void getChampSpell(Spells spells, String name){
        try{
            JsonNode node = (new ObjectMapper()).readTree(Api.getChampionData(name));

                spells.setName0(node.get("data").get(name).get("spells").get(0).get("name").asText());
                spells.setName1(node.get("data").get(name).get("spells").get(1).get("name").asText());
                spells.setName2(node.get("data").get(name).get("spells").get(2).get("name").asText());
                spells.setName3(node.get("data").get(name).get("spells").get(3).get("name").asText());
           
            }catch(JsonProcessingException e){
                e.printStackTrace();
              }
    
    }
}

