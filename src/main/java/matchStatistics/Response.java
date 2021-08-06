package matchStatistics;

import java.util.List;

public class Response{
	private long gameId;
	private List<ParticipantIdentitiesItem> participantIdentities;
	private int queueId;
	private String gameType;
	private int gameDuration;
	private List<TeamsItem> teams;
	private String platformId;
	private long gameCreation;
	private int seasonId;
	private String gameVersion;
	private int mapId;
	private String gameMode;
	private List<ParticipantsItem> participants;

	public long getGameId(){
		return gameId;
	}

	public List<ParticipantIdentitiesItem> getParticipantIdentities(){
		return participantIdentities;
	}

	public int getQueueId(){
		return queueId;
	}

	public String getGameType(){
		return gameType;
	}

	public int getGameDuration(){
		return gameDuration;
	}

	public List<TeamsItem> getTeams(){
		return teams;
	}

	public String getPlatformId(){
		return platformId;
	}

	public long getGameCreation(){
		return gameCreation;
	}

	public int getSeasonId(){
		return seasonId;
	}

	public String getGameVersion(){
		return gameVersion;
	}

	public int getMapId(){
		return mapId;
	}

	public String getGameMode(){
		return gameMode;
	}

	public List<ParticipantsItem> getParticipants(){
		return participants;
	}
}