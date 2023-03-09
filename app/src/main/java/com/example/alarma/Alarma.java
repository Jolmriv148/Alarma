package com.example.alarma;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Alarma extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Alarma!",Toast.LENGTH_SHORT).show();
        System.out.println("Alarma!");
    }
}
