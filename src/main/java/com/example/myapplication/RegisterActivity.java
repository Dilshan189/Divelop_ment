package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername, edPassword, edEmail, edConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        edUsername = findViewById(R.id.editTextRegUserName);
        edPassword = findViewById(R.id.editTextRegPassword);
        edConfirm = findViewById(R.id.editTextregconfirmPassword);
        edEmail = findViewById(R.id.editTextRegEmail);
        btn = findViewById(R.id.buttonregister);
        tv = findViewById(R.id.textView);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, RegisterActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String Password = edUsername.getText().toString();
                String confirm = edConfirm.getText().toString();
                Database db = new Database(getApplicationContext(),"healthcare",null,1);
                if (username.length()==0 || email.length()==0 || Password.length()==0 || confirm.length()==0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();

                }
                else {
                    if (Password.compareTo(confirm) == 0) {
                        if (isValid(Password)) {
                            db.register(username,email,Password);
                            Toast.makeText(getApplicationContext(), "Record Insert", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, loginActivity.class));
                        }
                       else {
                            Toast.makeText(getApplicationContext(), "Password must Contain at least 8 characters, having letter,digital and Symbol ", Toast.LENGTH_SHORT).show();

                        }


                    } else {
                        Toast.makeText(getApplicationContext(), "Password and ConfirmPassword didn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public static boolean isValid(String Passwordhere) {

        int f1 = 0, f2 = 0, f3 = 0;
        if (Passwordhere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < Passwordhere.length(); p++) {
                if (Character.isLetter(Passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }

            for (int r = 0; r < Passwordhere.length(); r++) {
                if (Character.isLetter(Passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }
            for (int s = 0; s < Passwordhere.length(); s++) {
                if (Character.isLetter(Passwordhere.charAt(s))) {
                    f3 = 1;
                }
            }
            if (f1 == 1 && f2 == 1 && f3 == 1)
                return true;
            return false;
        }
    }
}






