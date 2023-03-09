package com.example.alarma;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAlarma(0,1,getApplicationContext());
    }

    private void setAlarma(int hora, int minutos, Context miContexto) {
        AlarmManager alarmManager;
        PendingIntent pendingIntent;

        //Configuramos la alarma a través de Calendar
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR,hora);
        calendar.set(Calendar.MINUTE,minutos);

        //Creamos la alarma
        Intent intent=new Intent(miContexto,Alarma.class);
        pendingIntent=PendingIntent.getBroadcast(miContexto,0,intent,PendingIntent.FLAG_IMMUTABLE);

        alarmManager= (AlarmManager) miContexto.getSystemService(Context.ALARM_SERVICE);

        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);

    }
}