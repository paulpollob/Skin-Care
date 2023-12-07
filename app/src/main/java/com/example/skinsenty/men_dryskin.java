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

public class men_dryskin extends AppCompatActivity {
    Button mdmos,mdsnscrm,mdfcwsh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_dryskin);
        mdmos=(Button)findViewById(R.id.mdmos);
        mdsnscrm=(Button)findViewById(R.id.mdsnscrm);
        mdfcwsh=(Button)findViewById(R.id.mdfcwsh);
        mdfcwsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(men_dryskin.this, R.raw.male_oily_facewash);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Fachwashs For Men's Dry Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(men_dryskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(men_dryskin.this,dryskinmen_moisture.class));
            }
        });
        mdmos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(men_dryskin.this, R.raw.male_dry_mosturizer);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Moistuzers For Men's Dry Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(men_dryskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(men_dryskin.this,dryskinmen_sunscream.class));
            }
        });
        mdsnscrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(men_dryskin.this, R.raw.male_dry_sunscream);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Sunscream For Men's Dry Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(men_dryskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(men_dryskin.this,dryskinmen_facewash.class));
            }
        });
    }
    }
