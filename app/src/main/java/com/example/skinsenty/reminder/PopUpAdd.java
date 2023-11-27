package com.example.skinsenty.reminder;

import android.app.AlarmManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.skinsenty.databinding.ActivityPopUpAddBinding;

import com.example.skinsenty.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PopUpAdd  {
    public static SharedPreferences.Editor editor;
    public static ArrayList<Reminder_Menu> menu;
    public static SharedPreferences preferences;
    public static Gson gson;
    public static Menu_Adapter adptr;

    public static void showPopUp(final Context context, View anchorView){
        View popView = LayoutInflater.from(context).inflate(R.layout.activity_pop_up_add, null);


        final PopupWindow window = new PopupWindow(
                popView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true
        );

        Button cls = popView.findViewById(R.id.clspopup);
        cls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { window.dismiss(); } });

        window.showAtLocation(anchorView, Gravity.CENTER, 0, 0);
        EditText text = popView.findViewById(R.id.addtitle);
        TimePicker timepick = (TimePicker)  popView.findViewById(R.id.picktime);
        timepick.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                String time = String.format("%02d:%02d", hourOfDay, minute);
                Toast.makeText(popView.getContext(), time, Toast.LENGTH_SHORT).show();
            }
        });
        CheckBox sat = popView.findViewById(R.id.sat),
                sun = popView.findViewById(R.id.sun),
                mon = popView.findViewById(R.id.mon),
                tue = popView.findViewById(R.id.tue),
                wed = popView.findViewById(R.id.wed),
                thu = popView.findViewById(R.id.thu),
                fri = popView.findViewById(R.id.fri);

        Button save = popView.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String s = preferences.getString("reminder", null);

                Type type = new TypeToken<ArrayList<Reminder_Menu>>() {}.getType();
                menu = gson.fromJson(s, type);
                if(menu==null) menu = new ArrayList<>();

                int hour = (int)(timepick.getCurrentHour());
                int minute = (int)(timepick.getCurrentMinute());
                int second = 0;
                String title= text.getText().toString();
                String time = String.format("%02d:%02d", timepick.getCurrentHour(), timepick.getCurrentMinute());
                ArrayList<String> day = new ArrayList<>();

                if(sat.isChecked()) day.add("Sat");
                if(sun.isChecked()) day.add("Sun");
                if(mon.isChecked()) day.add("Mon");
                if(tue.isChecked()) day.add("Tue");
                if(wed.isChecked()) day.add("Wed");
                if(thu.isChecked()) day.add("Thu");
                if(fri.isChecked()) day.add("Fri");


                LocalDateTime now = LocalDateTime.now();
                String NotificationId = now.format(DateTimeFormatter.ofPattern("MMddHHss"));
//                Toast.makeText(context, now.getLong(), Toast.makeText()).sh;

                Reminder.schedule(context, hour, minute, second, day, NotificationId, title);


//                Toast.makeText(context, "HK current time is: "+NotificationId, Toast.LENGTH_SHORT).show();

                Reminder_Menu rm = new Reminder_Menu(day, time, title, NotificationId);
                menu.add(rm);


                String json = gson.toJson(menu);

                editor.putString("reminder", json);
                editor.apply();

                adptr.setData(menu);
                adptr.notifyDataSetChanged();
//                Toast.makeText(context, "hare Krishna"+json, Toast.LENGTH_SHORT).show();
                window.dismiss();

            }
        });


    }
}