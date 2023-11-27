package com.example.skinsenty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.skinsenty.reminder.Reminder;

public class homePage extends AppCompatActivity {
    RelativeLayout contact,help,sirenn,safe,signout,current,tip,view_off,yoga,view, reminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        contact = ( RelativeLayout) findViewById(R.id.contactt);
        sirenn = ( RelativeLayout) findViewById(R.id.sirenn);

        current = ( RelativeLayout) findViewById(R.id.current);
        view_off = ( RelativeLayout) findViewById(R.id.view_off);

        tip = ( RelativeLayout) findViewById(R.id.tip);
        yoga = ( RelativeLayout) findViewById(R.id.yoga);
        help = ( RelativeLayout) findViewById(R.id.help);
        view = ( RelativeLayout) findViewById(R.id.view);
        reminder = ( RelativeLayout ) findViewById(R.id.reminder);

        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homePage.this,faceYoga.class));

            }
        });



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homePage.this,tips_skincare.class));

            }
        });


        tip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homePage.this,contactDermologist.class));

            }
        });





        sirenn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homePage.this,skincare_menwomen.class));
            }
        });
        current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homePage.this,mom.class));

            }
        });






        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),hair_care.class);
                startActivity(intent);


            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),skinProblem.class);
                startActivity(intent);

            }
        });

        view_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),chatbot.class);
                startActivity(intent);

            }
        });

        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Reminder.class);
                startActivity(intent);

            }
        });
    }
}