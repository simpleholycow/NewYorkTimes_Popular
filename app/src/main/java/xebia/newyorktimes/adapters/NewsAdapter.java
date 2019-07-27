package xebia.newyorktimes.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


import xebia.newyorktimes.R;
import xebia.newyorktimes.models.Result;
import xebia.newyorktimes.ui.main.DetailNews;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    List<Result> newsList;
    Context context;

    public NewsAdapter(List<Result> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
        Log.i("pankaj", "length>>" + newsList.size());
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_news, parent, false);
        NewsHolder mh = new NewsHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, final int position) {

        holder.tvTitle.setText(newsList.get(position).getTitle());
        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(context, DetailNews.class);
                    i.putExtra("abstract", newsList.get(position).getAbstractbody());
                    context.startActivity(i);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        });
        Glide.with(context).load(newsList.get(position).getMedia().get(0).getMedia_metadata().get(0).getUrl())
                .into(holder.ivImg);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        ImageView ivImg;

        public NewsHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            ivImg = (ImageView) v.findViewById(R.id.ivImg);
        }
    }
}
