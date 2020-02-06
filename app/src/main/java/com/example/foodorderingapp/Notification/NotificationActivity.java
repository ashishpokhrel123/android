package com.example.foodorderingapp.Notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;

import com.example.foodorderingapp.R;

public class NotificationActivity extends AppCompatActivity {

    NotificationManagerCompat notificationManagerCompat;


    Broadcast broadcast;

    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


    }
}

