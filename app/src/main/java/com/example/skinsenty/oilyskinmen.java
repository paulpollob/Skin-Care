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

public class oilyskinmen extends AppCompatActivity {
    Button mofcwsh,mosncrm,momstrzr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oilyskinmen);
        mofcwsh=(Button)findViewById(R.id.mofcwsh);
        mosncrm=(Button)findViewById(R.id.mosncrm);
        momstrzr=(Button)findViewById(R.id.momstrzr);
        momstrzr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(oilyskinmen.this, R.raw.male_oily_mosturizer);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Moistuzer For Men's Oily Skin", "", "", "", "", ""));
                Intent intent = new Intent(oilyskinmen.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(oilyskinmen.this,oilyskinmen_moiszer.class));
            }
        });
        mosncrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(oilyskinmen.this, R.raw.male_oily_sunscream);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Sunscream For Men's Oily Skin", "", "", "", "", ""));
                Intent intent = new Intent(oilyskinmen.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(oilyskinmen.this,oilyskinmen_sunscream.class));
            }
        });
        mofcwsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(oilyskinmen.this, R.raw.male_oily_facewash);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Facewsash For Men's Oily Skin", "", "", "", "", ""));
                Intent intent = new Intent(oilyskinmen.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(oilyskinmen.this,oilyskinmen_facewash.class));
            }
        });
    }
}