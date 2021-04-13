package edu.aubg.ironmaidenapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class AlbumsFragment extends Fragment {
      //array of Album names
      String[] albumNames = {"Iron Maiden","Killers","The Number Of the Beast","Piece of Mind","Powerslave","Somewhere In Time","Seventh Son of the Seventh son"};
     //array of album cover images
     int[] albumImages ={R.drawable.album1,R.drawable.album2,R.drawable.album3,R.drawable.album4,R.drawable.album5,R.drawable.album6,R.drawable.album7};
     ListView lview;
     //a list of Hash maps to hold the corresponding Name-image pairs
     ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       super.onCreateView(inflater, container, savedInstanceState);
        View view =inflater.inflate(R.layout.album_fragment, container, false);

        //Map
        HashMap<String, String> map= new HashMap<String, String>();

        //Fill the map
        for(int i=0;i<albumNames.length;i++)
        {
            map=new HashMap<String, String>();
            map.put("Name", albumNames[i]);
            map.put("Image", Integer.toString(albumImages[i]));

            data.add(map); //fill the hash Map
        }

        //keys
        String[] from={"Name","Image"};

        //ids of the two views in the mylistrow.xml
        int[] to={R.id.AlbumName,R.id.AlbumPicture};

        //ADAPTER that will link the list of mapped pairs of name and image to the list view
        SimpleAdapter adapter=new SimpleAdapter(view.getContext(), data, R.layout.mylistrow, from, to);
        //Link the list view from the album_fragment.xml to the adapter
        lview = (ListView) view.findViewById(R.id.albumList);
        lview.setAdapter(adapter);


        //On click listener for the list view
        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //This onItemClik will actually call the ChangeSongs method of the SongFragment fragment and change the songs
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              lview.setSelector(android.R.color.holo_blue_dark);

              SongsFragment songs =(SongsFragment) getFragmentManager().findFragmentById(R.id.songsfragment);
                //it will pass the position of the pressed item to the ChangeSongs method
              songs.ChangeSongs(position);
            }
        });

        return  view;
    }

}

