package es.travelworld.travelling.utilities;

import android.Manifest;

import es.travelworld.travelling.R;

public abstract class Constants {
    public static final int REQUEST_IMAGE_CAPTURE = 1;
    public static final String TERMSWEB = "https://developers.google.com/ml-kit/terms";
    public static final String EURODISNEYWEB = "https://www.disneylandparis.com/es-es/";

    public static final int ICONCASTLE = R.id.iconCastle;
    public static final int ICONCAR = R.id.itemCar;

    public static final String KEY_USER = "userName";
    public static final String KEY_PASSWORD = "userPassword";

    public static final String TAG_HOMEFRAGMENT = "f0";

    public static final String CHANNEL_ID = "Login notify";
    public static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    public static final String COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    public static final int NOTIFICATION_ID = 122;

    public static final String HOST_HOTELS = "https://01394d44-8918-4a1d-8059-629c50c25e87.mock.pstmn.io/";
    public static final String TAG_HOTELS = "RepositoryHotels";
    public static final String TAG_HOTELVIEWMODEL = "HotelViewModel";

    public static final String ENDPOINT_LOGIN = "login";
    public static final String ENDPOINT_HOTELS = "login";
}
