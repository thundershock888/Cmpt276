package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MatchResponse{

	@SerializedName("frames")
	private List<FramesItem> frames;

	@SerializedName("frameInterval")
	private int frameInterval;

	public List<FramesItem> getFrames(){
		return frames;
	}

	public int getFrameInterval(){
		return frameInterval;
	}

}