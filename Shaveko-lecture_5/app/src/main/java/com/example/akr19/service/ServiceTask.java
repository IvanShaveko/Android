package com.example.akr19.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class ServiceTask extends Service {
    @Override
    public void onCreate(){
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(ServiceTask.this,"Service start working",Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(ServiceTask.this,"Service stopped",Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent){
        return null;
    }
}
