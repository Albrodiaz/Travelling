package es.travelworld.travelling.repository.response.hotels;

import com.google.gson.annotations.SerializedName;

public class ResultsItem {

    @SerializedName("ratePlan")
    private RatePlan ratePlan;

    @SerializedName("address")
    private Address address;

    @SerializedName("coordinate")
    private Coordinate coordinate;

    @SerializedName("guestReviews")
    private GuestReviews guestReviews;

    @SerializedName("supplierHotelId")
    private int supplierHotelId;

    @SerializedName("neighbourhood")
    private String neighbourhood;

    @SerializedName("name")
    private String name;

    @SerializedName("isAlternative")
    private boolean isAlternative;

    @SerializedName("id")
    private int id;

    @SerializedName("starRating")
    private int starRating;

    @SerializedName("optimizedThumbUrls")
    private OptimizedThumbUrls optimizedThumbUrls;

    @SerializedName("providerType")
    private String providerType;

    public RatePlan getRatePlan() {
        return ratePlan;
    }

    public Address getAddress() {
        return address;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public GuestReviews getGuestReviews() {
        return guestReviews;
    }

    public int getSupplierHotelId() {
        return supplierHotelId;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public String getName() {
        return name;
    }

    public boolean isIsAlternative() {
        return isAlternative;
    }

    public int getId() {
        return id;
    }

    public int getStarRating() {
        return starRating;
    }

    public OptimizedThumbUrls getOptimizedThumbUrls() {
        return optimizedThumbUrls != null ? optimizedThumbUrls : new OptimizedThumbUrls();
    }

    public String getProviderType() {
        return providerType;
    }
}