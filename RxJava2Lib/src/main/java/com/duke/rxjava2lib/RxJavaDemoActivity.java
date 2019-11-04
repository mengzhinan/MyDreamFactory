package com.duke.rxjava2lib;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;

public class RxJavaDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_demo);
        observable();
    }

    @SuppressLint("CheckResult")
    private void flowable() {
        Flowable.just("Hello world").subscribe(System.out::println);
    }

    @SuppressLint("CheckResult")
    private void observable() {
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            Log.v("observable", "emitter thread1 = " + Thread.currentThread().getName());
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onComplete();
            Log.v("observable", "emitter thread2 = " + Thread.currentThread().getName());
        })
                .subscribe(integer -> {
                    Log.v("observable", "integer thread1 = " + Thread.currentThread().getName());
                    Log.v("observable", "integer = " + integer);
                    Log.v("observable", "integer thread2 = " + Thread.currentThread().getName());
                });


    }
}
