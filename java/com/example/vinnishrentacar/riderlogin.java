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

public class riderlogin extends AppCompatActivity {

        private EditText pass,user;
        private Button sign;
        private FirebaseAuth auth;
        private FirebaseAuth.AuthStateListener fl;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_riderlogin);
            user=(EditText)findViewById(R.id.username);
            pass=(EditText) findViewById(R.id.password);
            sign=(Button) findViewById(R.id.login);
            auth=FirebaseAuth.getInstance();
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
            sign.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String muser = user.getText().toString();
                    final String mpass = pass.getText().toString();
                    auth.signInWithEmailAndPassword(muser, mpass).addOnCompleteListener(riderlogin.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {


                                    if (task.isSuccessful()) {
                                        String user_id = auth.getCurrentUser().getUid();
                                        DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Driver").child(user_id);
                                    } else {
                                        Toast.makeText(riderlogin.this, "Sign in error", Toast.LENGTH_SHORT).show();
                                    }


                                }
                            }


                    );
        }
});
        }
}