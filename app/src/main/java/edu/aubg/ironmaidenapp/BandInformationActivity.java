package edu.aubg.ironmaidenapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.VideoView;

import org.w3c.dom.Text;

public class BandInformationActivity extends AppCompatActivity {
    //Setup an array of info strings for every band member
    String[] info = {"Paul Bruce Dickinson (born 7 August 1958) is an English singer, songwriter, musician, airline pilot, entrepreneur, author, and broadcaster. He is the lead singer of the heavy metal band Iron Maiden and is renowned for his wide-ranging operatic vocal style and energetic stage presence.",
     "Stephen Percy Harris (born 12 March 1956) is an English musician, songwriter, bassist, occasional keyboardist, backing vocalist, primary songwriter and founder of the British heavy metal band Iron Maiden. He has been the band's only constant member since their inception in 1975 and, along with guitarist Dave Murray, one of only two members to have appeared on all of their albums.",
            "David Michael \"Dave\" Murray (born 23 December 1956)[1] is an English guitarist and songwriter. He was one of the earliest members of the British heavy metal band Iron Maiden and, along with the group's founder, bassist and primary songwriter Steve Harris, has appeared on all of the band's releases.",
            "Michael Henry \"Nicko\" McBrain (born 5 June 1952) is an English drummer member of the British heavy metal band Iron Maiden. Having played in small pub bands from the age of 14, upon leaving school McBrain paid his bills with session work before he joined a variety of artists, such as the Streetwalkers. He joined Iron Maiden in time to debut on their fourth album, Piece of Mind(1983).",
            "Adrian Frederick \"H\" Smith (born 27 February 1957) is an English guitarist and member of Iron Maiden, for whom he writes songs and performs live backing vocals on some tracks.Smith grew up in London and became interested in rock music at 15. He soon formed a friendship with future Iron Maiden guitarist Dave Murray, who inspired him to take up the guitar.",
            "Janick Robert Gers (/ˈjænɪk ˈɡɜːrz/; born 27 January 1957) is an English musician and one of the three guitarists in Iron Maiden. He was also previously a member of the bands Gillan and White Spirit."};
     //Headings
    String[] headings = {"Bruce Dickinson","Steve Harris", "Dave Murray", "Nicko McBrain","Adrian Smith","Janick Gers"};
    TextView body;
    TextView heading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_band_information);

        //assign the textviews for heading and body
         body = (TextView) findViewById(R.id.textbody);
       heading = (TextView) findViewById(R.id.textheading);
        //setup our grid view for images with onclick event listeners
        GridView gridView = (GridView) findViewById(R.id.bandmembersgrid);
        gridView.setAdapter(new BandImageAdapter(this));

        //Set an on click event listener to show the respective information for different band members
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                heading.setText(headings[position]);
                body.setText(info[position]);

            }
        });

    }
}
