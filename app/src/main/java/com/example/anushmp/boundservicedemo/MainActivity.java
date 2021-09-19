package com.example.anushmp.boundservicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ServiceConnection gsc;

    MusicService m;

    boolean isbound;

    Button start,stop,pause,play;


    //LinearLayout musiccontrols;

    // dynamic button
    // 158000
    // bound service bg thread.
    // comms

    // bound service bg thread or main thread.
    // multiple clients can connect to the same service.
    // thats what you do. stop watch lloyd pace. cool


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        musiccontrols = findViewById(R.id.musiccontrols);
//        Button btn = new Button(this);
//        musiccontrols.addView(btn);

        //vercel wix app comms. maturity.

        //playstore self exploitation. dorik
        //equity ego. meetings.



        start = findViewById(R.id.startmusic);
        stop = findViewById(R.id.btnstop);
        pause = findViewById(R.id.btnpause);
        play = findViewById(R.id.btnplay);




        ServiceConnection sc = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

                MusicService.MyBinder mboundservice = (MusicService.MyBinder) service;
                m = mboundservice.getMusicService();
                isbound = true;



                //coolwhip.


            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

                isbound = false;

            }
        };


        gsc = sc;



        start.setOnClickListener(v -> {

            Intent i = new Intent(MainActivity.this,MusicService.class);
            bindService(i,gsc,Context.BIND_AUTO_CREATE);

        });

        play.setOnClickListener(v->{

            if(isbound){

                m.startmusic();

            }

        });

        pause.setOnClickListener( v-> {

            if(isbound){

                m.pausemusic();

            }

        });

        stop.setOnClickListener( v -> {

            if(isbound){

                m.stopmusic();

            }
        });


    }


//    public void dosomething(){
//
//        Intent i = new Intent(MainActivity.this,MusicService.class);
//
//        startService(i);
//
//        bindService(i,gsc, Context.BIND_AUTO_CREATE);
//    }


    /*
    *
    *
    * Thread Looper Handler
    *
    *
    * intentService
    * Service
    * BoundService
    * live data kotlin views.
    * rice fields
    * Thursday. psc
    * cool.
    * Eval
    *
    *
    *
    * */

}