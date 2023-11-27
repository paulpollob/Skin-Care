package com.example.skinsenty.skin_care;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.skinsenty.reminder.Menu_Adapter;
import com.example.skinsenty.reminder.Reminder_Menu;

import java.util.ArrayList;

public class Products_List_Adapter extends RecyclerView.Adapter<Products_List_Adapter.ViewHolder>{

    Context context;
    ArrayList<Products> prdct;
    public Products_List_Adapter(Context context, ArrayList<Products> prdct)
    {
        this.context = context;
        this.prdct = prdct;
    }

    public void setData(ArrayList<Products> prdct) { this.prdct = prdct; }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.product, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(prdct.get(position).product_Image).into(holder.banner);
        holder.title.setText(prdct.get(position).product_Name);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Product_Details.class);
                intent.putExtra("details", prdct.get(position));
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() { return prdct != null ? prdct.size() : 0; }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView card;
        ImageView banner;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            card = itemView.findViewById(R.id.products);
            banner = itemView.findViewById(R.id.productImage);
            title = itemView.findViewById(R.id.productName);

        }
    }
}
