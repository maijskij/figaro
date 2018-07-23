package com.example.denis.figaro;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, context.getString(R.string.figaro_msg), Toast.LENGTH_LONG).show();
    }
}
