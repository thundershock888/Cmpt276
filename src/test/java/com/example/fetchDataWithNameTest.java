package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;


public class fetchDataWithNameTest {
    String name = "129381290839012839012830912830918230912830912830912830918230981209381092380912839012";
   
    @BeforeAll
    static void set(){
    
    }

    @Test
    public void ApiTestGetSummInfo(){
        //test Api grabbing json summoner info with summoner name that does not exist
        assertFalse(Api.fetchDataFromApiGivenUsername(name).contains("129381290839012839012830912830918230912830912830912830918230981209381092380912839012"));
    }

}