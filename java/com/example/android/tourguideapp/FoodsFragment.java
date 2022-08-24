package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FoodsFragment extends Fragment implements AdapterView.OnItemClickListener{

    private ArrayList<Place> placeInfo;
    public FoodsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String [] name = getResources().getStringArray(R.array.nameOfFood);
        int [] monumentImageResourceID = {R.drawable.biryani, R.drawable.panipuri, R.drawable.dosa,
                R.drawable.idly, R.drawable.atho};
        String [] description = getResources().getStringArray(R.array.descriptionOfFood);


        View rootView = inflater.inflate(R.layout.places_list, container, false);

        placeInfo = new ArrayList<Place>();
        for (int i = 0; i < monumentImageResourceID.length; i++)
        {
            placeInfo.add(new Place(name[i],  monumentImageResourceID[i], description[i]));
        }
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), placeInfo);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(placeAdapter);
        listView.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        return rootView;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), DetailedInfoActivity.class);
        intent.putExtra("object", placeInfo.get(position));
        intent.putExtra("index", position);
        startActivity(intent);
    }
}