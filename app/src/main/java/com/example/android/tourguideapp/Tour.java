package com.example.android.tourguideapp;

public class Tour {
    int Image;
    String Name;
    String Distance;
    String Discription;

    public Tour(int image, String name, String distance, String discription) {
        Image = image;
        Name = name;
        Distance = distance;
        Discription = discription;
    }


    public int getImage() {
        return Image;
    }

    public String getName() {
        return Name;
    }

    public String getDistance() {
        return Distance;
    }

    public String getDiscription() {
        return Discription;
    }
}
