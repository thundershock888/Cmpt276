package com.example;
import java.util.ArrayList;

public class MatchList {   
    ArrayList<Matches> matches = new ArrayList<Matches>();
    private int startIndex;
    private int endIndex;
    private int totalGames;


    public int getStartIndex() {
        return startIndex;
    }
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
    public int getEndIndex() {
        return endIndex;
    }
    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
    public int getTotalGames() {
        return totalGames;
    }
    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }


    
}
