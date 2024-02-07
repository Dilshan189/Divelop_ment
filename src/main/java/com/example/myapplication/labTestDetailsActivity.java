package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class labTestDetailsActivity extends AppCompatActivity {
TextView tvPackageName,tvTotalCost;
EditText edDetails;
Button btnAddToCart,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

    tvPackageName = findViewById(R.id.textde2de);
    tvTotalCost = findViewById(R.id.textView3detai);
    edDetails = findViewById(R.id.editTextTextMultiLine);
    btnAddToCart = findViewById(R.id.gotocartdetails);
    btnBack = findViewById(R.id.backButoonDltails);


        edDetails.setKeyListener(null);

         Intent intent=getIntent();
         tvPackageName.setText(intent.getStringExtra("tex1"));
        edDetails.setText(intent.getStringExtra("tex1"));
        tvTotalCost.setText("Total Cost:"+intent.getStringExtra("tex1")+"/-");


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(labTestDetailsActivity.this, labTestActivity.class));
            }
        });


        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}