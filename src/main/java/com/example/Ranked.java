package com.example;

public class Ranked {
    private String leagueId;
    private String summonerId;
    private String summonerName;
    private String queuetype;
    private String tier;
    private String rank;
    private int leaguePoints;
    private int wins;
    private int losses;
    private boolean hotStreak;
    private boolean veteran;
    private boolean freshBlood;
    private boolean inactive;

    
    public String getLeagueId() {
        return leagueId;
    }
    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }
    public String getSummonerId() {
        return summonerId;
    }
    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }
    public String getSummonerName() {
        return summonerName;
    }
    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }
    public String getQueuetype() {
        return queuetype;
    }
    public void setQueuetype(String queuetype) {
        this.queuetype = queuetype;
    }
    public String getTier() {
        return tier;
    }
    public void setTier(String tier) {
        this.tier = tier;
    }
    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    public int getLeaguePoints() {
        return leaguePoints;
    }
    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }
    public int getWins() {
        return wins;
    }
    public void setWins(int wins) {
        this.wins = wins;
    }
    public int getLosses() {
        return losses;
    }
    public void setLosses(int losses) {
        this.losses = losses;
    }
    public boolean isHotStreak() {
        return hotStreak;
    }
    public void setHotStreak(boolean hotStreak) {
        this.hotStreak = hotStreak;
    }
    public boolean isVeteran() {
        return veteran;
    }
    public void setVeteran(boolean veteran) {
        this.veteran = veteran;
    }
    public boolean isFreshBlood() {
        return freshBlood;
    }
    public void setFreshBlood(boolean freshBlood) {
        this.freshBlood = freshBlood;
    }
    public boolean isInactive() {
        return inactive;
    }
    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }
    

    
}
