package com.example.agvenegas.prueba4;

import android.content.pm.PackageInstaller;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.agvenegas.prueba4.adapters.MyCustomArrayAdapter;
import com.example.agvenegas.prueba4.entities.TestList;
import com.example.agvenegas.prueba4.utils.SessionInfo;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {

    public ListView lista;
    protected SessionInfo session = null;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Indicates fragment has menu
        this.setHasOptionsMenu(true);
        this.session = SessionInfo.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.second_fragment, container, false);

        lista = (ListView) view.findViewById(R.id.listView_secondFragment);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Construct the data source
        ArrayList<TestList> arrayOfUsers = session.getTestList();
        // Create the adapter to convert the array to views
        MyCustomArrayAdapter adapter = new MyCustomArrayAdapter(getActivity(), arrayOfUsers);
        // Attach the adapter to a ListView
//        lista.setAdapter(adapter);

//        // Add item to adapter
//        arrayOfUsers newUser = new arrayOfUsers(R.drawable.ic_launcher, "Luis", "20", "Costa Rica");
//        TestList newUser2 = new TestList(R.drawable.firefox_noshadow, "Ana", "30", "España");
//        TestList newUser3 = new TestList(R.drawable.firefox_noshadow, "María", "40", "Guatemala");
//        adapter.add(newUser);
//        adapter.add(newUser2);
//        adapter.add(newUser3);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                int itemPosition = position;
//
//                if (itemPosition == 0){
//                    ((MainActivity)getActivity()).startNewFragment(new Fragment1());
//                } else if (itemPosition == 1) {
//                    ((MainActivity)getActivity()).startNewFragment(new Fragment3());
//                } else {
//                    Toast.makeText(getActivity(), "no posee detalle", Toast.LENGTH_LONG).show();
//                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_opt_location) {
            ((MainActivity)getActivity()).startNewFragment(new Fragment4());
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
