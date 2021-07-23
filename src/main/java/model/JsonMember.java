package model;

import com.google.gson.annotations.SerializedName;

public class JsonMember {

	@SerializedName("participantId")
	private int participantId;

	@SerializedName("minionsKilled")
	private int minionsKilled;

	@SerializedName("teamScore")
	private int teamScore;

	@SerializedName("dominionScore")
	private int dominionScore;

	@SerializedName("totalGold")
	private int totalGold;

	@SerializedName("level")
	private int level;

	@SerializedName("xp")
	private int xp;

	@SerializedName("currentGold")
	private int currentGold;

	@SerializedName("position")
	private Position position;

	@SerializedName("jungleMinionsKilled")
	private int jungleMinionsKilled;

	public int getParticipantId(){
		return participantId;
	}

	public int getMinionsKilled(){
		return minionsKilled+jungleMinionsKilled;
	}

	public int getTeamScore(){
		return teamScore;
	}

	public int getDominionScore(){
		return dominionScore;
	}

	public int getTotalGold(){
		return totalGold;
	}

	public int getLevel(){
		return level;
	}

	public int getXp(){
		return xp;
	}

	public int getCurrentGold(){
		return currentGold;
	}

	public Position getPosition(){
		return position;
	}

	public int getJungleMinionsKilled(){
		return jungleMinionsKilled;
	}
}