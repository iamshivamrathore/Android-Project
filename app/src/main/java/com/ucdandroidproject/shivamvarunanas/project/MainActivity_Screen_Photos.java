package com.ucdandroidproject.shivamvarunanas.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_Screen_Photos extends BaseActivity implements GetFlickrJsonData.OnDataAvailable, RecyclerItemClickListener.OnRecyclerClickListener {
    private static final String TAG = "MainActivity";
    private FlickrRecyclerViewAdapter flickrRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: starts");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_photos);
        activateToolbar(true);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, this));
        flickrRecyclerViewAdapter = new FlickrRecyclerViewAdapter(this, new ArrayList<Photo>());
        recyclerView.setAdapter(flickrRecyclerViewAdapter);

//        GetRawData getRawData = new GetRawData(this);
//        getRawData.execute("https://api.flickr.com/services/feeds/photos_public.gne?tags=android,nougat,sdk&tagmode=any&format=json&nojsoncallback=1");

        Log.d(TAG, "onCreate: ends");
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.d(TAG, "onItemClick: ");
        Intent intent = new Intent(this, PhotoDetailActivity.class);
        intent.putExtra(PHOTO_TRANSFER, flickrRecyclerViewAdapter.getPhoto(position));
        startActivity(intent);
    }

    @Override
    public void onItemLongClick(View view, int position) {
        Log.d(TAG, "onItemLongClick: ");
        Intent intent = new Intent(this, PhotoDetailActivity.class);
        intent.putExtra(PHOTO_TRANSFER, flickrRecyclerViewAdapter.getPhoto(position));
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        Intent intent1 = getIntent();
        Track track = (Track)intent1.getSerializableExtra("TRACK");
        Log.d(TAG, "onResume starts with intent : "+track.getTrackName());
        super.onResume();
        GetFlickrJsonData getFlickrJsonData = new GetFlickrJsonData(this, "https://api.flickr.com/services/feeds/photos_public.gne", "en-us", false);
//        getFlickrJsonData.executeOnSameThread("android, nougat");
        getFlickrJsonData.execute(track.getTrackName());
        Log.d(TAG, "onResume ends");
    }





    @Override
    public void onDataAvailable(List<Photo> data, DownloadStatus status) {

        if(status == DownloadStatus.OK) {
            flickrRecyclerViewAdapter.loadNewData(data);
        } else {
            // download or processing failed
            Log.e(TAG, "onDataAvailable failed with status " + status);
        }
    }














}
