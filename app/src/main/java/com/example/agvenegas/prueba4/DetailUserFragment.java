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

import static com.example.agvenegas.prueba4.adapters.MyCustomArrayAdapter.setIcon;

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

        return view;
    }

    private void setUserData() {
        icon_detail_layout.setImageResource(setIcon(session.getTestList().get(SessionInfo.selected_user).getImageID()));
        detail_name.setText("Nombre: " + session.getTestList().get(SessionInfo.selected_user).getName());
        detail_name.setVisibility(View.VISIBLE);
        detail_age.setText("Edad: " + session.getTestList().get(SessionInfo.selected_user).getAge()+" años");
        detail_age.setVisibility(View.VISIBLE);
        detail_hometown.setText("Ciudad: " + session.getTestList().get(SessionInfo.selected_user).getHometown());
        detail_hometown.setVisibility(View.VISIBLE);
    }

    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.fragment_title_3));
        setUserData();
    }
}
