package es.travelworld.travelling.repository.response.hotels;

import com.google.gson.annotations.SerializedName;

public class RatePlan{

	@SerializedName("features")
	private Features features;

	@SerializedName("price")
	private Price price;

	public Features getFeatures(){
		return features;
	}

	public Price getPrice(){
		return price;
	}
}