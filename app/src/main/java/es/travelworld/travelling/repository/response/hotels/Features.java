package es.travelworld.travelling.repository.response.hotels;

import com.google.gson.annotations.SerializedName;

public class Features{

	@SerializedName("paymentPreference")
	private boolean paymentPreference;

	@SerializedName("noCCRequired")
	private boolean noCCRequired;

	public boolean isPaymentPreference(){
		return paymentPreference;
	}

	public boolean isNoCCRequired(){
		return noCCRequired;
	}
}