package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.mysql.cj.xdevapi.JsonArray;

public class Api {
    public static String key = System.getenv().get("RIOT_API_KEY"); 
    
/*
     static {
         try {
             List<String> lines = Files.lines(Paths.get("apikeys.txt")).collect(Collectors.toList());
             key = lines.get(0);
         } catch (IOException e) {
             System.out.println("Api keys doesn't exist, please add the file.");
             e.printStackTrace();
         }
     }*/

    private static HttpURLConnection connection;
    static BufferedReader reader;
    static String line;
    static StringBuffer responseContent = new StringBuffer();
    public static String fetchDataFromApiGivenUsername(String username){
        return fetchDataFromApiAsString("https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + username+"?api_key="+ key);
    }
    public static String fetchDataFromApiAsString(String link) {//given a api link string, aka like https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + username+"?api_key="+ key, returns a string
        //that is in a valid json format containing that data from that api pull request.
        responseContent = new StringBuffer();
        try {
            URL url = new URL(link);
            //System.out.println(link);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status = connection.getResponseCode();
            System.out.println(status);
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }

            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseContent.toString();
    }
    public static String getSummonderPuuidByUserName(String id){//returns the puuid of a league account, given the username
        String link = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + id+"?api_key="+ key;
        try {
            URL url = new URL(link);
            //System.out.println(link);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status = connection.getResponseCode();
            System.out.println(status);
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();

            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] userData = responseContent.toString().split(",");
        for (int i = 0; i < userData.length; i++) {
            System.out.println(userData[i]);
        }
        String puuid =userData[1].split(":")[1];
        puuid = puuid.substring(1, puuid.length()-1);
        System.out.println("printing puuid parsed: " + puuid);
        return puuid;

    }
    public static String getMatchesBySummonerId(String id){//takes in a users encrypted accountID, and returns the match history( list of matches)
        //String puuid = getSummonderPuuidByUserName(id);
        return fetchDataFromApiAsString("https://na1.api.riotgames.com/lol/match/v4/matchlists/by-account/"+ id + "?api_key="+ key);
    }
    public static String getMatchDataByMatchId(String matchID){//takes the numerical match id, (only works in NA regoin for now), and
        //returns a valid json string that contains the match data. very large. wayne is currently working on a way to parse this into more usable and useful data.
        String link = "https://na1.api.riotgames.com/lol/match/v4/timelines/by-match/" + matchID+ "?api_key=" + key;
        return fetchDataFromApiAsString(link);
    }


    public static String getRankedLeagueData(String id){//retrieves ranked data.
        return fetchDataFromApiAsString("https://na1.api.riotgames.com/lol/league/v4/entries/by-summoner/"+ id+"?api_key="+key);
    }

    public static String getVersion(){//retrieves version of game, used to get champion data
        return fetchDataFromApiAsString("https://ddragon.leagueoflegends.com/api/versions.json");
    }

    public static String getChampionData(String version){//retrieves champion data such as names
        return fetchDataFromApiAsString("https://ddragon.leagueoflegends.com/cdn/"+ version + "/data/en_US/champion.json");
    }
    public static String getChampionName(){//custom made json file to get champion names
        return fetchDataFromApiAsString("https://raw.githubusercontent.com/Sunderinq/League-champion-json/main/champions.json");
    }
    public static String getMatchTypes(){//queue types in league
        return fetchDataFromApiAsString("https://static.developer.riotgames.com/docs/lol/queues.json");
    }
}



