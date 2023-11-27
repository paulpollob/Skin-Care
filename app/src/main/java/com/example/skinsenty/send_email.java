package com.example.skinsenty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class send_email extends AppCompatActivity {
    EditText editTextTo,editTextSubject,editTextMessage;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);

        editTextTo=(EditText)findViewById(R.id.editText1);
        editTextSubject=(EditText)findViewById(R.id.editText2);
        editTextMessage=(EditText)findViewById(R.id.editText3);

        send=(Button)findViewById(R.id.button1);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to=editTextTo.getText().toString();
                String subject=editTextSubject.getText().toString();
                String message=editTextMessage.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                //ACTION_SEND - (ACTION_SEND) and data will help us to launch the available email clients to send an email in our application.



                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});//It’s an array of email addresses
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
//setType - We use this property to set the MIME type of data that we want to send.(text/plain” and “image/jpg”.)
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
                //If you want to custimize the title of that email, you can use createChooser here sharingIntent(subject of the content)

            }
        });
    }
    }
