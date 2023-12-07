package com.example.skinsenty.MyCart;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.skinsenty.Products.Product_Details;
import com.example.skinsenty.Products.Products;
import com.example.skinsenty.R;
import com.example.skinsenty.reminder.Reminder_Menu;
import com.google.gson.Gson;

import java.util.ArrayList;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{

    Context context;
    ArrayList<Products> prdct;
    public CartAdapter(Context context, ArrayList<Products> prdct)
    {
        this.context = context;
        this.prdct = prdct;
    }

    public void setData(ArrayList<Products> prdct) { this.prdct = prdct; }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cartitem, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(prdct.get(position).product_Image).into(holder.crtPrdctImg);
        holder.crtPrdctTtl.setText(prdct.get(position).product_Name);
        holder.crtCls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prdct.remove(position);
                SharedPreferences preferences = context.getSharedPreferences("skinCare", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                Gson gson = new Gson();
                String json = gson.toJson(prdct);
                editor.putString("cart", json);
                editor.apply();
                notifyDataSetChanged();
                Toast.makeText(context, "Removed From Cart!", Toast.LENGTH_SHORT).show();

            }
        });
//        holder.crtPrdctprc.setText(prdct.get(position).product_price);
    }

    @Override
    public int getItemCount() { return prdct != null ? prdct.size() : 0; }

    public class ViewHolder extends RecyclerView.ViewHolder {

//        CardView card;
        ImageView crtPrdctImg;
        TextView crtPrdctTtl;
        TextView crtPrdctprc;
        ImageButton crtCls;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            crtPrdctImg = itemView.findViewById(R.id.crtPrdctImg);
            crtPrdctTtl = itemView.findViewById(R.id.crtPrdctTtl);
            crtPrdctprc = itemView.findViewById(R.id.crtPrdctprc);
            crtCls = itemView.findViewById(R.id.crtCls);
        }
    }
}
