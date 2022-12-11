package es.travelworld.travelling.repository.response.hotels;

import com.google.gson.annotations.SerializedName;

public class Price{

	@SerializedName("current")
	private String current;

	@SerializedName("old")
	private String old;

	@SerializedName("exactCurrent")
	private Object exactCurrent;

	public String getCurrent(){
		return current;
	}

	public String getOld(){
		return old;
	}

	public Object getExactCurrent(){
		return exactCurrent;
	}
}