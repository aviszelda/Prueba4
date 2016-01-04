package com.example.agvenegas.prueba4;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.agvenegas.prueba4.adapters.MyCustomArrayAdapter;
import com.example.agvenegas.prueba4.entities.TestList;

import java.util.ArrayList;

public class Fragment4 extends Fragment {

    public TextView text_name;
    public TextView text_age;
    public TextView text_hometown;
    public EditText edit_text_name;
    public EditText edit_text_age;
    public EditText edit_text_hometown;
    public Button fill_button;

    protected String name;
    protected String age;
    protected String hometown;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.four_fragment, container, false);

        text_name = (TextView) view.findViewById(R.id.text_name);
        text_age = (TextView) view.findViewById(R.id.text_age);
        text_hometown = (TextView) view.findViewById(R.id.text_hometown);

        edit_text_name = (EditText) view.findViewById(R.id.edit_text_name);
        edit_text_age = (EditText) view.findViewById(R.id.edit_text_age);
        edit_text_hometown = (EditText) view.findViewById(R.id.edit_text_hometown);

        fill_button = (Button) view.findViewById(R.id.fill_button);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        fill_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edit_text_name.getText().toString();
                age = edit_text_age.getText().toString();
                hometown = edit_text_hometown.getText().toString();
                Log.i("campos ","prueba "+ name + " " + age + " " + hometown);

                ((MainActivity)getActivity()).startNewFragment(new Fragment2());
            }
        });
    }

    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).setActionBarTitle(getString(R.string.fragment_title_4));
    }
}
