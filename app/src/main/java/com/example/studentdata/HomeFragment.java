package com.example.studentdata;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class HomeFragment extends Fragment {

    NavigationProfileSubmit navigationProfileSubmit;

    public HomeFragment(NavigationProfileSubmit navigationProfileSubmit) {
        this.navigationProfileSubmit = navigationProfileSubmit;
    }


    View view;
    EditText edittext, editText2;
    String gender;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle);
        List<Item> items = new ArrayList<>();
        items.add(new Item("NGM College"));
        items.add(new Item("MCET College"));
        items.add(new Item("KRISHNA College"));
        items.add(new Item("RATHINAM College"));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new Adapter(getActivity(), items));

        String[] values =
                {"Bsc", "Bcom", "BBA", "Msc", "MBA", "Mcom"};
        Spinner spinner = (Spinner) view.findViewById(R.id.viewlist);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);


        RadioButton radioButton = (RadioButton) view.findViewById(R.id.radiobutton1);
        RadioButton radioButton1 = (RadioButton) view.findViewById(R.id.radiobutton2);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (radioButton.isChecked()) {
                    gender = "male";


                } else if (radioButton1.isChecked()) {
                    gender = "female";

                }
            }

        });

        edittext = (EditText) view.findViewById(R.id.username);
        editText2 = (EditText) view.findViewById(R.id.dateofbirth);
        editText2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        editText2.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                },
                        year, month, day);
                datePickerDialog.show();
            }
        });
        Button button = (Button) view.findViewById(R.id.submitbutton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("username", edittext.getText().toString());
                bundle.putString("dob", editText2.getText().toString());
                bundle.putString("gender", gender);
                bundle.putString("group", spinner.getSelectedItem().toString());
//                bundle.putString("college", String.valueOf(recyclerView.getScrollState()));
                NavigationFragment fragment = new NavigationFragment();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.flFragment, fragment).commit();
                navigationProfileSubmit.onDataReceived(edittext.getText().toString(), editText2.getText().toString(), gender, spinner.getSelectedItem().toString(), String.valueOf(recyclerView.getScrollState()));
                if (navigationProfileSubmit != null) {
                    navigationProfileSubmit.callBackMethod();

                }

            }


        });

        return view;
    }

}

