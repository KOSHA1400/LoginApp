package com.example.loginform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class ForgetPasswordActivity extends AppCompatActivity {
EditText edtEmail;
EditText edtPhone;
MaterialButton ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_passwrod);
        edtEmail=findViewById(R.id.forget_pass_email);
        edtPhone=findViewById(R.id.forget_pass_phone);
        ok=findViewById(R.id.forget_pass_ok);



        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ForgetPasswordActivity.this,UserManageActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}