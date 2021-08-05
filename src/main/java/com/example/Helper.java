package com.example;

import com.google.gson.Gson;
import match.MatchFromIdResponse;
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

    public static List<match.MatchesItem> getMatchListFromUserName(String username){//returns list of match objects from input username
        Gson gson = new Gson();
        String id = Api.getSummonderPuuidByUserName(username);
        String matchlist = Api.getMatchesBySummonerId(id);
        MatchFromIdResponse response = gson.fromJson(matchlist, MatchFromIdResponse.class);
        return  response.getMatches();
    }
    public static List<Long> getMatchIdsFromUserName(String username){//returns list of longs (match ids) from a given userName
        List<match.MatchesItem> listOfMatches = getMatchListFromUserName(username);
        List<Long> listOfMatchIds = new ArrayList<>();
        for (match.MatchesItem item:listOfMatches
             ) {
            listOfMatchIds.add(item.getGameId());
        }
        return listOfMatchIds;
    }
    public static List<UserMatchData> getMatchResponseDataFromUserName(String username){//returns list of UserMatchData objects, given a username. (DO NOT CALL THIS TOO OFTEN, RATE LIMIT WILL BE REACHED)
        List<Long> matchIds = new ArrayList<>();
        List<UserMatchData> userMatchData = new ArrayList<>();
        matchIds = getMatchIdsFromUserName(username);
        int index = 0;
        for (Long l:matchIds
        ) {
            if(index < 15) {
                UserMatchData umd = new UserMatchData(l.toString());
                userMatchData.add(umd);
            }
            index++;
        }
        return userMatchData;
    }
}