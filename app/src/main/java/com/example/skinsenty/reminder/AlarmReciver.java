package com.example.skinsenty.reminder;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.skinsenty.MainActivity;
import com.example.skinsenty.R;

public class AlarmReciver extends BroadcastReceiver {
    MediaPlayer mp;
    public static String NotificationId;
    public static String NotificationTitle;

    public void onReceive(Context context, Intent intent) {
        String[] info = (String[]) intent.getSerializableExtra("info");
        createNotificationChannel(context, info);
        showNotification(context, info);

    }



    public void showNotification(Context context, String[] info) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, info[0])

                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(info[1])
                .setContentText("Complete Your Task.")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSound(Settings.System.DEFAULT_ALARM_ALERT_URI);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(01, builder.build());
        Toast.makeText(context, "Krishna from show button", Toast.LENGTH_SHORT).show();
    }
    public void createNotificationChannel(Context context, String[] info) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is not in the Support Library.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Krishna";
            String description = "It's trial hk";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(info[0], name, importance);
            channel.setDescription(description);
            AudioAttributes at = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            channel.setSound(Settings.System.DEFAULT_ALARM_ALERT_URI, at);
            // Register the channel with the system. You can't change the importance
            // or other notification behaviors after this.
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            Toast.makeText(context, "hare Krishna from notification", Toast.LENGTH_SHORT).show();
        }


    }

}
