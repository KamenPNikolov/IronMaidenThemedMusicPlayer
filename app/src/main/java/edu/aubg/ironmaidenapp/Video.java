package edu.aubg.ironmaidenapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class Video extends AppCompatActivity {
    Button change;
    int index;
    VideoView videoview;
    Integer[] videos ={R.raw.videoplayback,R.raw.videoplayback2};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        index=0;
        videoview=(VideoView) findViewById(R.id.videoView1);
         //assign first video to the video view
        videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + videos[0]));
        videoview.start();
        //assign button
        change = (Button) findViewById(R.id.changeVideoButton);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if we are at the end of the array, take the first video
                if(index==videos.length-1)
                {
                    videoview.stopPlayback();
                    index=0;
                    videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + videos[index]));
                    videoview.start();
                }
                //otherwise, play next video from the array
                else
                {  videoview.stopPlayback();
                    index++;
                    videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + videos[index]));
                     videoview.start();
                }
            }
        });



    }
}
