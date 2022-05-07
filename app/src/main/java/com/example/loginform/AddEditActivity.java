package com.example.loginform;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;

public class AddEditActivity extends AppCompatActivity {
EditText name;
EditText codeMelli;
EditText phone;
Button ok;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);
        name=findViewById(R.id.add_edit_name);
        codeMelli=findViewById(R.id.add_edit_code_melli);
        phone=findViewById(R.id.add_edit_phone);
        ok=findViewById(R.id.add_edit_ok);

        toolbar = findViewById(R.id.toolbar_add_edit);

        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        
        
        
        ok.setOnClickListener(v -> {
            Intent intent=new Intent(AddEditActivity.this,UserManageActivity.class);
            startActivity( intent);

        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:{
              onBackPressed();
                return true;
            }

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}