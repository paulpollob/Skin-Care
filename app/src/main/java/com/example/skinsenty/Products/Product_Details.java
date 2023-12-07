package com.example.skinsenty.Products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.skinsenty.MyCart.Cart;
import com.example.skinsenty.R;
import com.example.skinsenty.reminder.Reminder_Menu;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Product_Details extends AppCompatActivity {

    ShapeableImageView img;
    TextView dscrptn, name, ingredients, use;
    CardView addToCart;
    FloatingActionButton crtDtls;
    public static ArrayList<Products> prdcts;
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

        addToCart = findViewById(R.id.addToCart);




        //get from local storage
        SharedPreferences preferences = getSharedPreferences("skinCare", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String s = preferences.getString("cart", null);
        Type type = new TypeToken<ArrayList<Products>>() {}.getType();
        prdcts = gson.fromJson(s, type);
        if(prdcts==null) prdcts = new ArrayList<>();
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Products prdct = new Products(prdrct.product_Id, prdrct.product_Name, prdrct.product_Image, prdrct.product_Type, prdrct.product_Description, prdrct.product_Ingredients, prdrct.how_To_Use, prdrct.product_price);
                prdcts.add(prdct);

                String json = gson.toJson(prdcts);

                editor.putString("cart", json);
                editor.apply();
                Toast.makeText(Product_Details.this, "Added to Your Cart.", Toast.LENGTH_SHORT).show();
            }
        });

        crtDtls = findViewById(R.id.crtDtls);
        crtDtls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(this, Cart);
                Intent intent = new Intent(Product_Details.this, Cart.class);
//                intent.putExtra("details", prdct.get(position));
                startActivity(intent);
            }
        });


    }
}