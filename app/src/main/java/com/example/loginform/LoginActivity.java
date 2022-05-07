package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {
EditText edtUserLog;
EditText edtPassLog;
    MaterialButton btnLog;//ورود
    MaterialButton btnPhone;//شماره تماس
    MaterialButton btnForget;//فراموشی رمز
    MaterialButton btnAdmin_login;//ورود مدیر
    MaterialButton btn_reg;//ثبت

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUserLog=findViewById(R.id.login_username);
        edtPassLog=findViewById(R.id.login_password);
        btnLog=findViewById(R.id.login_btn_log);
        btnPhone=findViewById(R.id.login_btn_phone);
        btnForget=findViewById(R.id.login_btn_forget);
        btnAdmin_login=findViewById(R.id.login_btn_admin_login);
        btn_reg=findViewById(R.id.login_btn_reg);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,SignupActivity.class);
                startActivity( intent);

            }
        });
        btnForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,ForgetPasswordActivity.class);
                startActivity( intent);

            }
        });
        btnAdmin_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,AdminLoginActivity.class);
                startActivity( intent);

            }
        });
      btnLog.setOnClickListener(new View.OnClickListener() {

          @Override
          public void onClick(View v) {

              String edtUserLogText =edtUserLog.getText().toString();
              String edtPassLogText =edtPassLog.getText().toString();

              if (edtUserLogText.length()<=3){
                  showToast("نام کاربری می بایست بیشتر از ۳ کاراکتر باشد");
              }else if (edtPassLogText.length()<=3){
                  showToast("کلمه عبور شما می بایست بیشتر از ۳ کاراکتر باشد");
              }else {
                  Intent intent=new Intent(LoginActivity.this,UserManageActivity.class);
                  startActivity( intent);

              }



          }


      });

        btnPhone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = "http://www.google.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }


        });
    }


    private void showToast(String  text){

        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

}