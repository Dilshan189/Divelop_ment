package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4;
TextView tv;
private DatePickerDialog dataPickerDialog;
private TimePickerDialog timePickerDialog;
private Button dateButton,timeButoon,btnBook,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        tv = findViewById(R.id.textbookapointmant);
        ed1 = findViewById(R.id.editTextfullnameBook);
        ed2 = findViewById(R.id.editTextAddressBook);
        ed3 = findViewById(R.id.editTextContactnumBook);
        ed4 = findViewById(R.id.editTextFeesBook);
        dateButton = findViewById(R.id.button1book);
        timeButoon = findViewById(R.id.button2book);
        btnBook = findViewById(R.id.buttonregisterbook);
        btnBack = findViewById(R.id.buttonbookback);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String fullname = it.getStringExtra("text2");
        String address = it.getStringExtra("text3");
        String contact = it.getStringExtra("text4");
        String fees = it.getStringExtra("text5");

        tv.setText(title);
        ed1.setText(fullname);
        ed2.setText(address);
        ed3.setText(contact);
        ed4.setText("cons fees:" + fees + "/-");

        //datapicker
        initDataPicker();

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataPickerDialog.show();
            }
        });

        //timepicker

        initTimePicker();

        timeButoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookAppointmentActivity.this,FindDoctorActivity.class));
            }
        });


        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }



        private void initDataPicker() {
            DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    i1 = i1 + 1;
                    dateButton.setText(i2+"/"+i1+"/"+i);

                }
            };
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int Month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);


            int Style = AlertDialog.THEME_HOLO_DARK;
            dataPickerDialog = new DatePickerDialog(this, Style, dateSetListener, year, Month, day);
            dataPickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis() + 86400000);




    }

    private void initTimePicker(){

        TimePickerDialog.OnTimeSetListener  timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {

            }
        };

        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR);
        int mins = cal.get(Calendar.MINUTE);

        int style = AlertDialog.THEME_HOLO_DARK;
        timePickerDialog = new  TimePickerDialog(this,style,timeSetListener,hrs,mins,true);
        dataPickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis() + 86400000);



    }
}