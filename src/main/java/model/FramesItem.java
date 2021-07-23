package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FramesItem{

	@SerializedName("participantFrames")
	private ParticipantFrames participantFrames;

	@SerializedName("events")
	private List<Object> events;

	@SerializedName("timestamp")
	private int timestamp;

	public ParticipantFrames getParticipantFrames(){
		return participantFrames;
	}

	public List<Object> getEvents(){
		return events;
	}

	public int getTimestamp(){
		return timestamp;
	}
}