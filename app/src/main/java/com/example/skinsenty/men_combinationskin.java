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

public class men_combinationskin extends AppCompatActivity {
    Button mcfcwsh,mcmos,mcsnscrm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_combinationskin);
        mcfcwsh=(Button)findViewById(R.id.mcfcwsh);
        mcmos=(Button)findViewById(R.id.mcmos);
        mcsnscrm=(Button)findViewById(R.id.mcsnscrm);
        mcsnscrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(men_combinationskin.this, R.raw.male_combination_sunscream);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Sunscream  For Men's Combintion Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(men_combinationskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(men_combinationskin.this,combinationskinmen_sunscream.class));
            }
        });
        mcmos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(men_combinationskin.this, R.raw.male_oily_facewash);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Moistuzer For Combination Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(men_combinationskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(men_combinationskin.this,combination_moisture.class));
            }
        });
        mcfcwsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(men_combinationskin.this, R.raw.male_oily_facewash);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Facewashs For Men's Combination Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(men_combinationskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(men_combinationskin.this,combinationskinmen_facewash.class));
            }
        });
    }
    }
