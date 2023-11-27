package com.example.skinsenty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class skincare extends AppCompatActivity {
    Button oily,dry,combine,sensitive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skincare);

        oily=(Button)findViewById(R.id.oily);
        dry=(Button)findViewById(R.id.dry);
        combine=(Button)findViewById(R.id.combine);
        sensitive=(Button)findViewById(R.id.sensitive);
        oily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(skincare.this,sectionskinacre.class));
            }
        });
        dry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(skincare.this,dryskin.class));
            }
        });
        combine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(skincare.this,combinationskin.class));
            }
        });
        sensitive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(skincare.this,sensitiveskin.class));
            }
        });

    }
}