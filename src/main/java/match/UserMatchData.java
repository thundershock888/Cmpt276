package match;


import com.example.Api;
import com.google.gson.Gson;
import model.JsonMember;
import model.MatchResponse;


public class UserMatchData {
    final static Gson gson = new Gson();
    //int id;
    int totalTime;
    int numFrames;
    MatchResponse response;
    public UserMatchData(String matchId){// constructor for matchdata object, takes in a interger(1-10) as participant ID, and a match id
        String matchString = Api.getMatchDataByMatchId(matchId);
        response = gson.fromJson(matchString, MatchResponse.class);
        numFrames = response.getFrames().size();

        //this.id = id;
    }
    //NOTE: all the following 5 methods take in the participant id(1-10) and return the corresponding value
    public int getCs(int id){//returns cs score for a participant, id 1-10
        int maxCs = getJsonMemeberFromParticipantId(id,numFrames-1).getMinionsKilled();
        return maxCs;
    }
    public int getTeamScore(int id){
        return getJsonMemeberFromParticipantId(id, numFrames-1).getTeamScore();
    }
    public int getDominionScore(int id){
        return getJsonMemeberFromParticipantId(id, numFrames-1).getDominionScore();
    }
    public int getTotalGold(int id){
        return getJsonMemeberFromParticipantId(id, numFrames-1).getTotalGold();
    }
    public int getLevel(int id){
        return getJsonMemeberFromParticipantId(id, numFrames-1).getLevel();
    }


    public JsonMember getJsonMemeberFromParticipantId(int i, int frameNumber){
        return response.getFrames().get(frameNumber).getParticipantFrames().getJsonMemberI(i);
    }
}
