package com.example.vinnishrentacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DriverStart extends AppCompatActivity {
    private Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_start);
        login=(Button)findViewById(R.id.dreg);
        register=(Button)findViewById(R.id.dsign);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DriverStart.this,Driverregister.class);
                startActivity(i);
                finish();
                return;

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(DriverStart.this,DriverLogin.class);
                startActivity(j);
                finish();
                return;
            }
        });
    }
}
