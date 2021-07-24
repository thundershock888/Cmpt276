package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

public class SummonerTest {
    static Summoner s;

    @BeforeAll
    static void setUp(){
        s = new Summoner();
        s.setName("delicious");

    }

    @Test
    public void summAc(){
        assertEquals("delicious",s.getName());
        s.setName("from iron");
        assertEquals("from iron",s.getName());
    }
}
    

