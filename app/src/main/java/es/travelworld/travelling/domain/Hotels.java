package es.travelworld.travelling.domain;

public class Hotels {
    private String hotelPhoto;
    private String address;
    private String locality;
    private int rating;

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

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
