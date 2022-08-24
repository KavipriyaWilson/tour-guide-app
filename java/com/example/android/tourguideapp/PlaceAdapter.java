package com.example.android.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class PlaceAdapter  extends ArrayAdapter<Place> {


    public PlaceAdapter(Context context, ArrayList<Place> object) {
        super(context, 0, object);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (convertView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Place currentInfo = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.placeNameText);
        nameTextView.setSelected(true);
        nameTextView.setText(currentInfo.getPlaceName());


        ImageView placeImageView = (ImageView) listItemView.findViewById(R.id.item_image);
        placeImageView.setImageResource(currentInfo.getPlaceImageResourceID());

        return listItemView;
    }
}