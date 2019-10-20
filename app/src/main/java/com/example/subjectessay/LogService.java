package com.example.subjectessay;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import java.util.Date;


public class LogService extends Service {
    Handler mHandler = new Handler();
    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("LogService", "run: " + new Date().toString());
                mHandler.postDelayed(this, 1000);
            }
        }, 1000);
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
