package edu.aubg.ironmaidenapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class BandImageAdapter extends BaseAdapter {
    private Context mContext;
    //array of images for the band members that can be accessed by other classes(static)
   private Integer[] members = {R.drawable.bruced,R.drawable.steveh,R.drawable.davem,R.drawable.nickom,R.drawable.adrians,R.drawable.janickg};

    public BandImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return members.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;

        if (convertView == null) {

            // Initialize some attributes
            imageView = new ImageView(mContext);

            imageView.setLayoutParams(
                    new GridView.LayoutParams(325, 325));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            imageView.setPadding(4, 4, 4, 4);
        }

        else {

            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(members[position]);

        return imageView;
    }

}
