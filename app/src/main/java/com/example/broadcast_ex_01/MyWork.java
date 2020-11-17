package com.example.broadcast_ex_01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class MyWork extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        int i=0;
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {

            Toast.makeText(context, "Booted Complited", Toast.LENGTH_LONG).show();

        }
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            Toast.makeText(context, "Net Connection", Toast.LENGTH_LONG).show();
        }

        if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
            int newVolume = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", 0);
            int oldVolume = intent.getIntExtra("android.media.EXTRA_PREV_VOLUME_STREAM_VALUE", 0);
            if (newVolume != oldVolume) {
                i++;
                Intent intent1 = new Intent();
                intent1.setClass(context, MainActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent1);
                Toast.makeText(context, "VOLUME CHANGE ACTION"+i, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
