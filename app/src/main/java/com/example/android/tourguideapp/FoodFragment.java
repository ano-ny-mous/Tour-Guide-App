package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food, container, false);

        ListView listView = (ListView) view.findViewById(R.id.foodlist);
        Tour food1 = new Tour(R.drawable.butter_chicken, getString(R.string.food1name), getString(R.string.food1distance), getString(R.string.food1sum));
        Tour food2 = new Tour(R.drawable.tandoori_chicken, getString(R.string.food2name), getString(R.string.food2distance), getString(R.string.food2sum));
        Tour food3 = new Tour(R.drawable.chole, getString(R.string.food3name), getString(R.string.food3distance), getString(R.string.food3sum));
        Tour food4 = new Tour(R.drawable.naan, getString(R.string.food4name), getString(R.string.food4distance), getString(R.string.food4sum));
        Tour food5 = new Tour(R.drawable.chicken_tikka_masala, getString(R.string.food5name), getString(R.string.food5distance), getString(R.string.food5sum));

        final ArrayList<Tour> tourlist = new ArrayList<>();
        tourlist.add(food1);
        tourlist.add(food2);
        tourlist.add(food3);
        tourlist.add(food4);
        tourlist.add(food5);

        TourAdapter tourAdapter = new TourAdapter(getActivity(), R.layout.adapter_view_food, tourlist);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Summary.class);
                intent.putExtra("name", tourlist.get(position).getName());
                intent.putExtra("des", tourlist.get(position).getDiscription());
                intent.putExtra("image", tourlist.get(position).getImage());
                startActivity(intent);
            }
        });
        listView.setAdapter(tourAdapter);
        return view;
    }
}