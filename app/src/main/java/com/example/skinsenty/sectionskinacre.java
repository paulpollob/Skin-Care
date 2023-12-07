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

public class sectionskinacre extends AppCompatActivity {
    Button ffcwsh,fosrm,fosun,fofcpck,fotnr,fomstrzr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sectionskinacre);
        ffcwsh=(Button)findViewById(R.id.ffcwsh);
        fosrm=(Button)findViewById(R.id.fosrm);
        fosun=(Button)findViewById(R.id.fosun);
        fofcpck=(Button)findViewById(R.id.fofcpck);
        fotnr=(Button)findViewById(R.id.fotnr);
        fomstrzr=(Button)findViewById(R.id.fomstrzr);
        fosun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(sectionskinacre.this, R.raw.female_oily_sunscream);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Sunscream For Oily Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(sectionskinacre.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(sectionskinacre.this,sunscream.class));
            }
        });
        fofcpck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(sectionskinacre.this, R.raw.female_oily_facepack);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Fcaepack For Oily Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(sectionskinacre.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(sectionskinacre.this,facepack.class));
            }
        });
        fotnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(sectionskinacre.this, R.raw.female_oily_toner);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Toners For Oily Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(sectionskinacre.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(sectionskinacre.this,toner.class));
            }
        });
        fomstrzr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(sectionskinacre.this, R.raw.female_oily_mosturizer);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Moistuzer For Oily Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(sectionskinacre.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
//                startActivity(new Intent(sectionskinacre.this,moistuzers.class));
            }
        });

        ffcwsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(sectionskinacre.this, R.raw.female_facewashes);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Fachwashs For Oily Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(sectionskinacre.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
            }
        });
        fosrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jsonContent = Products.readJsonFile(sectionskinacre.this, R.raw.female_oily_serum);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Products>>() {}.getType();
                ArrayList<Products> prdct = gson.fromJson(jsonContent, type);
                prdct.add(new Products(-1, "Serums For Oily Skin", "", "", "", "", "", 1));
                Intent intent = new Intent(sectionskinacre.this, Products_List.class);
                intent.putExtra("product", prdct);
                startActivity(intent);
            }
        });
    }
}