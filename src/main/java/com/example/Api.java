package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;

import com.mysql.cj.xdevapi.JsonArray;

public class Api {
    final static String key = "RGAPI-9316d34d-a14f-44e5-9266-7b25d65c65f8";
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
        String puuid =userData[2].split(":")[1];
        puuid = puuid.substring(1, puuid.length()-1);
        System.out.println("printing puuid parsed: " + puuid);
        return puuid;

    }
    public static String getMatchesBySummonerId(String id){//takes in a users puuid, and returns the match history( list of matches)
        String puuid = getSummonderPuuidByUserName(id);
        String link = "https://americas.api.riotgames.com/lol/match/v5/matches/by-puuid/"+ puuid +"/ids?start=0&count=200&" + "api_key="+ key;
        return fetchDataFromApiAsString(link);
    }
    public static String getMatchDataByMatchId(String matchID){//takes the numerical match id, (only works in NA regoin for now), and
        //returns a valid json string that contains the match data. very large. wayne is currently working on a way to parse this into more usable and useful data.
        String link = "https://na1.api.riotgames.com/lol/match/v4/timelines/by-match/" + matchID+ "?api_key=" + key;
        return fetchDataFromApiAsString(link);
    }


    public static String getRankedLeagueData(String id){//retrieves ranked data.
        return fetchDataFromApiAsString("https://na1.api.riotgames.com/lol/league/v4/entries/by-summoner/"+ id+"?api_key="+key);
    }
    
}


