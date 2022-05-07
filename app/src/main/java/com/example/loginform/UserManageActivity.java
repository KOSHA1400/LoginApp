package com.example.loginform;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class  UserManageActivity extends AppCompatActivity {

Toolbar toolbar;
FloatingActionButton mFab;
DrawerLayout drawerLayout;
NavigationView navigationView;
RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manage);
        mFab=findViewById(R.id.fab);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.activity_user_manage_nav_view);
        recyclerView=findViewById(R.id.recycler);

        setupRecycler();

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UserManageActivity.this,AddEditActivity.class);
                startActivity(intent);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){



                    case R.id.menu_btn_profile:{
                        Intent intent=new Intent(UserManageActivity.this,ProfileActivity.class);
                        startActivity(intent);
                        return true;
                    }

                    case R.id.menu_btn_dashboard:{
                        Intent intent=new Intent(UserManageActivity.this,DashboardActivity.class);
                        startActivity(intent);
                        return true;
                    }



                    case R.id.menu_btn_status:{
                        Toast.makeText(UserManageActivity.this,"شما در صفحه مشتریان می باشید",Toast.LENGTH_SHORT).show();
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

       // toolbar =getSupportActionBar();


      setupToolbar("صفحه اصلی");




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

   private void setupRecycler(){
       ArrayList<User> users =new ArrayList<>();
        User user1 =new User("nazanin.abdi@gmail.com","nazi");
        User user2 =new User("zara32@gmail.com","zahra");
        User user3 =new User("kosha.mag@gmail.com","fatemeh");
        User user4 =new User("zinab.moradi48@gmail.com","zinab");
        User user5=new User("nakl.35@gmail.com","narges");
        User user6=new User("hana.ert8@gmail.com","hana");
        User user7=new User("mona32@gmail.com","mona");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);

        MyRecyclerAdapter adapter =new MyRecyclerAdapter(this ,users);


       recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
           @Override
           public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
               super.onScrolled(recyclerView, dx, dy);
               if (dy > 0 && mFab.getVisibility() == View.VISIBLE) {
                   mFab.hide();
               } else if (dy < 0 && mFab.getVisibility() !=View.VISIBLE) {
                   mFab.show();
               }
           }
       });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
       recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


    }

   public void setupToolbar(String  title){
        toolbar = (Toolbar) findViewById(R.id.activity_user_manage_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar =getSupportActionBar();

        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        // toolbar.setHomeButtonEnabled(true);
        // toolbar.setDisplayHomeAsUpEnabled(true);


        toolbar.setTitle(title);
    }
}