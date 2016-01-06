package com.example.agvenegas.prueba4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.agvenegas.prueba4.entities.TestList;
import com.example.agvenegas.prueba4.utils.SessionInfo;

public class DetailUserFragment extends Fragment {

    public ImageView icon_detail_layout = null;
    public TextView detail_name = null;
    public TextView detail_age = null;
    public TextView detail_hometown = null;

    protected SessionInfo session = null;

    public DetailUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.detail_user_layout, container, false);

        session = SessionInfo.getInstance();

        icon_detail_layout = (ImageView) view.findViewById(R.id.icon_detail_layout);
        detail_name = (TextView) view.findViewById(R.id.detail_name);
        detail_age = (TextView) view.findViewById(R.id.detail_age);
        detail_hometown = (TextView) view.findViewById(R.id.detail_hometown);

        setUserData();

        return view;
    }

    private void setUserData() {

        if (SessionInfo.selected_user == 0) {

            detail_name.setText(getString(R.string.detail_name, session.getTestList().get(0).getName()));
            detail_name.setVisibility(View.VISIBLE);
            detail_age.setText(getString(R.string.detail_age, session.getTestList().get(0).getAge()));
            detail_age.setVisibility(View.VISIBLE);
            detail_hometown.setText(getString(R.string.detail_hometown, session.getTestList().get(0).getHometown()));
            detail_hometown.setVisibility(View.VISIBLE);
        }
    }

    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).setActionBarTitle(getString(R.string.fragment_title_3));
        setUserData();
    }
}
