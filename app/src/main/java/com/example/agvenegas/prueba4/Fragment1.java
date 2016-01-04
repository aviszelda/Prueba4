package com.example.agvenegas.prueba4;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.agvenegas.prueba4.utils.SessionInfo;

public class Fragment1 extends Fragment {

    public Button button_to_fragment = null;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set title bar
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.simple_fragment, container, false);
        this.button_to_fragment = (Button) view.findViewById(R.id.button_to_fragment);
        this.button_to_fragment.setOnClickListener(this.fragment_1);
        return view;
    }

    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).setActionBarTitle(getString(R.string.fragment_title_1));
    }

    private View.OnClickListener fragment_1 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            ((MainActivity)getActivity()).startNewFragment(new Fragment2());
        }
    };
}

