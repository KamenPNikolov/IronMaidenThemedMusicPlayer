package edu.aubg.ironmaidenapp;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        //setup the image view to show the first gallery picture
        final ImageView imageviewGallery = (ImageView) findViewById(R.id.imageViewGallery);
        imageviewGallery.setImageResource(R.drawable.pic1);


         GridView gridview = (GridView) findViewById(R.id.gridviewGallery);
        gridview.setAdapter(new ImageAdapter(this));
        //On click listener that is going to pass the Clicked picturw from the Grid to the Image view so it is  easily visible
        gridview.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                        //We set the image view to the picture ID of the clicked image
                        imageviewGallery.setImageResource(ImageAdapter.pictureIDs[position]);

                    }
                });//Setup the GridView with the help of our Image Adapter class



    }


    }

