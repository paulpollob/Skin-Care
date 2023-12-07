package com.example.skinsenty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.skinsenty.reminder.Reminder;

public class homePage extends AppCompatActivity {
    CardView contact,help,sirenn,safe,signout,current,tip,view_off,yoga,view, reminder, detectTool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        contact = ( CardView) findViewById(R.id.contactt);
        sirenn = ( CardView) findViewById(R.id.sirenn);

        current = ( CardView) findViewById(R.id.current);
        view_off = ( CardView) findViewById(R.id.view_off);

        tip = ( CardView) findViewById(R.id.tip);
        yoga = ( CardView) findViewById(R.id.yoga);
        help = ( CardView) findViewById(R.id.help);
        view = ( CardView) findViewById(R.id.view);
        reminder = ( CardView ) findViewById(R.id.reminder);
        detectTool = ( CardView ) findViewById(R.id.detectTool);

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


        detectTool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Skin_Detect.class);
                startActivity(intent);

            }
        });
    }
}