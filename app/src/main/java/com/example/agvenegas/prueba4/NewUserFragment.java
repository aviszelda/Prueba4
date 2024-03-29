package com.example.agvenegas.prueba4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agvenegas.prueba4.entities.TestList;
import com.example.agvenegas.prueba4.utils.SessionInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewUserFragment extends Fragment {

    public TextView text_name;
    public TextView text_age;
    public TextView text_hometown;
    public EditText edit_text_name;
    public EditText edit_text_age;
    public EditText edit_text_hometown;
    public Button fill_button;

    public TextView gender;
    public Spinner spinner_gender;
    public String gender_selected;

    public Random random = new Random();
    protected SessionInfo session = null;

    protected String name;
    protected String age;
    protected String hometown;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.new_user_layout, container, false);

        session = SessionInfo.getInstance();

        text_name = (TextView) view.findViewById(R.id.text_name);
        text_age = (TextView) view.findViewById(R.id.text_age);
        text_hometown = (TextView) view.findViewById(R.id.text_hometown);

        edit_text_name = (EditText) view.findViewById(R.id.edit_text_name);
        edit_text_age = (EditText) view.findViewById(R.id.edit_text_age);
        edit_text_hometown = (EditText) view.findViewById(R.id.edit_text_hometown);

        gender = (TextView) view.findViewById(R.id.gender);
        spinner_gender = (Spinner) view.findViewById(R.id.spinner_gender);

        final List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Hombre");
        spinnerArray.add("Mujer");
        spinnerArray.add("Seleccione un Género");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_gender.setAdapter(adapter);

        spinner_gender.setSelection(adapter.getCount() - 1); //display hint

        spinner_gender.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                spinnerArray.remove("Seleccione un Género");
                return false;
            }
        });

        fill_button = (Button) view.findViewById(R.id.fill_button);

        fill_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = edit_text_name.getText().toString();
                age = edit_text_age.getText().toString();
                hometown = edit_text_hometown.getText().toString();

                gender_selected = spinner_gender.getSelectedItem().toString();

                if (name.matches("") | age.matches("") | hometown.matches("") | gender_selected.matches("Seleccione un Género")) {

                    Toast.makeText(getActivity(), "Por favor complete el formulario", Toast.LENGTH_SHORT).show();

                } else {

                    //Random number for the icon
                    int icon = random.nextInt(5 - 1) + 1;

                    // Add item to adapter
                    TestList newUser = new TestList(icon, name, age, hometown, gender_selected);
                    session.getTestList().add(newUser);

                    ((MainActivity) getActivity()).startNewFragment(new UserListFragment());
                }
            }
        });

        return view;
    }

    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).setActionBarTitle(getString(R.string.fragment_title_4));
    }
}
