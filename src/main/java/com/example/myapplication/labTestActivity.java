package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class labTestActivity extends AppCompatActivity {
private String[][] packages =
        {
                {"package 1 : Full Body Checkup","","","","999"},
                {"package 2 : Full Body Checkup","","","","999"},
                {"package 3 : Full Body Checkup","","","","999"},
                {"package 4 : Full Body Checkup","","","","999"},
                {"package 5 : Full Body Checkup","","","","999"},
        };
private String[] package_details = {
        "Blood Glucose Fasting\n" +
                "HbA1c\n"+
                " Iron Studies\n"+
                "Kidney Function Test\n"+
                "LDH Lactate Dehydrogenase,serum\n"+
                "Lipid Profile\n"+
                "Liver Function Test",
        "Blood Glucose fasting",
        "Covide-19 Antibody- IgG",
        "Thyroid Profile-Total (T3, T4 & TSHH Ultra-sensitive) ",
        "Complete Hemogram\n"+
                "CRP (C Reactive Protein) Quantitative, Serum\n"+
                " Iron Studies\n"+
                "Kidney Function Test\n"+
                "LDH Lactate Dehydrogenase,serum\n"+
                "Lipid Profile\n"+
                "Liver Function Test"

};

HashMap<String,String>item;
ArrayList list;
SimpleAdapter sa;
Button btnGoToCart,btnBack;
ListView listview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);


        btnGoToCart = findViewById(R.id.gotocartdetails);
        btnBack = findViewById(R.id.backButoonDltails);
        listview = findViewById(R.id.Dllist);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(labTestActivity.this,HomeActivity.class));

            }
        });

        list = new ArrayList();
        for(int i = 0; i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e} );


        ListView lst = findViewById(R.id.Dllist);
        listview.setAdapter(sa);

listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Intent it = new Intent(labTestActivity.this, labTestDetailsActivity.class);
        it.putExtra("text1",packages[i][0]);
        it.putExtra("text2",package_details[i]);
        it.putExtra("text3",packages[i][4]);
        startActivity(it);

    }
});





    }
}
