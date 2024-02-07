package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

       CardView exit = findViewById(R.id.cardFABack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctorActivity.this, HomeActivity.class));
            }
        });


        CardView FAMILYPHYSICIANS = findViewById(R.id.cardFAphysicians);
        FAMILYPHYSICIANS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(FindDoctorActivity.this,DoctorDetailsActivity3.class);
                it.putExtra("title","FAMILY PHYSICIANS");
                startActivity(it);            }
        });



        CardView ditetician = findViewById(R.id.cardFADietician);
        ditetician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity3.class);
                it.putExtra("title","Dietician");
                startActivity(it);

            }
        });


        CardView Dentist = findViewById(R.id.cardFADentist);
        Dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity3.class);
                it.putExtra("title","Dentist");
                startActivity(it);

            }
        });


        CardView surgeon = findViewById(R.id.FASurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity3.class);
                it.putExtra("title","surgeon");
                startActivity(it);

            }
        });


        CardView diologists = findViewById(R.id.cardFACardiologist);
        diologists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity3.class);
                it.putExtra("title","diologists");
                startActivity(it);

            }
        });

    }
}