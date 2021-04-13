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

import java.util.HashMap;

public class SongsFragment extends Fragment {

    public String[][] songsByAlbum ={{"Prowler" ,"Running Free","Phantom of the Opera","Transylvania","Strange World","Charlotte The Harlot","Iron Maiden"},
             {"The ides of march","Wrathchild","Murders in the Rue Morgue","Another Life","Genghis Khan","Innocent Exile","Killers","Prodigal Son","Purgatory","Drifter"},
             {"Invaders","Children of the Damned","The Prisoner","22 Acacia Avenue","The Number of the Beast","Run to the Hills","Gangland","Halloweed be thy Name" },
             {"Where Eagles Dare","Revelations","Flight of Icarus","Die with your Boots on","The Trooper","Still Life","Quest For Fire","Sun and Steel","To Tame a Land"},
             {"Aces High","2 Minutes to Midnight","Losfer Words","Flash of the Blade","The Duelists","Back In the Village", "Powerslave", "Rime of the Ancient Mariner"},
             {"Caught Somewhere in Time","Wasted Years","Sea of Madness","Heaven can Wait","The loneliness of the long distance runner","Stranger in a Strange Land","Deja-vu","Alexander The Great"},
             {"Moonchild","Infinite Dreams","Can I Play With Madness","The Evil That Men Do","Seventh Son of the Seventh Son","The Prophecy","The Clairvoyant","Only the Good Die Young"}
            };
     private  ListView lv;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view =inflater.inflate(R.layout.song_fragment, container, false);
        //link the songList ListView from the Song fragment XML file
        lv = (ListView) view.findViewById(R.id.songList);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MusicHandler.StopMusic();
                MusicHandler.songIndex=position;
                MusicHandler.CreateMusic(view.getContext());
            }
        });
        return  view;
    }
    //This method will be called by the Album fragment to change the song listings depending on the album
    public void ChangeSongs(int position)
    {
        ArrayAdapter<String> secondaryadapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,songsByAlbum[position]);
        lv.setAdapter(secondaryadapter);

    }

}
