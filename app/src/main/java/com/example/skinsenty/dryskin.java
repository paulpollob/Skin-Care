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

public class dryskin extends AppCompatActivity {
    Button fdfcwsh,fdsrm,fdsnscrm,fdfcpck,fdtnr,fdmstrzr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dryskin);
        fdfcwsh=(Button)findViewById(R.id.fdfcwsh);
        fdsrm=(Button)findViewById(R.id.fdsrm);
        fdsnscrm=(Button)findViewById(R.id.fdsnscrm);
        fdfcpck=(Button)findViewById(R.id.fdfcpck);
        fdtnr=(Button)findViewById(R.id.fdtnr);
        fdmstrzr=(Button)findViewById(R.id.fdmstrzr);
        fdsnscrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(dryskin.this, R.raw.female_dry_sunscream);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Sunscream For Oily Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(dryskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(dryskin.this,sunscream_dry.class));
            }
        });
        fdfcpck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(dryskin.this, R.raw.female_dry_facepack);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Fcaepack For Oily Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(dryskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(dryskin.this,facepack.class));
            }
        });
        fdtnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(dryskin.this, R.raw.female_oily_toner);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Toners For Dry Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(dryskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(dryskin.this,tonerdryskin.class));
            }
        });
        fdmstrzr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(dryskin.this, R.raw.female_dry_mosturizer);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Moistuzer For Dry Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(dryskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(dryskin.this,dryMostizure.class));
            }
        });

        fdfcwsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(dryskin.this, R.raw.female_dry_facewash);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Facewash  For Dry Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(dryskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(dryskin.this,dry_facewash_women.class));
            }
        });
        fdsrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(dryskin.this, R.raw.female_dry_serum);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Serums For Dry Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(dryskin.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(dryskin.this,dryskin_serum.class));
            }
        });
    }
    }
