package xebia.newyorktimes.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Result {


    @SerializedName("title")
    @Expose
    private String title;

    public String getAbstractbody() {
        return abstractbody;
    }

    public String getPublished_date() {
        return published_date;
    }

    @SerializedName("abstract")
    @Expose
    private String abstractbody;
    @SerializedName("published_date")
    @Expose
    private String published_date;

    public List<Media> getMedia() {
        return media;
    }

    @SerializedName("media")
    @Expose
    private List<Media> media = null;
    public Result() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




}
