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


public class HotelsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotels, container, false);

        ListView listView = (ListView) view.findViewById(R.id.hotelslist);
        Tour hotel1 = new Tour(R.drawable.taj_lake_palace, getString(R.string.hotel1name), getString(R.string.hotel1distance), getString(R.string.hotel1sum));
        Tour hotel2 = new Tour(R.drawable.the_taj_mahal_palace, getString(R.string.hotel2name), getString(R.string.hotel2distance), getString(R.string.hotel2sum));
        Tour hotel3 = new Tour(R.drawable.oberoi_udaivilas, getString(R.string.hotel3name), getString(R.string.hotel3distance), getString(R.string.hotel3sum));
        Tour hotel4 = new Tour(R.drawable.oberoi_vanyavilas, getString(R.string.hotel4name), getString(R.string.hotel4distance), getString(R.string.hotel4sum));

        final ArrayList<Tour> tourlist = new ArrayList<>();
        tourlist.add(hotel1);
        tourlist.add(hotel2);
        tourlist.add(hotel3);
        tourlist.add(hotel4);

        TourAdapter tourAdapter = new TourAdapter(getActivity(), R.layout.adapter_view_hotels, tourlist);

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