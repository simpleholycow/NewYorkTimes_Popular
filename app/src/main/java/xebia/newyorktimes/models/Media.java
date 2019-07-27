package xebia.newyorktimes.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Media {
    @SerializedName("type")
    @Expose
    private String type;

    public List<Media_Metadata> getMedia_metadata() {
        return media_metadata;
    }

    @SerializedName("media-metadata")
    @Expose
    private List<Media_Metadata> media_metadata = null;
}
