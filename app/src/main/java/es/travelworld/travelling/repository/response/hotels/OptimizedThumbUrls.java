package es.travelworld.travelling.repository.response.hotels;

import com.google.gson.annotations.SerializedName;

public class OptimizedThumbUrls {

    @SerializedName("srpDesktop")
    private String srpDesktop;

    public String getSrpDesktop() {
        return srpDesktop != null ? srpDesktop : "";
    }
}