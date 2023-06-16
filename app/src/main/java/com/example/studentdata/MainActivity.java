package com.example.studentdata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener,NavigationProfileSubmit {
    BottomNavigationView bottomNavigationView;

    NavigationFragment navigatinFragment;
FrameLayout frameLayout;
    HomeFragment homeFragment;
    String username;
    String dateofbirth;
    String value;
    String course;
    String location;


    @SuppressLint({"MissingInflatedId", "SuspiciousIndentation"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      homeFragment=new HomeFragment(MainActivity.this);
        getSupportFragmentManager().beginTransaction().add(R.id.flFragment, new HomeFragment()).commit();
        bottomNavigationView = findViewById(R.id.BottomNavigationView);
        frameLayout=findViewById(R.id.flFragment);
        bottomNavigationView.setOnItemSelectedListener(this);
        navigatinFragment = new NavigationFragment();
      ;


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flFragment, homeFragment)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, homeFragment)
                    .commit();
        } else if (item.getItemId() == R.id.profile) {
            Bundle data=new Bundle();
            data.putString("username",username);
            data.putString("dateofbirth",dateofbirth);
            data.putString("value",value);
            data.putString("course",course);
            data.putString("location",location);
            navigatinFragment.setArguments(data);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, navigatinFragment)
                    .commit();

        }

        return false;
    }


    @Override
    public void callBackMethod() {

    }

    @Override
    public void onDataReceived(String s, String dob, String gender, String group, String college) {
        Log.e("TAG", s+","+dob+","+gender+","+group+","+college+",");
        username=s;
        dateofbirth=dob;
        value=gender;
        course=group;
        location=college;

    }
}