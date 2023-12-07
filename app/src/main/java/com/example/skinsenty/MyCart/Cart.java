package com.example.skinsenty.MyCart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.skinsenty.Products.Products;
import com.example.skinsenty.R;
import com.example.skinsenty.reminder.Menu_Adapter;
import com.example.skinsenty.reminder.Reminder_Menu;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    RecyclerView cartlist;
    ArrayList<Products> prdrct;
    CardView placeOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartlist = findViewById(R.id.cartList);
        prdrct = new ArrayList<>();

        SharedPreferences preferences = getSharedPreferences("skinCare", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String s = preferences.getString("cart", null);
        Type type = new TypeToken<ArrayList<Products>>() {}.getType();
        prdrct = gson.fromJson(s, type);

        CartAdapter adptr = new CartAdapter(this, prdrct);

        cartlist.setLayoutManager(new LinearLayoutManager(this));
        cartlist.setAdapter(adptr);


        placeOrder = findViewById(R.id.placeOrder);
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cart.this, Place_Order.class);
                startActivity(intent);
            }
        });

    }
}