package com.solucionestecnologicas.moviesapperaser;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder>
{
    private Bitmap[] mMovieImage;

    private final MovieAdapterOnClickHandler mClickHandler;

    public interface MovieAdapterOnClickHandler
    {
        void onClick(Bitmap MovieImage);
    }

    public MovieAdapter(MovieAdapterOnClickHandler clickHandler)
    {
        mClickHandler = clickHandler;
    }

    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public final ImageView mMovieImageView;

        public MovieAdapterViewHolder(View view)
        {
            super(view);
            mMovieImageView = (ImageView) view.findViewById(R.id.item_imageview);
            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            Bitmap movieImageForItem = mMovieImage[adapterPosition];
            mClickHandler.onClick(movieImageForItem);
        }
    }

    @NonNull
    @Override
    public MovieAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType)
    {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.movie_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);

        return new MovieAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapterViewHolder movieAdapterViewHolder, int position)
    {
        Bitmap itemMovieImage = mMovieImage[position];
        movieAdapterViewHolder.mMovieImageView.setImageBitmap(itemMovieImage);
    }

    @Override
    public int getItemCount() {
        if(null == mMovieImage) return 0;
        return mMovieImage.length;
    }

    public void setImageData(Bitmap[] imageData)
    {
        mMovieImage = imageData;
        notifyDataSetChanged();
    }
}
