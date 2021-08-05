package match;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;

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

    public void setMatchType(Matches temp, JsonNode matchJson){//traverses the json to match the match id to list of all match ids to get the the name of the match
        for(int i = 0; i<83; i++){
            if(temp.getQueue() == matchJson.get(i).get("queueId").asInt()){
                temp.setMatchType(matchJson.get(i).get("description").asText());
                i= 300;
            }
        }
        if(temp.getMatchType()== null){
            temp.setMatchType("Special");
        }
    }

    public void addMatch (JsonNode node, JsonNode champJson, JsonNode matchJson){//adds match to list of matches
        //System.out.println("entering addMatch");
    
        Matches temp = new Matches();
        //System.out.println("in try: "+node);

        temp.setGameId(node.get("gameId").asLong());
        temp.setRole(node.get("role").asText());
        temp.setSeason(node.get("season").asInt());
        temp.setPlatformId(node.get("platformId").asText());
        temp.setChampion(node.get("champion").asInt());
        temp.setQueue(node.get("queue").asInt());
        temp.setLane(node.get("lane").asText());
        temp.setTimestamp(node.get("timestamp").asLong());

        String champid = Integer.toString(temp.getChampion()); 
        temp.setChampionName(champJson.get(champid).asText());

        setMatchType(temp,matchJson);

        this.matches.add(temp);
    }

    public Matches getMatch(int i){
        return this.matches.get(i);
    }
}

    

