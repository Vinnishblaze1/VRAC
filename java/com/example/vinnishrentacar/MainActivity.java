package com.example.vinnishrentacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button driver1,rider1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        driver1=(Button) findViewById(R.id.driver);
        rider1=(Button) findViewById(R.id.rider);

        driver1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,DriverStart.class);
                startActivity(i);
                finish();
                return;

            }
        });
        rider1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(MainActivity.this,RiderStart.class);
                startActivity(j);
                finish();
                return;
            }
        });
    }
}
