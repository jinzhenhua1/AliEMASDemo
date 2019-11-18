package com.example.aliemasdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.alibaba.ha.adapter.service.tlog.TLogService;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    private String MODEL = "main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TLogService.logv(MODEL,TAG,"test tlog1");



        String str = "金振华";
        byte[] bytes = str.getBytes();
        str = Base64.encodeToString(bytes, Base64.DEFAULT);
        Log.d(TAG,str);
    }
}
