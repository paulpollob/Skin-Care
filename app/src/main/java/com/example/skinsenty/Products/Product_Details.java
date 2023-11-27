package com.example.skinsenty.Products;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.skinsenty.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class Product_Details extends AppCompatActivity {

    ShapeableImageView img;
    TextView dscrptn, name, ingredients, use;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        img = findViewById(R.id.img);
        dscrptn = findViewById(R.id.description);
        name = findViewById(R.id.namePrdct);
        ingredients = findViewById(R.id.ingredients);
        use = findViewById(R.id.HowToUse);

        Intent intent = getIntent();
        Products prdrct = (Products) intent.getSerializableExtra("details");
        Glide.with(this).load(prdrct.product_Image).into(img);
        dscrptn.setText(prdrct.product_Description);
        name.setText(prdrct.product_Name);
        ingredients.setText(prdrct.product_Ingredients);
        use.setText(prdrct.how_To_Use);

    }
}