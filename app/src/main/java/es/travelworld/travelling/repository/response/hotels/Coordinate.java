package es.travelworld.travelling.repository.response.hotels;

import com.google.gson.annotations.SerializedName;

public class Coordinate{

	@SerializedName("lon")
	private Object lon;

	@SerializedName("lat")
	private Object lat;

	public Object getLon(){
		return lon;
	}

	public Object getLat(){
		return lat;
	}
}