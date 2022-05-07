package com.example.loginform;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;

public class ProfileActivity extends AppCompatActivity {
    TextView username;
    TextView email;
    MaterialButton btn_edit;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        username=findViewById(R.id.profile_username);
        email=findViewById(R.id.profile_email);
        drawerLayout=findViewById(R.id.activity_profile_drawer_layout);
        navigationView=findViewById(R.id.activity_profile_nav_view);
        btn_edit=findViewById(R.id.profile_btn_edit);


        setupToolbar("صفحه پروفایل");
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProfileActivity.this,UserManageActivity.class);
                startActivity( intent);

            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){



                    case R.id.menu_btn_profile:{
                        Intent intent=new Intent(ProfileActivity.this,ProfileActivity.class);
                        startActivity(intent);
                        return true;
                    }

                    case R.id.menu_btn_dashboard:{
                        Intent intent=new Intent(ProfileActivity.this,DashboardActivity.class);
                        startActivity(intent);
                        return true;
                    }



                    case R.id.menu_btn_status:{
                        Intent intent=new Intent(ProfileActivity.this,UserManageActivity.class);
                        startActivity(intent);
                        return true;
                    }

                    case R.id.menu_btn_exit_page:{
                        onBackPressed();
                        return true;
                    }

                    case R.id.menu_btn_exit:{
                        finishAffinity();
                    }
                }


                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:{
                drawerLayout.openDrawer(GravityCompat.START);

                return true;
            }

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setupToolbar(String  title){
        toolbar = (Toolbar) findViewById(R.id.activity_profile_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar =getSupportActionBar();

        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        // toolbar.setHomeButtonEnabled(true);
        // toolbar.setDisplayHomeAsUpEnabled(true);


        toolbar.setTitle(title);
    }
}