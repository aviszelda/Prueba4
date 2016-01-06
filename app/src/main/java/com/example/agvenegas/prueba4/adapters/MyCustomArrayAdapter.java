package com.example.agvenegas.prueba4.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.agvenegas.prueba4.R;
import com.example.agvenegas.prueba4.entities.TestList;

import java.util.ArrayList;
import java.util.List;

public class MyCustomArrayAdapter extends ArrayAdapter<TestList>{

    public MyCustomArrayAdapter(Context context, ArrayList<TestList> testLists) {
        super(context, 0, testLists);
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_adapter, parent, false);
        }
        // Get the data item for this position
        TestList testList = getItem(position);

        if (testList != null) {

            // Lookup view for data population
            ImageView iconID = (ImageView) convertView.findViewById(R.id.iconID);
            TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
            TextView tvAge = (TextView) convertView.findViewById(R.id.tvAge);
            TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
            // Populate the data into the template view using the data object
            if (iconID != null) {
                iconID.setImageResource(setIcon(testList.getImageID()));
            }
            if (tvName != null) {
                tvName.setText("Nombre: "+testList.getName());
            }
            if (tvAge != null) {
                tvAge.setText("Edad: " + testList.getAge() +" años");
            }
            if (tvHome != null) {
                tvHome.setText("País de Origen: "+testList.getHometown());
            }
        }
        // Return the completed view to render on screen
        return convertView;
    }

    public static int setIcon(int detail_icon) {

        switch (detail_icon) {
            case 1:
                detail_icon = R.drawable.ic_launcher;
                break;
            case 2:
                detail_icon = R.drawable.firefox_noshadow;
                break;
            case 3:
                detail_icon = R.drawable.example_1;
                break;
            case 4:
                detail_icon = R.drawable.example_2;
                break;
            case 5:
                detail_icon = R.drawable.example_3;
                break;
            default:
                detail_icon = R.drawable.ic_launcher;
                break;
        }
        return detail_icon;
    }
}