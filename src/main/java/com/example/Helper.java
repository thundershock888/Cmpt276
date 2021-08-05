package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import match.MatchFromIdResponse;
import match.MatchList;
import match.UserMatchData;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Helper {
    public static String fileToString(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    public static List<match.MatchesItem> getMatchListFromUserName(String username){
        Gson gson = new Gson();
        String id = Api.getSummonderPuuidByUserName(username);
        String matchlist = Api.getMatchesBySummonerId(id);
        MatchFromIdResponse response = gson.fromJson(matchlist, MatchFromIdResponse.class);
        return  response.getMatches();
    }
    public static List<Long> getMatchIdsFromUserName(String username){
        List<match.MatchesItem> listOfMatches = getMatchListFromUserName(username);
        List<Long> listOfMatchIds = new ArrayList<>(); // @todo stream
        for (match.MatchesItem item:listOfMatches
        ) {
            listOfMatchIds.add(item.getGameId());
        }
        return listOfMatchIds;
    }
    public static List<UserMatchData> getMatchResponseDataFromUserName(String username){//returns list of UserMatchData objects, given a username. (DO NOT CALL THIS TOO OFTEN, RATE LIMIT WILL BE REACHED)
        List<Long> matchIds = new ArrayList<>();
        List<UserMatchData> userMatchData = new ArrayList<>();
        matchIds = getMatchIdsFromUserName(username); // @todo stream
        int index = 0;
        for (Long l:matchIds
        ) {
            if(index < 2) {
                UserMatchData umd = new UserMatchData(l.toString());
                userMatchData.add(umd);
            }
            index++;
        }
        return userMatchData;
    }
    public static void getSummoner(Summoner summoner, String name){// using api.java we are able to parse the website for basic information on each summoner
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
    public static void getRanked(Ranked ranked, String id){//using summoner data we are able to parse information about their ranked data
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


    public static String getVersion(){//gets version of game
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode node = objectMapper.readTree(Api.getVersion());
            return node.get(0).asText();
        }catch(JsonProcessingException e){
            e.printStackTrace();
            return "getVersion did not work";
        }
    }
    public static void getSummonerMatch(MatchList matchList, String id){//using getSummoner data we are able to view their last 100 games.
        try{
            JsonNode node = (new ObjectMapper()).readTree(Api.getMatchesBySummonerId(id));

            matchList.setStartIndex(node.get("startIndex").asInt());
            matchList.setTotalGames(node.get("totalGames").asInt());
            matchList.setEndIndex(node.get("endIndex").asInt());
            System.out.println("data saved");

            JsonNode champJson = (new ObjectMapper()).readTree(Api.getChampionName());
            JsonNode matchJson = (new ObjectMapper()).readTree(Api.getMatchTypes());
            System.out.println("printing match json: "+matchJson.get(64));


            for(int i = matchList.getStartIndex(); i< matchList.getEndIndex(); i++){
                matchList.addMatch(node.get("matches").get(i), champJson, matchJson);
            }

        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
    }

}