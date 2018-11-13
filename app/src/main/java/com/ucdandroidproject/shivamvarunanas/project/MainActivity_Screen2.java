package com.ucdandroidproject.shivamvarunanas.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_Screen2 extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity_Screen2";
    List<Track> tracks = new ArrayList<>();
    Button track1;
    Button track2;
    void initializeTracks(){
        Track track = new Track("UCD","", "", "YvipzNysA7E");
        tracks.add(track);
        track = new Track("Blackrock Dublin", "", "","Odu5CLUhRqg" );
        tracks.add(track);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__screen2);
        initializeTracks();
        track1 = findViewById(R.id.button_ucd);
        track2 = findViewById(R.id.button_blackrock);
    }

    @Override
    protected void onResume() {
        super.onResume();
        track1.setOnClickListener(this);
        track2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent(this, TrackDetails.class);
        switch (id){
            case R.id.ucd_image :

            case R.id.button_ucd:
                intent.putExtra("TRACK", tracks.get(0));
                break;
            case R.id.blackrock_image :
            case R.id.button_blackrock:
                intent.putExtra("TRACK", tracks.get(1));
                break;
        }
        Log.d(TAG, "onClick: Before starting");
        startActivity(intent);
    }
}
