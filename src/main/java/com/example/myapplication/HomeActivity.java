package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "Welcome To Our Healthcare App", Toast.LENGTH_SHORT).show();

        CardView exit = findViewById(R.id.cardExit);
       exit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               SharedPreferences.Editor editor = sharedPreferences.edit();
               editor.clear();
               editor.apply();
               startActivity(new Intent(HomeActivity.this,loginActivity.class));

           }
       });

            CardView findDoctor = findViewById(R.id.cardFindDoctor);
            findDoctor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(HomeActivity.this,FindDoctorActivity.class));
                }
            });

        CardView labTest = findViewById(R.id.cardLabTest);
        labTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,labTestActivity.class));
            }
        });



    }
}