package com.example.agvenegas.prueba4;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.agvenegas.prueba4.entities.TestList;
import com.example.agvenegas.prueba4.utils.Constants;
import com.example.agvenegas.prueba4.utils.SessionInfo;

import org.w3c.dom.Text;

public class Fragment3 extends Fragment {

    public ImageView detail_icon = null;
    public TextView detail_name = null;
    public TextView detail_age = null;
    public TextView detail_hometown = null;
    public TestList test_list = null;

    public Fragment3() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.third_fragment, container, false);
        detail_icon = (ImageView) view.findViewById(R.id.detail_icon);
        detail_name = (TextView) view.findViewById(R.id.detail_name);
        detail_age = (TextView) view.findViewById(R.id.detail_age);
        detail_hometown = (TextView) view.findViewById(R.id.detail_hometown);
        return view;
    }

    private void setIcon() {
        switch (this.test_list.getImageID()) {
            case TestList.android_icon:
                this.detail_icon.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));
                break;

            case TestList.firefox_icon:
                this.detail_icon.setImageDrawable(getResources().getDrawable(R.drawable.firefox_noshadow));
                break;

            default:
                this.detail_icon.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));
                break;
        }
    }

    private void setPersonData() {
        this.setIcon();

        if (!this.test_list.getName().equalsIgnoreCase(Constants.EMPTY_STRING)) {
            this.detail_name.setText(getString(R.string.name, this.test_list.getName()));
            this.detail_name.setVisibility(View.VISIBLE);
        }

        if (!this.test_list.getAge().equalsIgnoreCase(Constants.EMPTY_STRING)) {
            this.detail_age.setText(getString(R.string.age, this.test_list.getAge()));
            this.detail_age.setVisibility(View.VISIBLE);
        }

        if (!this.test_list.getHometown().equalsIgnoreCase(Constants.EMPTY_STRING)) {
            this.detail_hometown.setText(getString(R.string.hometown, this.test_list.getHometown()));
            this.detail_hometown.setVisibility(View.VISIBLE);
        }

    }

    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).setActionBarTitle(getString(R.string.fragment_title_3));
    }
}
