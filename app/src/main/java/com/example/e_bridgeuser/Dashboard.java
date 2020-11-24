package com.example.e_bridgeuser;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.e_bridgeuser.developers.DeveloperActivity;
import com.example.e_bridgeuser.ebook.EbookActivity;
import com.example.e_bridgeuser.website.WebsiteActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    NavController navController;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this, R.id.frame_layout);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigationView);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.end);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //can provoke null pointer exception
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);


        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.website) {
            Intent intent = new Intent(getApplicationContext(), WebsiteActivity.class);
            startActivity(intent);
            // Toast.makeText(this, "Website", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.developers) {
            Intent intent = new Intent(getApplicationContext(), DeveloperActivity.class);
            startActivity(intent);
            //   Toast.makeText(this, "Developer", Toast.LENGTH_SHORT).show();


        } else if (item.getItemId() == R.id.ebook) {
            Intent intent = new Intent(getApplicationContext(), EbookActivity.class);
            startActivity(intent);

        } else {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
        //Toast.makeText(this, "Ebook", Toast.LENGTH_SHORT).show();


        return true;
    }
}