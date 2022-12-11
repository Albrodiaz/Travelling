package es.travelworld.travelling.repository.mapper;

import java.util.ArrayList;
import java.util.List;

import es.travelworld.travelling.domain.Hotels;
import es.travelworld.travelling.repository.response.hotels.Response;
import es.travelworld.travelling.repository.response.hotels.ResultsItem;

public abstract class MapperHotels {

    public static List<Hotels> mapToHotels(Response response) {
        List<Hotels> hotels =  new ArrayList<>();
        List<ResultsItem> listResponse = response.getResults();

        for (ResultsItem item: listResponse) {
            Hotels hotelsDomain = new Hotels();
            hotelsDomain.setHotelName(item.getName());
            hotelsDomain.setHotelPrice(item.getRatePlan().getPrice().getCurrent());
            hotelsDomain.setHotelPhoto(item.getOptimizedThumbUrls().getSrpDesktop());
            hotelsDomain.setAddress(item.getAddress().getStreetAddress());
            hotelsDomain.setLocality(item.getAddress().getLocality());
            hotelsDomain.setRating(String.valueOf(item.getStarRating()));
            hotels.add(hotelsDomain);
        }

        return hotels;
    }

}
