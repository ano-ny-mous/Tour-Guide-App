package com.example.android.tourguideapp;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TourAdapter extends ArrayAdapter<Tour> {
    private Context mContext;
    int mResource;

    public TourAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int image = getItem(position).getImage();
        String name = getItem(position).getName();
        String distance = getItem(position).getDistance();
        String discription = getItem(position).getDiscription();
        com.example.android.tourguideapp.Tour tour = new Tour(image, name, distance, discription);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        ImageView ivImage = convertView.findViewById(R.id.foodimagev);
        TextView tvName = convertView.findViewById(R.id.foodtextv);
        TextView tvdistance = convertView.findViewById(R.id.fooddistancev);
        tvName.setText(name);
        ivImage.setImageResource(image);
        tvdistance.setText(distance);
        return convertView;
    }
}
