package es.travelworld.travelling.domain;

public class Hotels {
    private String hotelName;
    private String hotelPhoto;
    private String hotelPrice;
    private String address;
    private String locality;
    private String rating;

    public String getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(String hotelPrice) {
        this.hotelPrice = hotelPrice;
    }


    public String getHotelPhoto() {
        return hotelPhoto;
    }

    public void setHotelPhoto(String hotelPhoto) {
        this.hotelPhoto = hotelPhoto;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocality() {
        return locality;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
