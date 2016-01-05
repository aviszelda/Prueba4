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

import com.example.agvenegas.prueba4.adapters.MyCustomArrayAdapter;
import com.example.agvenegas.prueba4.entities.TestList;
import com.example.agvenegas.prueba4.utils.SessionInfo;

import java.util.ArrayList;

public class UserListFragment extends Fragment {

    public ListView lista;
    protected SessionInfo session = null;

    public TestList test_list = null;

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
        // Add item to adapter
//        TestList newUser = new TestList(1, "Luis", "20", "Costa Rica");
//        session.getTestList().add(newUser);
//        TestList newUser2 = new TestList(2, "Ana", "30", "España");
//        session.getTestList().add(newUser2);
//        TestList newUser3 = new TestList(2, "María", "40", "Guatemala");
//        session.getTestList().add(newUser3);

        // Create the adapter to convert the array to views
        MyCustomArrayAdapter adapter = new MyCustomArrayAdapter(getActivity(), arrayOfUsers);
        // Attach the adapter to a ListView
//        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                int itemPosition = position;
//
//                if (itemPosition == 0){
//                    ((MainActivity)getActivity()).startNewFragment(new Fragment1());
//                } else if (itemPosition == 1) {
//                    ((MainActivity)getActivity()).startNewFragment(new NewUserFragment());
//                } else {
//                    Toast.makeText(getActivity(), "no posee detalle", Toast.LENGTH_LONG).show();
//                }
            }
        });

        return view;
    }

    private int setIcon() {
        int detail_icon = 1;
        switch (test_list.getImageID()) {
            case TestList.android_icon:
                detail_icon = R.drawable.ic_launcher;
                break;

            case TestList.firefox_icon:
                detail_icon = R.drawable.firefox_noshadow;
                break;

            default:
                detail_icon = R.drawable.ic_launcher;
                break;
        }

        return detail_icon;
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
