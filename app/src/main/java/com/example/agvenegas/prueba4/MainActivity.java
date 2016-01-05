package com.example.agvenegas.prueba4;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.agvenegas.prueba4.adapters.MyCustomArrayAdapter;
import com.example.agvenegas.prueba4.entities.TestList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startNewFragment(new Fragment1());
    }

    public void startNewFragment(Fragment fragment) {
        // Initialize fragment transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace with fragment content
        ft.replace(R.id.main_frame, fragment);
        // Animation on change
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        // Clear stack (back button memory)
        ft.addToBackStack(null);
        ft.commitAllowingStateLoss();
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
