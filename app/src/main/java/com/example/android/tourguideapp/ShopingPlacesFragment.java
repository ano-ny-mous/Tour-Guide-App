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


public class ShopingPlacesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shoping_places, container, false);

        ListView listView = (ListView) view.findViewById(R.id.shoppingplaceslist);
        Tour shoppingplace1 = new Tour(R.drawable.mg_road, getString(R.string.shoppingplace1name), getString(R.string.shoppingplace1distance), getString(R.string.shoppingplace1sum));
        Tour shoppingplace2 = new Tour(R.drawable.magestic_market, getString(R.string.shoppingplace2name), getString(R.string.shoppingplace2distance), getString(R.string.shoppingplace2sum));
        Tour shoppingplace3 = new Tour(R.drawable.t_nagar, getString(R.string.shoppingplace3name), getString(R.string.shoppingplace3distance), getString(R.string.shoppingplace3sum));
        Tour shoppingplace4 = new Tour(R.drawable.cotton_street, getString(R.string.shoppingplace4name), getString(R.string.shoppingplace4distance), getString(R.string.shoppingplace4sum));

        final ArrayList<Tour> tourlist = new ArrayList<>();
        tourlist.add(shoppingplace1);
        tourlist.add(shoppingplace2);
        tourlist.add(shoppingplace3);
        tourlist.add(shoppingplace4);

        TourAdapter tourAdapter = new TourAdapter(getActivity(), R.layout.adapter_view_shoppingplaces, tourlist);

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