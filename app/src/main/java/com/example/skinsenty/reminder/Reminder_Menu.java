package com.example.skinsenty.reminder;

import java.util.ArrayList;

public class Reminder_Menu {
    String title;
    ArrayList<String> day;
//    String day;
    String time;
    String NotificationId;
    public Reminder_Menu(ArrayList day, String time, String title, String NotificationId)
    {
        this.title = title;
        this.day = day;
        this.time = time;
        this.NotificationId = NotificationId;
    }


}
