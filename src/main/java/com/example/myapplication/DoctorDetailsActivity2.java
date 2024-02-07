package com.example.myapplication;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DoctorDetailsActivity2 extends AppCompatActivity {

    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},



            };

    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},



            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},



            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},



            };
    private String[][] doctor_details5=
            {
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},
                    {"Doctor Name : Ajith Saste","Hospital Address : Pimpri","Exp: 5yrs","Mobile No : 0782059057","600"},



            };
    TextView tv;
    Button btn;

    String[][] getDoctor_details1 = {};
    ArrayList list;
    SimpleAdapter sa;

     HashMap<String,String> item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details2);


        tv=findViewById(R.id.textddfault);

        Intent it = getIntent();
        String title= it.getStringExtra("title");
        tv.setText(title);



        Button fa = findViewById(R.id.BackButoon);
        fa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(DoctorDetailsActivity2.this,FindDoctorActivity.class);
                it.putExtra("title","FAMILY PHYSICIANS");
                startActivity(it);
            }
        });

        if(title.compareTo("Family Physicians")==0)
            doctor_details1 = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details1 = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details1 = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details1 = doctor_details4;
        else
            doctor_details1 = doctor_details5;






        list = new ArrayList();
        for(int i = 0; i<doctor_details1.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_details1[i][0]);
            item.put("line2",doctor_details1[i][1]);
            item.put("line3",doctor_details1[i][2]);
            item.put("line4",doctor_details1[i][3]);
            item.put("line5","Cons Fees:"+doctor_details1[i][4]+"/-");
            list.add(item);


        }

        sa = new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},
       new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e} );


        ListView lst = findViewById(R.id.ddlistView);
        lst.setAdapter(sa);


    }
}