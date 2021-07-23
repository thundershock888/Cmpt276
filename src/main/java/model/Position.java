package model;

import com.google.gson.annotations.SerializedName;

public class Position{

	@SerializedName("x")
	private int X;

	@SerializedName("y")
	private int Y;

	public int getX(){
		return X;
	}

	public int getY(){
		return Y;
	}
}