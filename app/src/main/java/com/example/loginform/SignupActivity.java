package com.example.loginform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class SignupActivity extends AppCompatActivity {
EditText edtEmail;
    EditText edtPhone;
    EditText edtPass;
    EditText edtphone;
    MaterialButton register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edtEmail=findViewById(R.id.signup_user_email);
        edtPhone=findViewById(R.id.signup_phone);
        edtPass=findViewById(R.id.signup_pass);
        register=findViewById(R.id.signup_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignupActivity.this,UserManageActivity.class);
                startActivity( intent);
                finish();


            }
        });
    }
}