package com.example.denis.figaro;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.widget.Toast;

public class OnBootReceiver extends BroadcastReceiver {


    // Each 30 seconds
    private static final int PERIOD =  30 * 1000;

    @Override
    public void onReceive(Context context, Intent intent) {

        // we are interested only on system's BOOT COMPLETED EVENT
        if ( !Intent.ACTION_BOOT_COMPLETED.equals( intent.getAction() ))
            return;


        // pendingIntent to slap AlarmReceiver
        Intent alarmIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);

        AlarmManager alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        if (alarmMgr != null) {
            // each PERIOD we want to fire an pendingIntent.
            alarmMgr.setInexactRepeating(
                    // ELAPSED_REALTIME alarm does not wake the device up; if it goes off while the device
                    // is asleep, it will not be delivered until the next time the device
                    // wakes up.
                    AlarmManager.ELAPSED_REALTIME,
                    SystemClock.elapsedRealtime(),
                    PERIOD,
                    pendingIntent);
        }
    }
}
