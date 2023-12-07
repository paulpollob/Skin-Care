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

public class combinationskin extends AppCompatActivity {
    Button cmfcwsh,cmsrm,cmsncrm,cmfcpck,cmtnr,cmmstrzr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combinationskin);
        cmfcwsh=(Button)findViewById(R.id.cmfcwsh);
        cmsrm=(Button)findViewById(R.id.cmsrm);
        cmsncrm=(Button)findViewById(R.id.cmsncrm);
        cmfcpck=(Button)findViewById(R.id.cmfcpck);
        cmtnr=(Button)findViewById(R.id.cmtnr);
        cmmstrzr=(Button)findViewById(R.id.cmmstrzr);
        cmsncrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(combinationskin.this, R.raw.female_combination_sunscream);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Sunscream For Combination Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(combinationskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(combinationskin.this,sunscream_combination.class));
            }
        });
        cmfcpck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(combinationskin.this, R.raw.female_combination_facepack);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Fcaepack For Combination Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(combinationskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(combinationskin.this,facepack.class));
            }
        });
        cmtnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(combinationskin.this, R.raw.female_combination_toner);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Toners For Combinatiob Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(combinationskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(combinationskin.this,toner_combination.class));
            }
        });
        cmmstrzr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(combinationskin.this, R.raw.female_combination_mosturizer);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Moistuzer For Combination Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(combinationskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(combinationskin.this,combination_moisture.class));
            }
        });

        cmfcwsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(combinationskin.this, R.raw.female_combination_facewash);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Fachwashs For Combination Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(combinationskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(combinationskin.this,combination_facewash.class));
            }
        });
        cmsrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(combinationskin.this, R.raw.female_combination_serum);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Serums For Combination Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(combinationskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(combinationskin.this,serum_combination.class));
            }
        });
    }
    }
