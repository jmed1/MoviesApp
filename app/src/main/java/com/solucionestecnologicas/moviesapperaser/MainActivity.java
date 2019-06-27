package com.solucionestecnologicas.moviesapperaser;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.solucionestecnologicas.moviesapperaser.MovieAdapter.MovieAdapterOnClickHandler;

public class MainActivity extends AppCompatActivity implements MovieAdapterOnClickHandler{

    private RecyclerView mRecyclerView;

    private MovieAdapter mMovieAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_moviesapp);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        mMovieAdapter = new MovieAdapter(this);

        mRecyclerView.setAdapter(mMovieAdapter);

        //loadMoviesData();

    }

    @Override
    public void onClick(Bitmap MovieImage) {
        Context context = this;
        //Toast.makeText(context, MovieImage, Toast.LENGTH_SHORT).show();
    }
}
