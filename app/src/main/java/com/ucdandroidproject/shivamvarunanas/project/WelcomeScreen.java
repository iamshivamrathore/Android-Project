package com.ucdandroidproject.shivamvarunanas.project;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class WelcomeScreen extends AppCompatActivity {

    private GifImageView imageView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        imageView = findViewById(R.id.welcomeImage);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(progressBar.VISIBLE);

        try{
            InputStream inputStream = getAssets().open("batmanrun.gif");
            byte[] in = IOUtils.toByteArray(inputStream);
            imageView.setBytes(in);
            imageView.startAnimation();
        }catch (IOException e){

        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                WelcomeScreen.this.startActivity(new Intent(WelcomeScreen.this, MainActivity.class
                ));
                WelcomeScreen.this.finish();
            }
        },4000);
    }
}
