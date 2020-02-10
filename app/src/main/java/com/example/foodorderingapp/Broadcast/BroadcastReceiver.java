package com.example.foodorderingapp.Broadcast;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.foodorderingapp.Notification.Channel;
import com.example.foodorderingapp.R;

public class BroadcastReceiver extends android.content.BroadcastReceiver {
    private NotificationManagerCompat notificationManagerCompat;
    Context mcontext;

    public BroadcastReceiver(Context mcontext){
        this.mcontext=mcontext;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        boolean noConnectivity;
        notificationManagerCompat = NotificationManagerCompat.from(mcontext);
        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            noConnectivity = intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY,false
            );
            if(noConnectivity){
                Toast.makeText(context,"Disconnected",Toast.LENGTH_SHORT).show();
                notification1();
            } else {
                Toast.makeText(context,"connected",Toast.LENGTH_SHORT).show();
                notification2();

            }

        }


    }

    private void notification1() {
        Notification notification=new NotificationCompat.Builder(mcontext, Channel.channel_1)
                .setSmallIcon(R.drawable.cart)
                .setContentTitle("Food ordering")
                .setContentText("No internet connection, please connect")
                .setCategory(NotificationCompat.CATEGORY_SYSTEM)
                .build();

        notificationManagerCompat.notify(1,notification);
    }

    private void notification2()
    {
        Notification notification=new NotificationCompat.Builder(mcontext, Channel.channel_2)
                .setSmallIcon(R.drawable.cart)
                .setContentTitle("Food ordering")
                .setContentText("You have been connected to a network")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(2,notification);

    }
}
