package com.androidapp.threadbasic;

import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    WorkerThread wt;
    WorkerRunnable wr;
    boolean running = true;
    String TAG = "THREAD";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Now I am in onCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
        wt = new WorkerThread();
        wr = new WorkerRunnable();
        running = true;
        wt.start();
        wr.start();
        Log.v(TAG, "Now I am in onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        running = false;
        Log.v(TAG, "Now I am in onStop");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.v(TAG, "Now I am in onPause");
    }

    class WorkerThread extends Thread {
        public void run() {
            int i = 0;
            for (i = 0; i < 20 && running; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                Log.v(TAG, "Thread time=" + i);
            }
        }
    }

    class WorkerRunnable extends Thread{
        public void run() {
            int i = 0;
            for (i = 0; i < 20 && running; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                Log.v(TAG, "Runnable time=" + i);
            }
        }
    }
}