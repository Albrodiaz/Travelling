package es.travelworld.travelling.repository.response.hotels;

import com.google.gson.annotations.SerializedName;

public class Address{

	@SerializedName("obfuscate")
	private boolean obfuscate;

	@SerializedName("streetAddress")
	private String streetAddress;

	@SerializedName("countryCode")
	private String countryCode;

	@SerializedName("postalCode")
	private String postalCode;

	@SerializedName("locality")
	private String locality;

	@SerializedName("countryName")
	private String countryName;

	@SerializedName("extendedAddress")
	private String extendedAddress;

	@SerializedName("region")
	private String region;

	public boolean isObfuscate(){
		return obfuscate;
	}

	public String getStreetAddress(){
		return streetAddress;
	}

	public String getCountryCode(){
		return countryCode;
	}

	public String getPostalCode(){
		return postalCode;
	}

	public String getLocality(){
		return locality;
	}

	public String getCountryName(){
		return countryName;
	}

	public String getExtendedAddress(){
		return extendedAddress;
	}

	public String getRegion(){
		return region;
	}
}