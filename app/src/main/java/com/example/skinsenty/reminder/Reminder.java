package com.example.skinsenty.reminder;

import android.Manifest;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skinsenty.R;
import com.example.skinsenty.databinding.ActivityReminderBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;

public class Reminder extends AppCompatActivity {

    static final int ALARM_REQ_CODE = 100;
    Menu_Adapter adptr;
    ArrayList<Reminder_Menu> menu;

    private AppBarConfiguration appBarConfiguration;
    private ActivityReminderBinding binding;
    MediaPlayer mediaPlayer;
    Intent intent;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    private boolean isAlarmSet = false;


    public void schedule(View view) { scheduleNotification(7, 3, 0, this, Calendar.FRIDAY, "id", "Krishna"); }
    public static void schedule( Context context,  int hour, int minute, int second, ArrayList<String> day, String NotificationId, String NotificationTitle) {

        for(int i = 0; i<day.size(); i++)
        {
            if(day.get(i) == "Sat") scheduleNotification(hour, minute, second, context, Calendar.SATURDAY, NotificationId, NotificationTitle);
            if(day.get(i) == "Sun") scheduleNotification(hour, minute, second, context, Calendar.SUNDAY, NotificationId, NotificationTitle);
            if(day.get(i) == "Mon") scheduleNotification(hour, minute, second, context, Calendar.MONDAY, NotificationId, NotificationTitle);
            if(day.get(i) == "Tue") scheduleNotification(hour, minute, second, context, Calendar.TUESDAY, NotificationId, NotificationTitle);
            if(day.get(i) == "Wed") scheduleNotification(hour, minute, second, context, Calendar.WEDNESDAY, NotificationId, NotificationTitle);
            if(day.get(i) == "Thu") scheduleNotification(hour, minute, second, context, Calendar.THURSDAY, NotificationId, NotificationTitle);
            if(day.get(i) == "Fri") scheduleNotification(hour, minute, second, context, Calendar.FRIDAY, NotificationId, NotificationTitle);
        }
    }

    public static void scheduleNotification( int hour, int minute, int second, Context context, int dayOfWeek, String NotificationId, String NotificationTitle) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);

//        long triggerTime = System.currentTimeMillis()+(1000*10);


        String[] str = {NotificationId, NotificationTitle};

        Intent notificationIntent = new Intent(context, AlarmReciver.class);
        notificationIntent.putExtra("info",str);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (alarmManager != null) {
            // Set the alarm to trigger at 9:00 AM every day
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.set (AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            } else {
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }
            Toast.makeText(context, "HK alarm seted", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        binding = ActivityReminderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        ImageView gifImageView = findViewById(R.id.headImg);
        RecyclerView remindermenu = findViewById(R.id.reminder_menu);
        remindermenu.setLayoutManager(new LinearLayoutManager(this));

        SharedPreferences preferences = getSharedPreferences("Krishna prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String s = preferences.getString("reminder", null);
        Type type = new TypeToken<ArrayList<Reminder_Menu>>() {}.getType();
        menu = gson.fromJson(s, type);

        adptr = new Menu_Adapter(this, menu);
        remindermenu.setAdapter(adptr);



        FloatingActionButton adrmndr = findViewById(R.id.add_reminder);
        adrmndr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                PopUpAdd.editor = editor;
                PopUpAdd.preferences = preferences;
                PopUpAdd.gson = gson;
                PopUpAdd.adptr = adptr;
                PopUpAdd.showPopUp(Reminder.this, v);
            }
        });
    }






    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release the MediaPlayer when the activity is destroyed
//        mediaPlayer.release();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_reminder);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}