package edu.aubg.ironmaidenapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.provider.MediaStore;

public class MusicHandler {

    static int[] songsArray = {R.raw.prowler,R.raw.runningfree,R.raw.phantom,R.raw.transylv,R.raw.strangeworld,R.raw.charlotte,R.raw.ironmaiden};
    static int songIndex=0;
    static MediaPlayer mediaPlayer;
    // called when the main activity is created and when the song order is changed
    public static void CreateMusic(final Context context)
    {

           mediaPlayer = MediaPlayer.create(context, songsArray[songIndex]);
           //set the mediaPlayer to the song with the next index
           //set an on Completion listener to play each song of the array after the other and loop them
           mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                songIndex++;//update the index
                if(songIndex>=songsArray.length){songIndex=0;}//If the index is equal to the length, start the first song
                  CreateMusic(context);
                }
              });
        StartMusic(context);//Start the music

    }

    public static void StartMusic(Context context)
    {
       // mediaPlayer = MediaPlayer.create(context, songsArray[songIndex]);
        mediaPlayer.start();
    }
    public static void StopMusic()
    {
        mediaPlayer.pause();
    }

    public static void ReleaseMusic()
    {
        mediaPlayer.release();
    }

}
