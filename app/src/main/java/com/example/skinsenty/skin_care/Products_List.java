package com.example.skinsenty.skin_care;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

import com.example.skinsenty.Products.Products;
import com.example.skinsenty.R;
import com.example.skinsenty.reminder.Reminder_Menu;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Products_List extends AppCompatActivity {


    ArrayList<Products> prdrct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

//        String jsonContent = readJsonFile(R.raw.female_facewashes);
//        Gson gson = new Gson();
//        Type type = new TypeToken<ArrayList<Products>>() {}.getType();
//        prdrct = gson.fromJson(jsonContent, type);
        Intent intent = getIntent();
        prdrct = (ArrayList<Products>) intent.getSerializableExtra("product");
        Products last = prdrct.get(prdrct.size()-1);
        prdrct.remove(prdrct.size()-1);
        Products_List_Adapter adapter = new Products_List_Adapter(this, prdrct);
        RecyclerView prdctList = findViewById(R.id.listProduct);
        prdctList.setLayoutManager(new GridLayoutManager(this, 2));
        prdctList.setAdapter(adapter);
        TextView title = findViewById(R.id.productsTitle);
        title.setText(last.product_Name);
    }


    public String readJsonFile(int resourceId) {
        StringBuilder jsonResult = new StringBuilder();

        try {
            Resources resources = getResources();
            InputStream inputStream = resources.openRawResource(resourceId);

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                jsonResult.append(line);
            }

            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonResult.toString();
    }
}