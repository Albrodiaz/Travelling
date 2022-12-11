package es.travelworld.travelling.repository.response.hotels;

import com.google.gson.annotations.SerializedName;

public class GuestReviews{

	@SerializedName("badge")
	private String badge;

	@SerializedName("total")
	private int total;

	@SerializedName("unformattedRating")
	private Object unformattedRating;

	@SerializedName("rating")
	private String rating;

	@SerializedName("scale")
	private int scale;

	@SerializedName("badgeText")
	private String badgeText;

	public String getBadge(){
		return badge;
	}

	public int getTotal(){
		return total;
	}

	public Object getUnformattedRating(){
		return unformattedRating;
	}

	public String getRating(){
		return rating;
	}

	public int getScale(){
		return scale;
	}

	public String getBadgeText(){
		return badgeText;
	}
}