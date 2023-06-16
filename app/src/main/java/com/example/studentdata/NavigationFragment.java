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

    TextView textView, textView2, textView3, textView4, textView5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        textView = (TextView) view.findViewById(R.id.nametext);
        textView2 = (TextView) view.findViewById(R.id.datetext);
        textView3 = (TextView) view.findViewById(R.id.gendertext);
        textView4 = (TextView) view.findViewById(R.id.grouptext);
//        textView5 = (TextView) view.findViewById(R.id.collegetext);
        String getArgument = getArguments().getString("username");
        String getArgument2 = getArguments().getString("dateofbirth");
        String getArgument3 = getArguments().getString("value");
        String getArgument4 = getArguments().getString("course");
//        String getArgument5 = getArguments().getString("location");
        textView.setText(getArgument);
        textView2.setText(getArgument2);
        textView3.setText(getArgument3);
        textView4.setText(getArgument4);
//        textView5.setText(getArgument5);


        return view;


    }

}