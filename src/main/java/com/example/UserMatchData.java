package com.example;

import model.JsonMember;
import model.MatchResponse;


public class UserMatchData {
    int id;
    int totalTime;
    int numFrames;
    MatchResponse response;
    UserMatchData(MatchResponse matchResponse, int id){
        numFrames = matchResponse.getFrames().size();
        response = matchResponse;
        this.id = id;
    }
    public float getCs(){
        int maxCs = getJsonMemeberFromParticipantId(id,numFrames-1).getMinionsKilled();
        return maxCs;
    }
    public JsonMember getJsonMemeberFromParticipantId(int i, int frameNumber){
        return response.getFrames().get(frameNumber).getParticipantFrames().getJsonMemberI(i);
    }
}
