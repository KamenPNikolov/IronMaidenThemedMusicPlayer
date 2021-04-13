package edu.aubg.ironmaidenapp;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends AppCompatActivity {
    Button button1,button2,button3,button4,button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //assignment of buttons
        button1=(Button) findViewById(R.id.bandInfoButton);
        button2=(Button) findViewById(R.id.galleryButton);
        button3=(Button) findViewById(R.id.liveperformancesButton);
        button4=(Button) findViewById(R.id.albumsButton);
        button5= (Button) findViewById(R.id.videoButton);
        //onClick event listeners for each button leading to different activities
        // we assign the first button to the BandInformation activity through an intent
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), BandInformationActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),GalleryActivity.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicHandler.StopMusic();//Music needs to be stopped because of sound interference with videos
                Intent intent= new Intent(getApplicationContext(),LivePerformancesActivity.class);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),AlbumActivity.class);
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicHandler.StopMusic();
                Intent intent= new Intent(getApplicationContext(),Video.class);
                startActivity(intent);
            }
        });

        MusicHandler.CreateMusic(this);
    }
    @Override
     public void onResume()
    {super.onResume();
     //create and start the music handler class
        if(MusicHandler.mediaPlayer.isPlaying()==false)
        {
            MusicHandler.StartMusic(this);
        }
    }
    public void onDestroy()
    {
        super.onDestroy();
        MusicHandler.ReleaseMusic();
    }


}

