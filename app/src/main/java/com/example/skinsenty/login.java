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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class login extends AppCompatActivity implements  View.OnClickListener{

    public Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +



                    ".{8,}" +                // at least 8 characters
                    "$");

    public ProgressBar determinateBar1;
    public EditText emailSignUp,passwordSignUP;
    public TextView createAccount,forgotPassword;
    public Button signUpButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailSignUp=(EditText) findViewById(R.id.emailSignUp);
        passwordSignUP=(EditText) findViewById(R.id.passwordSignUP);
        createAccount=(TextView) findViewById(R.id.createAccount);
        forgotPassword=(TextView) findViewById(R.id.Forgot);
        signUpButton=(Button) findViewById(R.id.signUpButton);
        determinateBar1=(ProgressBar)findViewById(R.id.determinateBar1);
        signUpButton.setOnClickListener((View.OnClickListener) this);
        createAccount.setOnClickListener((View.OnClickListener) this);
        forgotPassword.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case(R.id.createAccount):
                Intent intent=new Intent(getApplicationContext(),signUP.class);
                startActivity(intent);


                break;

            case(R.id.Forgot):
                Intent intent2=new Intent(getApplicationContext(),forgottenPassword.class);

                startActivity(intent2);

                break;

            case(R.id.signUpButton):

                UserSignIn();




                break;
            default:
                break;

        }

    }
    private void UserSignIn() {
        String email= emailSignUp.getText().toString().trim();
        String password= passwordSignUP.getText().toString().trim();

        if(email.isEmpty()){
            emailSignUp.setError("Enter a valid email address");
            emailSignUp.requestFocus();
            return;
        }
        //// Utils - A categorized directory of libraries and tools for Android
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailSignUp.setError("Enter a valid email address");
            emailSignUp.requestFocus();
            return;
        }
        if(password.isEmpty()){
            passwordSignUP.setError("Enter a valid password");
            passwordSignUP.requestFocus();
            return;
        }
        if(!PASSWORD_PATTERN.matcher(password).matches()){
            passwordSignUP.setError("Enter a valid password");
            passwordSignUP.requestFocus();
            return;

        }
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    if (firebaseAuth.getCurrentUser().isEmailVerified()&&firebaseAuth.getCurrentUser()!=null) {
                        Intent intent=new Intent(getApplicationContext(),homePage.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);


                    }
                    else{
                        Toast.makeText(login.this, "Please verify email", Toast.LENGTH_SHORT).show();
                    }




                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(login.this, "Try again", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }}

