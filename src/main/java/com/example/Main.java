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

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

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


  public static void getSummoner(Summoner summoner, String name){
    if(name.contains(" ")){
      String replace = name.replace(" ", "%20");
      name = replace;
        }
    try{
      JsonNode node = (new ObjectMapper()).readTree(Api.fetchDataFromApiGivenUsername(name));
      System.out.println("getSummoner: "+ node);
      
      summoner.setAccountId(node.get("accountId").asText());
      summoner.setProfileIconId(node.get("profileIconId").asInt());
      summoner.setRevisionDate(node.get("revisionDate").asLong());
      summoner.setName(node.get("name").asText());
      summoner.setId(node.get("id").asText());
      summoner.setPuuid(node.get("puuid").asText());
      summoner.setSummonerLevel(node.get("summonerLevel").asLong());
      
    }catch(JsonProcessingException e){
      e.printStackTrace();
    }
  }

  public static void getRanked(Ranked ranked, String id){
    try{
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode node = objectMapper.readTree(Api.getRankedLeagueData(id));
      System.out.println("getRanked: "+ node);
     
      ranked.setLeagueId(node.get(0).get("leagueId").asText());
      ranked.setSummonerId(node.get(0).get("summonerId").asText());
      ranked.setSummonerName(node.get(0).get("summonerName").asText());
      ranked.setQueuetype(node.get(0).get("queueType").asText());
      ranked.setTier(node.get(0).get("tier").asText());
      ranked.setRank(node.get(0).get("rank").asText());
      ranked.setLeaguePoints(node.get(0).get("leaguePoints").asInt());
      ranked.setWins(node.get(0).get("wins").asInt());
      ranked.setLosses(node.get(0).get("losses").asInt());
      ranked.setHotStreak(node.get(0).get("hotStreak").asBoolean());
      ranked.setVeteran(node.get(0).get("veteran").asBoolean());
      ranked.setFreshBlood(node.get(0).get("freshBlood").asBoolean());
      ranked.setInactive(node.get(0).get("inactive").asBoolean());


    }catch(JsonProcessingException e){
      e.printStackTrace();
    }
  }
  /*Summoner Match retrival, doesnt work yet
  public static void getSummonerMatch(Matches matches, String id){
    try{
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode node = objectMapper.readTree(Api.getMatchesBySummonerId(id));
      //System.out.println("matches: "+ node);
//doesnt work
      matches.setPlatformId(node.get("platformId").asText());
      matches.setGameId(node.get(0).get("gameId").asText());
      matches.setChampion(node.get(0).get("champion").asInt());
      matches.setQueue(node.get(0).get("queue").asInt());
      matches.setSeason(node.get(0).get("season").asInt());
      matches.setTimestamp(node.get(0).get("timestamp").asInt());
      matches.setRole(node.get(0).get("role").asText());
      matches.setLane(node.get(0).get("lane").asText());

    }catch(JsonProcessingException e){
      e.printStackTrace();
    }
  }*/


  @RequestMapping("/")
  String index() {
    return "main";
  }

  @RequestMapping("/login")
  String login() {
    return "login";
  }

  @RequestMapping("/logintest")
  String logintest() {
    return "logintest";
  }
  @RequestMapping("/logsuccess")
  String logsucc() {
    return "logsuccess";
  }

  @RequestMapping("/signup")
  String signup() {
    return "signup";
  }
  @RequestMapping("/recover")
  String recover() {
    return "recover";
  }

  @RequestMapping("/search")
  String search() {
    return "search";
  }

  @GetMapping("/summ")
  public String searching (Map<String, Object> model, @RequestParam String name) {
    System.out.println(name);
    if (name == null){
      return "error";
    }
    Summoner summoner = new Summoner();
    getSummoner(summoner, name);

    Ranked ranked = new Ranked();
    getRanked(ranked, summoner.getId()); 
    System.out.println("Name: "+ summoner.getName());
    System.out.println("Level: "+ summoner.getSummonerLevel());
    System.out.println("player rank: "+ ranked.getTier()+ " "+ ranked.getRank()+ " LP: "+ ranked.getLeaguePoints());
    System.out.println("Wins: "+ ranked.getWins());
    System.out.println("Losses: "+ ranked.getLosses());
    System.out.println("Winstreak? "+ranked.isHotStreak());
    System.out.println("New player? "+ ranked.isFreshBlood());
    System.out.println("Veteran player? "+ ranked.isVeteran());
    System.out.println("Inactive player? "+ ranked.isInactive());

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
    return "main";
  }
  public static void main(String[] args) throws Exception {
    SpringApplication.run(Main.class, args);

    String pid = "Delicious";
    Summoner summoner = new Summoner();
    getSummoner(summoner, pid);

    Ranked ranked = new Ranked();
    getRanked(ranked, summoner.getId()); 
/*
    Matches matches = new Matches();
    getSummonerMatch(matches, summoner.getAccountId());*/

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
