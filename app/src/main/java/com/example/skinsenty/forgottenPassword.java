package com.example.skinsenty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgottenPassword extends AppCompatActivity {
    public EditText forgotEmail;
    public Button forgotButton;
    private ProgressBar determinateBar2;
    private TextView backLogin;

    //// Initialize Firebase Auth
    private FirebaseAuth mAuth;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten_password);
        mAuth = FirebaseAuth.getInstance();

        forgotEmail = (EditText) findViewById(R.id.forgotEmail);
        determinateBar2=(ProgressBar)findViewById(R.id.determinateBar);
        backLogin=(TextView)findViewById(R.id.backLogin);

        forgotButton = (Button) findViewById(R.id.forgotButton);

        backLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(forgottenPassword.this,login.class);
                startActivity(intent);
            }
        });
        forgotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validData();
            }
        });


    }
    private void validData() {
        String email=forgotEmail.getText().toString();
        if(email.isEmpty()){
            forgotEmail.setError("Enter correct email");
        }


        else{
            mAuth.sendPasswordResetEmail(email).addOnCompleteListener((new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if (task.isSuccessful()) {



                        Toast.makeText(forgottenPassword.this, "Sucessfully ", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(forgottenPassword.this,login.class));


                    } else {

                        Toast.makeText(forgottenPassword.this, "Try aagin", Toast.LENGTH_SHORT).show();

                    }

                }
            }));
        };


    }
}