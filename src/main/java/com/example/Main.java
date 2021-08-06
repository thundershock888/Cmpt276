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
      
  @RequestMapping("/search")
  String search() {
    return "search";
  }
  @GetMapping("/champ")
  public String ChampDisp(Map<String,Object> model, @RequestParam String name){
    System.out.println(name);
    if (name == null){
      return "error";
    }
    name = name.substring(0,1).toUpperCase()+name.substring(1);
      
    ChampionRead championRead = new ChampionRead();
    ChampionRead.getChampion(championRead, name);
    Stats stats = new Stats();
    Stats.getChampionStats(stats, name);
    System.out.println("champ id :"+ championRead.getId());
    System.out.println("champ key:"+ championRead.getKey());
    System.out.println("champ title :"+ championRead.getTitle());
    System.out.println("Champ name :" + championRead.getName());
    System.out.println("champ blurb :"+ championRead.getBlurb());
    System.out.println("champ attack :"+ championRead.getInfoAttack()+" magic: "+ championRead.getInfoMagic()+" defense: " 
          +championRead.getInfoDefense()+" difficulty:"+ championRead.getInfoDifficulty());
    System.out.println("champ partype: "+championRead.getPartype());
    

    model.put("names", championRead.getName());
    model.put("titles", championRead.getTitle());
    model.put("blurbs", championRead.getBlurb());
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


    return "champion";
    
  }



  @GetMapping("/somethin")
  public String searching (Map<String, Object> model, @RequestParam String name) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:mm", Locale.US);
    GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("US/West"));
    System.out.println(name);
    if (name == null){
      return "error";
    }
    Summoner summoner = new Summoner();
    Helper.getSummoner(summoner, name);

    Ranked ranked = new Ranked();
    Helper.getRanked(ranked, summoner.getId());

    MatchList matchList = new MatchList();
    Helper.getSummonerMatch(matchList, summoner.getAccountId());
    
    System.out.println("Name: "+ summoner.getName());
    System.out.println("Level: "+ summoner.getSummonerLevel());
    System.out.println("player rank: "+ ranked.getTier()+ " "+ ranked.getRank()+ " LP: "+ ranked.getLeaguePoints());
    System.out.println("Wins: "+ ranked.getWins());
    System.out.println("Losses: "+ ranked.getLosses());
    System.out.println("Winstreak? "+ranked.isHotStreak());
    System.out.println("New player? "+ ranked.isFreshBlood());
    System.out.println("Veteran player? "+ ranked.isVeteran());
    System.out.println("Inactive player? "+ ranked.isInactive());
    
    float win = ranked.getWins();
    float loss = ranked.getLosses();
    float winR = win/(win+loss)*100;
    System.out.println("RATIO "+ winR);
    
    model.put("names", summoner.getName());
    model.put("levels", summoner.getSummonerLevel());
    model.put("tiers", ranked.getTier());
    model.put("ranks",ranked.getRank());
    model.put("lps", ranked.getLeaguePoints());
    model.put("wins", ranked.getWins());
    model.put("losses", ranked.getLosses());
    model.put("winstreak",ranked.isHotStreak());
    model.put("news", ranked.isFreshBlood());
    model.put("veterans", ranked.isVeteran());
    model.put("inactives", ranked.isInactive());
    model.put("pfps", summoner.getProfileIconId());
    model.put("winratio", winR);

    for (int i=0; i<6; i++){
      model.put("platformId"+(i), matchList.getMatch(i).getPlatformId());
      model.put("gameId"+(i), matchList.getMatch(i).getGameId());
      model.put("champion"+(i),matchList.getMatch(i).getChampionName());
      model.put("queue"+(i),matchList.getMatch(i).getMatchType());
      model.put("season"+(i),matchList.getMatch(i).getSeason());

      calendar.setTimeInMillis(matchList.getMatch(i).getTimestamp());
      model.put("timestamp"+(i),sdf.format(calendar.getTime()));
      model.put("role"+(i),"role"+(i));
      model.put("lane"+(i),matchList.getMatch(i).getLane());
    }
    return "main";
  }
  
	
  public static void main(String[] args) throws Exception {


    SpringApplication.run(Main.class, args);
    String pid = "Delicious";
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
    System.out.println("champ id :"+ championRead.getId());
    System.out.println("champ key:"+ championRead.getKey());
    System.out.println("champ title :"+ championRead.getTitle());
    System.out.println("Champ name :" + championRead.getName());
    System.out.println("champ blurb :"+ championRead.getBlurb());
    System.out.println("champ attack :"+ championRead.getInfoAttack()+" magic: "+ championRead.getInfoMagic()+" defense: " 
          +championRead.getInfoDefense()+" difficulty:"+ championRead.getInfoDifficulty());
    System.out.println("champ partype: "+championRead.getPartype());
    System.out.println("champ image: "+championRead.getImage());
    System.out.println("champ tag: "+championRead.getTags());
    System.out.println("champ stats: "+stats.getMpregen());
    System.out.println("champ damageperlevel: "+stats.getAttackdamageperlevel());

  }


  @RequestMapping("/db")
  String db(Map<String, Object> model) {
    try (Connection connection = dataSource.getConnection()) {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
      stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
      ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

      ArrayList<String> output = new ArrayList<String>();
      while (rs.next()) {
        output.add("Read from DB: " + rs.getTimestamp("tick"));
      }

      model.put("records", output);
      return "db";
    } catch (Exception e) {
      model.put("message", e.getMessage());
      return "error";
    }
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
