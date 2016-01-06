package com.example.agvenegas.prueba4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

public class Fragment1 extends Fragment {

    public Button button_to_fragment = null;
    public ImageView fragment_1_image;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1_layout, container, false);
        fragment_1_image = (ImageView) view.findViewById(R.id.fragment_1_image);
        button_to_fragment = (Button) view.findViewById(R.id.button_to_fragment);
        button_to_fragment.setOnClickListener(this.fragment_1);

        Picasso.with(getActivity())
                .load("http://findicons.com/files/icons/820/simply_google/256/google_android.png")
                .into(fragment_1_image);

        return view;
    }

    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).setActionBarTitle(getString(R.string.fragment_title_1));
    }

    private View.OnClickListener fragment_1 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            ((MainActivity)getActivity()).startNewFragment(new UserListFragment());
        }
    };
}

