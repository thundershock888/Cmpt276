package com.example;

import org.junit.jupiter.api.Test;

import match.MatchList;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

public class getSummonerMatchTest {
    String pid = "Delicious";
   
    @BeforeAll
    static void set(){
    }

    @Test
    public void ApiTestGetMatchInfo(){
        //test Api grabbing json matches info with id
        Summoner summoner = new Summoner();
        Helper.getSummoner(summoner, pid);
        MatchList matchList = new MatchList();
        Helper.getSummonerMatch(matchList, summoner.getAccountId());
        String id = summoner.getAccountId();
        
        assertTrue(Api.getMatchesBySummonerId(id).contains("4000848091"));

}
}
