package xebia.newyorktimes.ui.main;


import android.util.Log;

import xebia.newyorktimes.R;
import xebia.newyorktimes.models.NewsResponse;
import xebia.newyorktimes.network.NetworkClient;
import xebia.newyorktimes.network.NetworkInterface;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;



public class MainPresenter implements MainPresenterInterface {

    MainViewInterface mvi;
    private String TAG = "MainPresenter";
    String api_key="GTS149HMXZTqOIC79A8ZvMmBDB2QyDAU";

    public MainPresenter(MainViewInterface mvi) {
        this.mvi = mvi;
    }

    @Override
    public void getNews() {

        Log.i(TAG,"getnewscalled");
        getObservable().subscribeWith(getObserver());
    }

    public Observable<NewsResponse> getObservable(){
        return NetworkClient.getRetrofit().create(NetworkInterface.class)
                            .getNewsLinks("7", api_key)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<NewsResponse> getObserver(){
        return new DisposableObserver<NewsResponse>() {

            @Override
            public void onNext(@NonNull NewsResponse newsResponse) {
                Log.d(TAG,"OnNext"+ newsResponse.getResults());
                mvi.displayNews(newsResponse);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
                mvi.displayError("Error fetching news");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
                mvi.hideProgressBar();
            }
        };
    }
}
