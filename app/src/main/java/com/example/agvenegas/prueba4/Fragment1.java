package com.example.agvenegas.prueba4;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.agvenegas.prueba4.utils.Constants;
import com.squareup.picasso.Picasso;

public class Fragment1 extends Fragment implements LocationListener {

    public Button button_to_fragment = null;
    public ImageView fragment_1_image;
    /** Manage User current location */
    protected LocationManager locationManager = null;
    /** Set time value for refresh user location */
    protected int refresh_time = (1000 * 60 * 10); // 10 minutes
    /** Set distance criteria for update location */
    protected int distance_criteria = 1000; // 1KM

    // Location provided by network connection
    public Location networkLocation = null;


    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1_layout, container, false);
        fragment_1_image = (ImageView) view.findViewById(R.id.fragment_1_image);
        button_to_fragment = (Button) view.findViewById(R.id.button_to_fragment);
        button_to_fragment.setOnClickListener(this.fragment_1);

        Picasso.with(getActivity()).load(Constants.FRAGMENT_1_IMAGE).into(fragment_1_image);

        return view;
    }

    public Location checkWIFI() {

        if(isOnline()) {

            if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, refresh_time, distance_criteria, this);
                // Get location from the network
                networkLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                Toast.makeText(getActivity(), "Está conectado", Toast.LENGTH_SHORT).show();
            }

        } else {

            Toast.makeText(getActivity(), "No posee conexión a internet", Toast.LENGTH_SHORT).show();
        }

        return networkLocation;
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).setActionBarTitle(getString(R.string.fragment_title_1));
    }

    private View.OnClickListener fragment_1 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            checkWIFI();
            ((MainActivity)getActivity()).startNewFragment(new UserListFragment());
        }
    };

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}

