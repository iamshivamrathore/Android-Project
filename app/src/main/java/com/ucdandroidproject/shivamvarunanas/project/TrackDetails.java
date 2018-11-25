package com.ucdandroidproject.shivamvarunanas.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class TrackDetails extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "TrackDetails";
    Intent intent = null;
    Track track1 = null;
    ImageView photoIcon;
    ImageView videoIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_details);
        Intent intent1 = getIntent();
        track1 = (Track) intent1.getSerializableExtra("TRACK");
        Log.d(TAG, "onCreate: " + track1.getTrackName());

        photoIcon = findViewById(R.id.imageView_Photo);
        videoIcon = findViewById(R.id.imageView_Video);

        setTitle(track1.getTrackName());
    }


    @Override
    protected void onResume() {
        super.onResume();
        photoIcon.setOnClickListener(this);
        videoIcon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = null;



        Log.d(TAG, "onClick: "+track1.getTrackName());
        switch (id){
            case R.id.imageView_Photo:
                intent = new Intent(this, MainActivity_Screen_Photos.class);
                break;

            case R.id.imageView_Video:
               intent = new Intent(this,YoutubeActivity.class);

               break;
        }

        if(intent !=null){
            intent.putExtra("TRACK", track1);
            startActivity(intent);
        }
    }
}
