package com.example.studentdata;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.BreakIterator;

public class NavigationFragment extends Fragment {
    View view;
    public NavigationFragment() {

    }
    TextView textname, textdate, textgender, textgroup, textcollege;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        textname = (TextView) view.findViewById(R.id.nametext);
        textdate = (TextView) view.findViewById(R.id.datetext);
        textgender = (TextView) view.findViewById(R.id.gendertext);
        textgroup = (TextView) view.findViewById(R.id.grouptext);
//      textcollege = (TextView) view.findViewById(R.id.collegetext);
        String getArgumentname = getArguments().getString("username");
        String getArgumentdate = getArguments().getString("dateofbirth");
        String getArgumentgender = getArguments().getString("value");
        String getArgumentgroup = getArguments().getString("course");
//       String getArgumentcollege = getArguments().getString("location");
        textname.setText(getArgumentname);
        textdate.setText(getArgumentdate);
        textgender.setText(getArgumentgender);
        textgroup.setText(getArgumentgroup);
//      textcollege.setText(getArgumentcollege);
        return view;
    }

}