package com.example.skinsenty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class contactDermologist extends AppCompatActivity {
    Button contact1,contact2,contact3,contact4,contact5,contact6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_dermologist);
        contact1=(Button) findViewById(R.id.contact1);
        contact2=(Button) findViewById(R.id.contact2);
        contact3=(Button) findViewById(R.id.contact3);
        contact4=(Button) findViewById(R.id.contact4);
        contact5=(Button) findViewById(R.id.contact5);
        contact6=(Button) findViewById(R.id.contact6);

        contact6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(contactDermologist.this,contact1.class);
                startActivity(intent);

            }
        });

        contact5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(contactDermologist.this,contact1.class);
                startActivity(intent);

            }
        });

        contact4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(contactDermologist.this,contact1.class);
                startActivity(intent);
            }
        });

        contact3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(contactDermologist.this,contact1.class);
                startActivity(intent);
            }
        });

        contact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(contactDermologist.this,contact1.class);
                startActivity(intent);
            }
        });

        contact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(contactDermologist.this,contact1.class);
                startActivity(intent);

            }
        });
    }
    }
