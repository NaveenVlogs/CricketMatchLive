package com.cricket.match.live.pack1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.cricket.match.live.pack1.Fragment_Bottom.Account_Fragment;
import com.cricket.match.live.pack1.Fragment_Bottom.Cart_Fragment;
import com.cricket.match.live.pack1.Fragment_Bottom.Home_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
 BottomNavigationView bottom_navigation;
 NavigationView top_navigation;
 DrawerLayout drayerlayout;
 ActionBarDrawerToggle toggle;
 Toolbar toolbar;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottom_navigation= findViewById(R.id.bottom_navigation);
        top_navigation= findViewById(R.id.top_navigation);
        drayerlayout= findViewById(R.id.drayerlayout);
        toolbar = findViewById(R.id.toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setSupportActionBar(toolbar);


        toggle = new ActionBarDrawerToggle(this,drayerlayout,toolbar,R.string.open,R.string.close);
        drayerlayout.addDrawerListener(toggle);
        toggle.syncState();

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        top_navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.about_us1){
                    Toast.makeText(HomeActivity.this, "selected", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),About_Us_Activity.class);
                    startActivity(intent);

                }

                if (item.getItemId()==R.id.home_menu){
                    Toast.makeText(HomeActivity.this, "selected", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),CreateTeamActivity.class);
                    startActivity(intent);
                }
                if (item.getItemId()==R.id.term1){
                    Toast.makeText(HomeActivity.this, "selected", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Term_Condition_Activity.class);
                    startActivity(intent);
                }
                if (item.getItemId()==R.id.uploadvideo){
                    Toast.makeText(HomeActivity.this, "video clicled", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),SecurityActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });




//        getSupportFragmentManager().beginTransaction().replace(R.id.framlayout1,temp).commit();

        getSupportFragmentManager().beginTransaction().replace(R.id.framlayout1,new Home_Fragment()).commit();




        bottom_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        Fragment temp = null;

                switch (item.getItemId()){

                    case R.id.home1: temp = new Home_Fragment();
                        break;
                    case R.id.cart1: temp = new Cart_Fragment();
                        break;
                    case R.id.account1: temp = new Account_Fragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framlayout1,temp).commit();

                return true;
            }
        });
    }
}