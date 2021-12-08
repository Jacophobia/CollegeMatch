package com.example.collegematch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        // Create Back Button
        Button backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();
//        String string_gpa = bundle.getString("gpa").toString();
        float gpa = bundle.getFloat("gpa");
        int act = bundle.getInt("act");
        int sat = bundle.getInt("sat");
        String major = bundle.getString("major").toString();
        int price = bundle.getInt("price");
        String location = bundle.getString("location").toString();

        // Get college list view
        TextView collegeListView = findViewById(R.id.college_list_view);
        String collegeList = "";

        try {
            UserProfile newUser = new UserProfile(gpa, act, sat, location, price, major);
            DataFormatter colleges;
            colleges = new DataFormatter(newUser);

            for (int i = 0; i < colleges.size(); i++) {
                System.out.println(colleges.getCollegeName(i));
                collegeList += colleges.getCollegeName(i);
                collegeList += "\n";

            }
            collegeListView.setText(collegeList);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            finish();
        }






//        TextView gpa_view = findViewById(R.id.gpa_view);
//        gpa_view.setText(Float.toString(gpa));



    }
}