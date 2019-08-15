package com.example.vinnishrentacar;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Driverregister extends AppCompatActivity {
    private EditText user,pass,repassw,mob,emaile;
    private Button reg;
    private FirebaseAuth Auth;
    private FirebaseAuth.AuthStateListener fl;
    private FirebaseDatabase fdb;
    private DatabaseReference db;
    private FirebaseUser fu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driverregister);
        Auth=FirebaseAuth.getInstance();

        db=FirebaseDatabase.getInstance("Users").getReference("Driver");

        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        repassw = (EditText) findViewById(R.id.repass);
        mob = (EditText) findViewById(R.id.mobile);
        emaile = (EditText) findViewById(R.id.email);
        reg = (Button) findViewById(R.id.Register);

        Auth = FirebaseAuth.getInstance();
        fl = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                fu = FirebaseAuth.getInstance().getCurrentUser();
                if (fu != null) {
                    Intent i = new Intent(Driverregister.this, DriverLogin.class);
                    startActivity(i);
                    finish();
                    return;
                }
            }
        };


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emaile.getText().toString();
                final String password = pass.getText().toString();

                Auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(Driverregister.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete( Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(Driverregister.this, "sign up error", Toast.LENGTH_SHORT).show();
                        }else{
                            String user_id = Auth.getCurrentUser().getUid();
                            db = FirebaseDatabase.getInstance().getReference("Users").child("Driver");
                            db.setValue(email);
                            db.setValue(password);
                        }
                    }
                });
            }
        });
    }


       @Override
        protected void onStart()  {
            super.onStart();
            Auth.addAuthStateListener(fl);
        }
        @Override
        protected void onStop(){
            super.onStop();
            Auth.removeAuthStateListener(fl);
        }






}




