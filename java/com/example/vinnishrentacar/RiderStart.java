package com.example.vinnishrentacar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RiderStart extends AppCompatActivity {
    private Button neuser,exuser;
    private FirebaseAuth Auth;
    private FirebaseAuth.AuthStateListener fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_start);
        neuser=(Button) findViewById(R.id.nu);
        exuser=(Button) findViewById(R.id.eu);
        neuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RiderStart.this,RiderRegister.class);
                startActivity(i);
                finish();
                return;

            }
        });
        exuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(RiderStart.this,riderlogin.class);
                startActivity(j);
                finish();
                return;
            }
        });
        Auth=FirebaseAuth.getInstance();
        fl=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
                if(user!=null)
                {
                    Intent i=new Intent();
                    startActivity(i);
                    finish();
                    return;
                }
            }
        };
    }
}
