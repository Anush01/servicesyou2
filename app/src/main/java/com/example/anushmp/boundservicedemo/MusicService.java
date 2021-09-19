package com.example.anushmp.boundservicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class MusicService extends Service implements LooperPreparedListner {

    //MyBinder binderobject = new MyBinder();

    BGhandlerThread handlerthread;
    MediaPlayer mp;
    boolean isLooperReady;




    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        handlerthread = new BGhandlerThread("handlemusic",this);

        handlerthread.start();

        mp = MediaPlayer.create(MusicService.this,R.raw.london);


        return new MyBinder();
    }

    @Override
    public void onlooperready() {
        isLooperReady = true;

    }


    public void startmusic(){
        if(isLooperReady){

            handlerthread.addtasktoq(() -> mp.start());


        }

    }

    public void pausemusic(){
       if(isLooperReady){

           handlerthread.addtasktoq(() ->{

               mp.pause();

           });

       }
    }

    public void stopmusic(){

        if(isLooperReady){


            handlerthread.addtasktoq(() ->{

                mp.stop();
                //mp.release();


            });

        }

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public  class MyBinder extends Binder{

        public MusicService getMusicService(){

            return MusicService.this;

        }

    }




}