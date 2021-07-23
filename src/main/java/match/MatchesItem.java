package match;

public class MatchesItem{
	private long gameId;
	private String role;
	private int season;
	private String platformId;
	private int champion;
	private int queue;
	private String lane;
	private long timestamp;

	public long getGameId(){
		return gameId;
	}

	public String getRole(){
		return role;
	}

	public int getSeason(){
		return season;
	}

	public String getPlatformId(){
		return platformId;
	}

	public int getChampion(){
		return champion;
	}

	public int getQueue(){
		return queue;
	}

	public String getLane(){
		return lane;
	}

	public long getTimestamp(){
		return timestamp;
	}
}
