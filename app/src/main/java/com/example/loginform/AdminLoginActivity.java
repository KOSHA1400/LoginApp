package com.example.loginform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class AdminLoginActivity extends AppCompatActivity {
EditText edtUsername;
EditText edtPass;
    MaterialButton admin_reg;
    Button login_forget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        edtUsername=findViewById(R.id.admin_login_username) ;
          edtPass=findViewById(R.id.admin_login_password);
        admin_reg=findViewById(R.id.admin_login_admin_reg);
        login_forget=findViewById(R.id.admin_login_forget) ;
        login_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminLoginActivity.this,ForgetPasswordActivity.class);
                startActivity( intent);

            }
        });
        admin_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminLoginActivity.this,DashboardActivity.class);
                startActivity( intent);

            }
        });
    }
}