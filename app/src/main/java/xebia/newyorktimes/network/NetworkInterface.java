package xebia.newyorktimes.network;


import retrofit2.http.Path;
import xebia.newyorktimes.models.NewsResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface NetworkInterface {

    @GET("{period}.json")
    Observable<NewsResponse> getNewsLinks(@Path("period") String period, @Query("api-key") String api_key);

}
