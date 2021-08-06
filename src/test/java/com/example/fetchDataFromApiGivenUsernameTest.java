package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;


public class fetchDataFromApiGivenUsernameTest {
    String name = "delicious";
   
    @BeforeAll
    static void set(){
    
    }

    @Test
    public void ApiTestGetSummInfo(){
        //test Api grabbing json summoner info with summoner name 
        assertTrue(Api.fetchDataFromApiGivenUsername(name).contains("Delicious"));
 
    }

}
