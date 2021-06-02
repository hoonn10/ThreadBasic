package com.androidapp.threadbasic;

import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    Thread wr;
    WorkerThread wt;
    boolean running = true;
    String TAG2 = "THREAD2";
    String TAG = "THREAD";


    class WorkerThread extends  Thread{
        @Override
        public void run() {
            int i =0;
            for(i = 0; i<20 && running; i++){
                try{
                    Thread.sleep(1000);

                }catch (InterruptedException e){

                }
                Log.v(TAG,"Thread time = "+i);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        running = true;
        wt= new WorkerThread();
        wr = new Thread(new Runnable() {
            @Override
            public void run() {
                int i =0;
                for(i = 0; i<20 && running; i++){
                    try{
                        Thread.sleep(1000);

                    }catch (InterruptedException e){

                    }
                    Log.v(TAG2,"Runnable time="+i);
                }
            }
        });
        wr.start();
        wt.start();
        Log.v(TAG2,"Now I am in onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        running = false;
        Log.v(TAG2,"Now I am in onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG2,"Now I am in onPause");
    }


}