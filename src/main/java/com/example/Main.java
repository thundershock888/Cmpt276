/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import match.MatchList;
import match.UserMatchData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@SpringBootApplication
public class Main {

  @Value("${spring.datasource.url}")
  private String dbUrl;

  @Autowired
  private DataSource dataSource;

  @GetMapping(
    path = "/"
  )
  String intro(){
    return "main";
  }

  //Summoner Match retrival

  @RequestMapping("/")
  String index() {
    return "main";
  }
      
  @GetMapping("/champ")
  public String ChampDisp(Map<String,Object> model, @RequestParam String name){
    System.out.println(name);
    
    name = name.substring(0,1).toUpperCase()+name.substring(1);
      
    ChampionRead championRead = new ChampionRead();
    ChampionRead.getChampion(championRead, name);
    Stats stats = new Stats();
    Stats.getChampionStats(stats, name);
    Spells spells = new Spells();
    Spells.getChampSpell(spells, name);
    
    model.put("names", championRead.getName());
    model.put("titles", championRead.getTitle());
    model.put("lores", championRead.getLore());
    model.put("attacks",championRead.getInfoAttack());
    model.put("magics", championRead.getInfoMagic());
    model.put("defenses", championRead.getInfoDefense());
    model.put("difficultys",championRead.getInfoDifficulty());
    model.put("partypes", championRead.getPartype());
    model.put("image", championRead.getImage());
    model.put("tag",championRead.getTags());
    model.put("tag1",championRead.getTags1());
    model.put("mpregens",stats.getMpregen());
    model.put("attackdamageperlevels",stats.getAttackdamageperlevel());
    model.put("mp",stats.getMp());
    model.put("attackranges",stats.getAttackrange());
    model.put("hps",stats.getHp());
    model.put("hpperlevels",stats.getHpperlevel());
    model.put("hpregens",stats.getHpregen());
    model.put("mpregenperlevels",stats.getMpregenperlevel());
    model.put("spellblocks",stats.getSpellblock());
    model.put("critperlevels",stats.getCritperlevel());
    model.put("movespeeds", stats.getMovespeed());
    model.put("mpperlevels", stats.getMpperlevel());
    model.put("armors", stats.getArmor());
    model.put("armorperlevels", stats.getArmorperlevel());
    model.put("crits", stats.getCrit());
    model.put("attackdamages", stats.getAttackdamage());
    model.put("attackspeeds", stats.getAttackspeed());
    model.put("spellblockperlevels", stats.getSpellblockperlevel());
    model.put("attackspeedperlevels", stats.getAttackspeedperlevel());
    model.put("hpregenperlevels", stats.getHpregenperlevel());
    model.put("spells0", spells.getName0());
    model.put("spells1", spells.getName1());
    model.put("spells2", spells.getName2());
    model.put("spells3", spells.getName3());
    model.put("passives", championRead.getPassive());
    model.put("passimg", championRead.getPassiveImg());
    if (championRead.getName() == null){
      return "error";
    }
    return "champion";

  }

  public static void main(String[] args) throws Exception {
    //testing output on terminal
    SpringApplication.run(Main.class, args);
  /*  String pid = "Delicious";
    Summoner summoner = new Summoner();
    Helper.getSummoner(summoner, pid);

    Ranked ranked = new Ranked();
    Helper.getRanked(ranked, summoner.getId());

    MatchList matchList = new MatchList();
    Helper.getSummonerMatch(matchList, summoner.getAccountId());

    System.out.println("Encrypted account id: "+summoner.getAccountId());
    System.out.println("Name: "+ summoner.getName());
    System.out.println("Level: "+ summoner.getSummonerLevel());
    System.out.println("player rank: "+ ranked.getTier()+ " "+ ranked.getRank()+ " LP: "+ ranked.getLeaguePoints());
    System.out.println("Wins: "+ ranked.getWins());
    System.out.println("Losses: "+ ranked.getLosses());
    System.out.println("Winstreak? "+ranked.isHotStreak());
    System.out.println("New player? "+ ranked.isFreshBlood());
    System.out.println("Veteran player? "+ ranked.isVeteran());
    System.out.println("Inactive player? "+ ranked.isInactive());
    System.out.println("Last match role: "+ matchList.getMatch(0).getRole());
    System.out.println("Last match lane: "+ matchList.getMatch(0).getLane());
    System.out.println("last match champion: "+ matchList.getMatch(0).getChampionName());
    System.out.println("match id: "+ matchList.getMatch(0).getGameId());
    System.out.println("match type: "+matchList.getMatch(0).getMatchType());

    String id ="Aatrox";
    ChampionRead championRead = new ChampionRead();
    ChampionRead.getChampion(championRead, id);
    Stats stats = new Stats();
    Stats.getChampionStats(stats, id);
    Spells spells = new Spells();
    Spells.getChampSpell(spells, id);
    System.out.println("champ id :"+ championRead.getId());
    System.out.println("champ key:"+ championRead.getKey());
    System.out.println("champ title :"+ championRead.getTitle());
    System.out.println("Champ name :" + championRead.getName());
    System.out.println("champ lore :"+ championRead.getLore());
    System.out.println("champ attack :"+ championRead.getInfoAttack()+" magic: "+ championRead.getInfoMagic()+" defense: " 
          +championRead.getInfoDefense()+" difficulty:"+ championRead.getInfoDifficulty());
    System.out.println("champ partype: "+championRead.getPartype());
    System.out.println("champ image: "+championRead.getImage());
    System.out.println("champ tag: "+championRead.getTags());
    System.out.println("champ stats: "+stats.getMpregen());
    System.out.println("champ damageperlevel: "+stats.getAttackdamageperlevel());
    System.out.println("champ passive: "+ championRead.getPassive());
    System.out.println("champ spell1: "+spells.getName0());
    System.out.println("champ spell2: "+spells.getName1());
*/
  }



  @Bean
  public DataSource dataSource() throws SQLException {
    if (dbUrl == null || dbUrl.isEmpty()) {
      return new HikariDataSource();
    } else {
      HikariConfig config = new HikariConfig();
      config.setJdbcUrl(dbUrl);
      return new HikariDataSource(config);
    }
  }

}
