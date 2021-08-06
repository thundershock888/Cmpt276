package match;

public class Matches {
    public long gameId;
    public String role;
    public int season;
    private String platformId;    
    private int champion;
    private int queue;
    private String lane;
    private long timestamp;
    private String championName;
    private String championFileName;
    private String matchType;


    public long getGameId() {
        return gameId;
    }
    public void setGameId(long gameId) {
        this.gameId = gameId;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public int getSeason() {
        return season;
    }
    public void setSeason(int season) {
        this.season = season;
    }
    public String getPlatformId() {
        return platformId;
    }
    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }
    public int getChampion() {
        return champion;
    }
    public void setChampion(int champion) {
        this.champion = champion;
    }
    public int getQueue() {
        return queue;
    }
    public void setQueue(int queue) {
        this.queue = queue;
    }
    public String getLane() {
        return lane;
    }
    public void setLane(String lane) {
        this.lane = lane;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    public String getChampionName() {
        return championName;
    }
    public void setChampionName(String championName) {
        this.championName = championName;
        this.championFileName = this.championName.replace(" ", "");
    }
    public String getChampionFileName(){
        return championFileName;
    }
    public String getMatchType() {
        return matchType;
    }
    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }
    


}
