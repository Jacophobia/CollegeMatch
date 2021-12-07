package com.example.collegematch;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        View submit_button = findViewById(R.id.submit_button); // FIXME: This just keeps returning null for some reason
        System.out.println(submit_button);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(firebase.getCollegeList());

                // Check for missing inputs
                try {
                    // Collect Inputs
                    EditText gpa_inputView = findViewById(R.id.gpa_input);
                    float gpa = Float.parseFloat(gpa_inputView.getText().toString());

                    EditText act_inputView = findViewById(R.id.act_input);
                    int act = Integer.parseInt(act_inputView.getText().toString());

                    EditText sat_inputView = findViewById(R.id.sat_input);
                    int sat = Integer.parseInt(sat_inputView.getText().toString());

                    EditText major_inputView = findViewById(R.id.major_input);
                    String major = major_inputView.getText().toString();

                    EditText price_inputView = findViewById(R.id.price_input);
                    int price = Integer.parseInt(price_inputView.getText().toString());

                    EditText location_inputView = findViewById(R.id.location_input);
                    String location = location_inputView.getText().toString();

                    UserProfile newUser = new UserProfile(gpa, act, sat, location, price, major);

                    // Create UserProfile or show error
                    //                try {
                    Bundle bundle = new Bundle();
                    System.out.println("Created a bundle");
                    bundle.putFloat("gpa", gpa);
                    System.out.println(gpa);
                    System.out.println("Added gpa");
                    bundle.putInt("act", act);
                    System.out.println("added act");
                    bundle.putInt("sat", sat);
                    System.out.println("added sat");
                    bundle.putString("major", major);
                    System.out.println("added major");
                    bundle.putInt("price", price);
                    System.out.println("added price");
                    bundle.putString("location", location);
                    System.out.println("added location");

                    // Move to results screen
                    Intent i = new Intent(MainActivity.this, ResultsActivity.class);
                    i.putExtras(bundle);
                    startActivity(i);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"All inputs must be filled",Toast.LENGTH_SHORT).show();
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