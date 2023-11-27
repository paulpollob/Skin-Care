package com.example.skinsenty.Products;

import android.content.Context;
import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;

public class Products implements Serializable{

    public int product_Id;
    public String product_Name;
    public String product_Image;
    public String product_Type;
    public String product_Description;
    public String product_Ingredients;
    public String how_To_Use;


    public Products(int product_Id, String product_Name, String product_Image, String product_Type, String product_Description, String product_Ingredients, String how_To_Use){
        this.how_To_Use = how_To_Use;
        this.product_Id = product_Id;
        this.product_Description = product_Description;
        this.product_Image = product_Image;
        this.product_Name = product_Name;
        this.product_Type = product_Type;
        this.product_Ingredients = product_Ingredients;
    }



    public static String readJsonFile(Context context, int resourceId) {
        StringBuilder jsonResult = new StringBuilder();

        try {
            Resources resources = context.getResources();
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
//    product_Id, product_Name, product_Image, product_Type, product_Description, product_Ingredients, how_To_Use;