package com.panchal.vivek.moviemania.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.panchal.vivek.moviemania.Model.Movie;
import com.panchal.vivek.moviemania.R;
import com.panchal.vivek.moviemania.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private Context context;
    private List<Movie> movies;


    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movie_img)
        ImageView image_thumbnail;
        @BindView(R.id.image_item_card)
        CardView image_Card;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.movie_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        String url = context.getResources().getString(R.string.poster_url)+ movies.get(position).getPosterPath();

        Picasso.get().load(url).into(holder.image_thumbnail);
        holder.image_Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("MovieList", movies.get(holder.getAdapterPosition()));
                context.startActivity(intent);

            }
        });

    }


//    public void setData(List<Movie> movies) {
//        this.movies = movies;
//        notifyDataSetChanged();
//    }


    @Override
    public int getItemCount() {
        return movies.size();
    }


}
