package es.travelworld.travelling;

import android.Manifest;

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
}
