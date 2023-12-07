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

public class sensitiveskin extends AppCompatActivity {
    Button fsfcwsh,fssrm,fssncrm,fsfpck,fstnr,fsmstrzr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensitiveskin);
        fsfcwsh=(Button)findViewById(R.id.fsfcwsh);
        fssrm=(Button)findViewById(R.id.fssrm);
        fssncrm=(Button)findViewById(R.id.fssncrm);
        fsfpck=(Button)findViewById(R.id.fsfpck);
        fstnr=(Button)findViewById(R.id.fstnr);
        fsmstrzr=(Button)findViewById(R.id.fsmstrzr);
        fssncrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(sensitiveskin.this, R.raw.female_sensitive_sunscream);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Sunscream For Sensitive Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(sensitiveskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(sensitiveskin.this,sunscream_sensitive.class));
            }
        });
        fsfpck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(sensitiveskin.this, R.raw.female_sensitive_facepack);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Fcaepack For Oily Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(sensitiveskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(sensitiveskin.this,facepack.class));
            }
        });
        fstnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(sensitiveskin.this, R.raw.female_sensitive_toner);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Toners For Sensitive Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(sensitiveskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(sensitiveskin.this,toner_sensitive.class));
            }
        });
        fsmstrzr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(sensitiveskin.this, R.raw.female_sensitive_mosturizer);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Moistuzer For Sensitive Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(sensitiveskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(sensitiveskin.this,moisture_sensitive.class));
            }
        });

        fsfcwsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(sensitiveskin.this, R.raw.female_sensitive_facewash);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Fachwashs For Sensitive Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(sensitiveskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(sensitiveskin.this,sensitive_facewash.class));
            }
        });
        fssrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(sensitiveskin.this, R.raw.female_sensitive_serum);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Serums For Combination Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(sensitiveskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
                startActivity(new Intent(sensitiveskin.this,serum_combination.class));
            }
        });
    }
}

