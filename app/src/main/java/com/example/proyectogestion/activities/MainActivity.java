package com.example.proyectogestion.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.proyectogestion.fragments.AboutUsFragment;
import com.example.proyectogestion.fragments.AccountFragment;
import com.example.proyectogestion.fragments.DevicesFragment;
import com.example.proyectogestion.fragments.ManualsFragment;
import com.example.proyectogestion.R;
import com.example.proyectogestion.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    DevicesFragment devicesFragment;
    ManualsFragment manualsFragment;
    AccountFragment accountFragment;
    AboutUsFragment aboutUsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
        setListeners();
    }

    private void init() {
        devicesFragment = new DevicesFragment();
        manualsFragment = new ManualsFragment();
        accountFragment = new AccountFragment();
        aboutUsFragment = new AboutUsFragment();

        changeFragment(devicesFragment);
    }
    private void setListeners() {

        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.dispositivos:
                        changeFragment(devicesFragment);
                        break;
                    case R.id.manuales:
                        changeFragment(manualsFragment);
                        break;
                    case R.id.cuenta:
                        changeFragment(accountFragment);
                        break;
                    case R.id.acerca:
                        changeFragment(aboutUsFragment);
                        break;
                }

                return true;
            }
        });

        binding.topAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.addDevice:
                        //Toast.makeText(MainActivity.this, "Add device", Toast.LENGTH_SHORT).show();
                        Intent myIntent = new Intent(MainActivity.this, AddDevicesActivity.class);
                        MainActivity.this.startActivity(myIntent);
                        return true;
                    default:
                        return false;
                }
            }
        });

    }

    void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
    }
}