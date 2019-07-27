package xebia.newyorktimes.ui.main;

import xebia.newyorktimes.models.NewsResponse;


public interface MainViewInterface {

    void showToast(String s);
    void showProgressBar();
    void hideProgressBar();
    void displayNews(NewsResponse newsResponse);
    void displayError(String s);
}
