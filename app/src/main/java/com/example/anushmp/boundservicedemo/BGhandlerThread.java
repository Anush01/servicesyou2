package com.example.anushmp.boundservicedemo;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class BGhandlerThread extends HandlerThread {

    Handler handler;
    LooperPreparedListner lpl;

    public BGhandlerThread(String name, LooperPreparedListner lpl){

        super(name);

        this.lpl = lpl;

    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();

        handler = new Handler(getLooper());

        if(lpl !=null){
            lpl.onlooperready();
        }
    }

    public void addtasktoq(Runnable task){
        handler.post(task);
    }

}
