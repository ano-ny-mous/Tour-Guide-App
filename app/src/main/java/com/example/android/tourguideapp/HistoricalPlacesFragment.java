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

public class HistoricalPlacesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_historical_places, container, false);

        ListView listView = (ListView) view.findViewById(R.id.historicalplaceslist);
        Tour historicalplace1 = new Tour(R.drawable.taj_mahal, getString(R.string.historicalplace1name), getString(R.string.historicalplace1distance), getString(R.string.historicalplace1sum));
        Tour historicalplace2 = new Tour(R.drawable.qutub_minar, getString(R.string.historicalplace2name), getString(R.string.historicalplace2distance), getString(R.string.historicalplace2sum));
        Tour historicalplace3 = new Tour(R.drawable.mysore_palace, getString(R.string.historicalplace3name), getString(R.string.historicalplace3distance), getString(R.string.historicalplace3sum));
        Tour historicalplace4 = new Tour(R.drawable.gateway_of_india, getString(R.string.historicalplace4name), getString(R.string.historicalplace4distance), getString(R.string.historicalplace4sum));

        final ArrayList<Tour> tourlist = new ArrayList<>();
        tourlist.add(historicalplace1);
        tourlist.add(historicalplace2);
        tourlist.add(historicalplace3);
        tourlist.add(historicalplace4);

        TourAdapter tourAdapter = new TourAdapter(getActivity(), R.layout.adapter_view_historicalplaces, tourlist);

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