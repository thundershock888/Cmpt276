package match;
import java.util.ArrayList;

import com.example.ParticipantIdentities;
import com.example.Participants;
import com.example.Teams;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MatchData {
    long gameId;
    ArrayList<ParticipantIdentities> participantIdenties = new ArrayList<ParticipantIdentities>();
    int queueId;
    String gameType;
    long gameDuration;
    ArrayList<Teams> teams = new ArrayList<Teams>();
    String platformId;
    long gameCreation;
    int seasonId;
    String gameVersion;
    int mapId;
    String gameMode;
    ArrayList<Participants> participants = new ArrayList<Participants>();
}
