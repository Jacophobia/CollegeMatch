package com.example.collegematch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            configureNextButton();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void configureNextButton() {
        Button nextButton = (Button) findViewById(R.id.submit_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent i = new Intent(MainActivity.this, OutputActivity.class);
                    startActivity(i);
                } catch (Exception e){
                    System.out.println(e);
                }

            }
        });
    }
}