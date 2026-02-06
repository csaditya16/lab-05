package com.example.lab5_starter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CityArrayAdapter extends ArrayAdapter<City> {
    private ArrayList<City> cities;
    private Context context;

    private int selectedPosition  = -1; // Know which city is selected

    public CityArrayAdapter(Context context, ArrayList<City> cities){
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    public void setSelectedPosition(int position){
        this.selectedPosition = position;
        notifyDataSetChanged();

    }

    public int getSelectedPosition(){
        return selectedPosition;
    }


    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view = convertView;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_city, parent, false);
        }

        City city = cities.get(position);
        TextView movieName = view.findViewById(R.id.textCityName);
        TextView movieYear = view.findViewById(R.id.textCityProvince);

        movieName.setText(city.getName());
        movieYear.setText(city.getProvince());


        // Change the color of the selected city
        if (selectedPosition == position){
            view.setBackgroundColor(Color.LTGRAY);

        } else {
            view.setBackgroundColor(Color.TRANSPARENT);
        }

        return view;
    }


}
