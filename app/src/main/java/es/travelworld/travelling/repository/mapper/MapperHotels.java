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
            Hotels hotelModel = new Hotels();
            hotelModel.setHotelPhoto(item.getOptimizedThumbUrls().getSrpDesktop());
            hotelModel.setAddress(item.getAddress().getStreetAddress());
            hotelModel.setLocality(item.getAddress().getLocality());
            hotelModel.setRating(item.getStarRating());
            hotels.add(hotelModel);
        }

        return hotels;
    }

}
