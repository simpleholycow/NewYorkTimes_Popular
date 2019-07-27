package xebia.newyorktimes.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Media_Metadata {
    public String getUrl() {
        return url;
    }

    @SerializedName("url")
    @Expose
    private String url;
}
