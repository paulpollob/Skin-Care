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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import java.util.regex.Pattern;

public class signUP extends AppCompatActivity implements  View.OnClickListener {
    private EditText emailID, passwordID, namee;
    private Button signUpButton;
    private FirebaseAuth mAuth;
    private ProgressBar determinateBar;
    public TextView signUpText;
    public Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +



                    ".{8,}" +                // at least 8 characters
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        determinateBar = (ProgressBar) findViewById(R.id.determinateBar);

        emailID = (EditText) findViewById(R.id.emailID);
        namee = (EditText) findViewById(R.id.namee);
        passwordID = (EditText) findViewById(R.id.passwordID);


        signUpButton = (Button) findViewById(R.id.signUpButton);


        signUpText = (TextView) findViewById(R.id.signUpText);
        signUpButton.setOnClickListener((View.OnClickListener) this);

        signUpText.setOnClickListener((View.OnClickListener) this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signUpButton:
                userRegister();

                break;
            case R.id.signUpText:
                Intent intent = new Intent(getApplicationContext(), login.class);

                startActivity(intent);
                break;


            default:
                break;
        }

    }
    private void userRegister() {
        String email = emailID.getText().toString().trim();
        String Password = passwordID.getText().toString().trim();//returns a new string, without modifying the original string
        String Name = namee.getText().toString().trim();


        if (Name.isEmpty()) {
            namee.setError("Enter a name");
            namee.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            emailID.setError("Entry valid email");
            emailID.requestFocus();
            return;
        }
// Utils - A categorized directory of libraries and tools for Android
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailID.setError("Enter a valid  email");
            emailID.requestFocus();
            return;
        }
        determinateBar.setVisibility(View.VISIBLE);

        if (Password.isEmpty()) {
            passwordID.setError("Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character:\n");
            passwordID.requestFocus();
            return;
        }
        if (!PASSWORD_PATTERN.matcher(Password).matches()) {
            passwordID.setError("Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character:\n");
            passwordID.requestFocus();
            return;
        }
        determinateBar.setVisibility(View.VISIBLE);


        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        determinateBar.setVisibility(View.GONE);

                        if (task.isSuccessful()) {
                            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

                            firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    //Task<Void> task doesnt return
                                    determinateBar.setVisibility(View.VISIBLE);
//                             userID=firebaseAuth.getCurrentUser().getUid();
//                             FirebaseUser users=firebaseAuth.getCurrentUser();


                                    Toast.makeText(signUP.this, "Successfully registered,Check your email for verification", Toast.LENGTH_SHORT).show();
                                    Intent intent1 = new Intent(signUP.this, login.class);

                                    startActivity(intent1);

                                }


                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {


                                    Toast.makeText(signUP.this, "Fail to send verfication email", Toast.LENGTH_SHORT).show();


                                }
                            });


                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(signUP.this, "Already Registered", Toast.LENGTH_SHORT).show();

                        }


                    }
                });


    }
    }
