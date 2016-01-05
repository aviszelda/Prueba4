package com.example.agvenegas.prueba4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.agvenegas.prueba4.adapters.MyCustomArrayAdapter;
import com.example.agvenegas.prueba4.entities.TestList;
import com.example.agvenegas.prueba4.utils.SessionInfo;

import java.util.ArrayList;
import java.util.Random;

public class UserListFragment extends Fragment {

    public ListView lista;
    protected SessionInfo session = null;

    public UserListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Indicates fragment has menu
        this.setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.user_list_layout, container, false);
        session = SessionInfo.getInstance();

        lista = (ListView) view.findViewById(R.id.listView_secondFragment);

        // Construct the data source
        ArrayList<TestList> arrayOfUsers = session.getTestList();

        //test user for be beginning
        if (arrayOfUsers.isEmpty()) {
            TestList newUser = new TestList(1, "Prueba", "30", "San José");
            session.getTestList().add(newUser);
        }

        // Create the adapter to convert the array to views
        MyCustomArrayAdapter adapter = new MyCustomArrayAdapter(getActivity(), arrayOfUsers);
        // Attach the adapter to a ListView
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int itemPosition = position;

                if (itemPosition == 0){
                    ((MainActivity)getActivity()).startNewFragment(new DetailUserFragment());
                } else {
                    Toast.makeText(getActivity(), "no posee detalle", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_opt_location) {
            ((MainActivity)getActivity()).startNewFragment(new NewUserFragment());
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.list_items, menu);
    }

    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).setActionBarTitle(getString(R.string.fragment_title_2));
    }
}
