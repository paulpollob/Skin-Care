package com.example.skinsenty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menskin extends AppCompatActivity {
    Button oskn,dskn,cskn,sskn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menskin);
        oskn=(Button)findViewById(R.id.oskn);
        dskn=(Button)findViewById(R.id.dskn);
        cskn=(Button)findViewById(R.id.cskn);
        sskn=(Button)findViewById(R.id.sskn);
        oskn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(menskin.this,oilyskinmen.class));
            }
        });
        dskn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(menskin.this,men_dryskin.class));
            }
        });
        cskn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(menskin.this,men_combinationskin.class));
            }
        });
        sskn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(menskin.this,men_sensitiveskin.class));
            }
        });

    }

}