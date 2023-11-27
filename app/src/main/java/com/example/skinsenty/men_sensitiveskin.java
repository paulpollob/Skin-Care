package com.example.skinsenty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.skinsenty.Products.Products;
import com.example.skinsenty.skin_care.Products_List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class men_sensitiveskin extends AppCompatActivity {
    Button msfcwsh,mssnscrm,msmos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_sensitiveskin);
        msfcwsh=(Button)findViewById(R.id.msfcwsh);
        mssnscrm=(Button)findViewById(R.id.mssnscrm);
        msmos=(Button)findViewById(R.id.msmos);
        msmos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(men_sensitiveskin.this, R.raw.male_sensitive_mosturizer);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Moistuzer For Men's Sensitive Skin", "", "", "", "", ""));
                Intent intent = new Intent(men_sensitiveskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(men_sensitiveskin.this,sensitivemen_moisture.class));
            }
        });
        mssnscrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(men_sensitiveskin.this, R.raw.male_sensitive_sunscream);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Sunscream For Mens's Sensitive Skin", "", "", "", "", ""));
                Intent intent = new Intent(men_sensitiveskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(men_sensitiveskin.this,sensitivemen_sunscream.class));
            }
        });
        msfcwsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(men_sensitiveskin.this, R.raw.male_combination_sunscream);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Facewash For Men's Sensitive Skin", "", "", "", "", ""));
                Intent intent = new Intent(men_sensitiveskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(men_sensitiveskin.this,sensitivemen_facewash.class));
            }
        });
    }
    }
