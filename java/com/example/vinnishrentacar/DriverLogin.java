package com.example.vinnishrentacar;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DriverLogin extends AppCompatActivity {

    private EditText mEmail, mPassword;
    private Button mLogin;
    DatabaseReference df;
    FirebaseUser fuser;
    FirebaseAuth fl;
    FirebaseAuth.AuthStateListener fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);
        fl=FirebaseAuth.getInstance();
        df=FirebaseDatabase.getInstance().getReference("Driver");
        fa=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                fuser=FirebaseAuth.getInstance().getCurrentUser();
                if(mEmail!=null)
                {
                    Intent i=new Intent(DriverLogin.this,Drivermap.class);
                    startActivity(i);
                    finish();
                    return;

                }

            }
        };
        mEmail=(EditText) findViewById(R.id.email);
        mPassword=(EditText) findViewById(R.id.password);
        mLogin=(Button) findViewById(R.id.login);





        }}