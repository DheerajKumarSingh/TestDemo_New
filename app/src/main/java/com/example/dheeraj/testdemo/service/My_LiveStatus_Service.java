package com.example.dheeraj.testdemo.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;



/**
 * Created by DHEERAJ on 1/31/2017.
 */

public class My_LiveStatus_Service extends Service {

    IBinder iBinder;
    public static final int notify = 3000;  //interval between two services(Here Service run every 5 Minute)
    private Handler mHandler = new Handler();   //run on another Thread to avoid crash
    private Timer mTimer = null;    //timer handling
    Context mcontext;


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (mTimer != null) // Cancel if already existed
            mTimer.cancel();
        else
            mTimer = new Timer();   //recreate new
        mTimer.scheduleAtFixedRate(new TimeDisplay(), 0, notify);   //Schedule task
        mcontext=getApplicationContext();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mTimer.cancel();    //For Cancel Timer

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v("livestatus", "start service live update");
        return START_STICKY;
    }
    //class TimeDisplay for handling task
    class TimeDisplay extends TimerTask {
        @Override
        public void run() {
            // run on another thread
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    // display toast
                //    Toast.makeText(My_LiveStatus_Service.this, "Service is running", Toast.LENGTH_SHORT).show();
                        MyAsynTask myAsynTask = new MyAsynTask(mcontext);
                        myAsynTask.execute();

                }
            });
        }
    }
}
