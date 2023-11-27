package com.example.skinsenty.reminder;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skinsenty.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Menu_Adapter  extends RecyclerView.Adapter<Menu_Adapter.ViewHolder> {

    Context context;
    ArrayList<Reminder_Menu> menu;
    public Menu_Adapter(Context context, ArrayList<Reminder_Menu> menu)
    {
        this.context = context;
        this.menu = menu;
    }

    public void setData(ArrayList<Reminder_Menu> menu) { this.menu = menu; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.reminder_list, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.time.setText(menu.get(position).time);
        ArrayList<String> day = menu.get(position).day;
//        String day = menu.get(position).day;
        String daystr = "";

        for(String e:day)
        {
            daystr+=(", "+e);
        }
        holder.day.setText(daystr);
        holder.title.setText(menu.get(position).title);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        holder.dlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                Toast.makeText(context, "HK id is: "+menu.get(position).NotificationId, Toast.LENGTH_SHORT).show();
                if (notificationManager != null) {
                    notificationManager.cancel(Integer.parseInt(menu.get(position).NotificationId));
                }
                SharedPreferences preferences = context.getSharedPreferences("Krishna prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                Gson gson = new Gson();
                menu.remove(position);
                String json = gson.toJson(menu);
                editor.putString("reminder", json);
                editor.apply();
                notifyDataSetChanged();
                Toast.makeText(context, "Hare Krishna deleted!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() { return menu != null ? menu.size() : 0;}

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView card;
        TextView time, day, title;
        ImageButton dlt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.remindermenulist);
            day = itemView.findViewById(R.id.day);
            time = itemView.findViewById(R.id.time);
            title = itemView.findViewById(R.id.title);
            dlt = itemView.findViewById(R.id.delete);

        }
    }
}
