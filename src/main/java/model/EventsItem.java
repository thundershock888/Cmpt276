package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventsItem{

	@SerializedName("creatorId")
	private int creatorId;

	@SerializedName("type")
	private String type;

	@SerializedName("timestamp")
	private int timestamp;

	@SerializedName("wardType")
	private String wardType;

	@SerializedName("position")
	private Position position;

	@SerializedName("killerId")
	private int killerId;

	@SerializedName("victimId")
	private int victimId;

	@SerializedName("assistingParticipantIds")
	private List<Object> assistingParticipantIds;

	@SerializedName("laneType")
	private String laneType;

	@SerializedName("towerType")
	private String towerType;

	@SerializedName("teamId")
	private int teamId;

	@SerializedName("buildingType")
	private String buildingType;

	@SerializedName("participantId")
	private int participantId;

	@SerializedName("itemId")
	private int itemId;

	@SerializedName("skillSlot")
	private int skillSlot;

	@SerializedName("levelUpType")
	private String levelUpType;

	public int getCreatorId(){
		return creatorId;
	}

	public String getType(){
		return type;
	}

	public int getTimestamp(){
		return timestamp;
	}

	public String getWardType(){
		return wardType;
	}

	public Position getPosition(){
		return position;
	}

	public int getKillerId(){
		return killerId;
	}

	public int getVictimId(){
		return victimId;
	}

	public List<Object> getAssistingParticipantIds(){
		return assistingParticipantIds;
	}

	public String getLaneType(){
		return laneType;
	}

	public String getTowerType(){
		return towerType;
	}

	public int getTeamId(){
		return teamId;
	}

	public String getBuildingType(){
		return buildingType;
	}

	public int getParticipantId(){
		return participantId;
	}

	public int getItemId(){
		return itemId;
	}

	public int getSkillSlot(){
		return skillSlot;
	}

	public String getLevelUpType(){
		return levelUpType;
	}
}