package com.example.denis.figaro;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.widget.Toast;

public class OnBootReceiver extends BroadcastReceiver {


    private static final int PERIOD =  30 * 1000;

    @Override
    public void onReceive(Context context, Intent intent) {

        // we are interested only on system's BOOT COMPLETED EVENT
        if ( !Intent.ACTION_BOOT_COMPLETED.equals( intent.getAction() ))
            return;


        // each PERIOD we want to fire an action described in AlarmReceiver's receiver
        Intent alarmIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);

        AlarmManager alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        if (alarmMgr != null) {
            // ELAPSED_REALTIME is used, as we want to show Toast, but with dimmed screen it doesn't make sense.
            alarmMgr.setInexactRepeating(
                    AlarmManager.ELAPSED_REALTIME,
                    SystemClock.elapsedRealtime(),
                    PERIOD,
                    pendingIntent);
        }
    }
}
