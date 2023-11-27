package com.example.skinsenty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class contact1 extends AppCompatActivity {
    String Phone;
    TextView call_raya,send1,email_raya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact1);

        send1=(TextView) findViewById(R.id.send1);
        call_raya=(TextView) findViewById(R.id.call_raya);
        email_raya=(TextView) findViewById(R.id.email_raya);

        email_raya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(contact1.this,send_email.class);
                startActivity(intent);

            }
        });


        call_raya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //implicit intent
                Intent intent=new Intent(Intent.ACTION_DIAL);
                //ACTION_DIAL Display the phone dialer with the person filled in.
                intent.setData(Uri.parse("tel:8745686799"));//for avoiding error have to give 'tel'

                //
                //setData() is used to point to the location of a data object
                //uri parse - want to pass data through intent(convert into the text)
                startActivity(intent);
            }
        });

        send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ACTION_VIEW Selecting a particular person to view would result in a new intent
                //ACTION_VIEW start an activity to display information
                //????Ask sir must
                //uri.fromparts  contains the scheme(sms/mms), scheme-specific part (ssp(phone no)) and the fragment (null in your case)
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","8745686799","null"));
                intent.putExtra("sms_body","");
                //    intent.putExtra putExtra() method is to send values you need in the next activity.
                // while putExtra() adds simple data types
                startActivity(intent);

            }
        });
    }
    }
