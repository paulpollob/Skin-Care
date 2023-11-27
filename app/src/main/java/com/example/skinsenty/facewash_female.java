package com.example.skinsenty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class facewash_female extends AppCompatActivity {
RelativeLayout  face_1,face_2,face_3,face_4,face_5,face_6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facewash_female);
        face_1=(RelativeLayout)findViewById(R.id.face_1);
        face_2=(RelativeLayout)findViewById(R.id.face_2);
        face_3=(RelativeLayout)findViewById(R.id.face_3);
        face_4=(RelativeLayout)findViewById(R.id.face_4);
        face_5=(RelativeLayout)findViewById(R.id.face_5);
        face_6=(RelativeLayout)findViewById(R.id.face_6);


        face_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(facewash_female.this,sectionskinacre.class));
            }
        });

     face_2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(facewash_female.this,sectionskinacre.class));
        }
    });

        face_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(facewash_female.this,sectionskinacre.class));
            }
        });
        face_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(facewash_female.this,sectionskinacre.class));
            }
        });
        face_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(facewash_female.this,sectionskinacre.class));
            }
        });
        face_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(facewash_female.this,sectionskinacre.class));
            }
        });
    }
    }



