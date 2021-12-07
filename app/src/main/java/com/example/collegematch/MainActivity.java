package com.example.collegematch;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.app.AppCompatActivity;

import com.example.collegematch.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    public static Firebase firebase = new Firebase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        val f_to_c = findViewById<Button>(R.id.f_to_c)
//        val c_to_f = findViewById<Button>(R.id.c_to_f)
//
//        f_to_c.setOnClickListener { convert_f_to_c() }
//        c_to_f.setOnClickListener { convert_c_to_f() }

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        View submit_button = findViewById(R.id.submit_button); // FIXME: This just keeps returning null for some reason
        submit_button.setOnClickListener(view -> {
            UserProfile testUser = null;
            try {
                testUser = new UserProfile(4.0f, 36, 1600, "East", 1000000, "Engineering");
            } catch (Exception e) {
                e.printStackTrace();
            }
            DataFormatter colleges;
            if (testUser != null) {
                colleges = new DataFormatter(testUser);
                for (int i = 0; i < colleges.size(); i++) {
                    System.out.println(colleges.getCollegeName(i));
                }
            }
        });

    }

    private void onSubmit() {
        System.out.println(firebase.getCollegeList());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}