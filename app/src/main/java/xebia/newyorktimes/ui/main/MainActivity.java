package xebia.newyorktimes.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import xebia.newyorktimes.R;
import xebia.newyorktimes.adapters.NewsAdapter;
import xebia.newyorktimes.models.NewsResponse;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    @BindView(R.id.rvNews)
    RecyclerView rvNews;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private String TAG = "MainActivity";
    RecyclerView.Adapter adapter;
    MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupMVP();
        setupViews();
        getNewsList();
    }



    private void setupMVP() {
        mainPresenter = new MainPresenter(this);
    }

    private void setupViews(){
        setSupportActionBar(toolbar);
        rvNews.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getNewsList() {

     mainPresenter.getNews();

    }



    @Override
    public void showToast(String str) {
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void displayNews(NewsResponse newsResponse) {
        if(newsResponse !=null) {
            Log.d(TAG, newsResponse.getResults().get(1).getTitle());
            adapter = new NewsAdapter(newsResponse.getResults(), MainActivity.this);
            rvNews.setAdapter(adapter);
        }else{
            Log.d(TAG,"No response");
        }
    }

    @Override
    public void displayError(String e) {

        showToast(e);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}
