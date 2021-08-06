package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

public class getRankedLeagueDataTest {
    String pid = "Delicious";
   
    @BeforeAll
    static void set(){
    }

    @Test
    public void ApiTestGetRankedInfo(){
        //test Api grabbing json ranked info with id
        Summoner summoner = new Summoner();
        Helper.getSummoner(summoner, pid);
        Ranked ranked = new Ranked();
        Helper.getRanked(ranked, summoner.getId()); 
        String id = summoner.getId();
        
        assertTrue(Api.getRankedLeagueData(id).contains("Delicious"));
    }
}
