package com.example.luyunlong.myweibo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.luyunlong.myweibo.BaseActivity;
import com.example.luyunlong.myweibo.R;


/**
 * Created by luyunlong on 15/11/26.
 */
public class SplashActivity extends BaseActivity {

    private static final int  SHOW_TO_HOMEACTIVITY_TIME  = 1000;
    private static final int  WHAT_TO_HOMEACTIVITY = 1;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case WHAT_TO_HOMEACTIVITY:
                    intentToActivity(MainActivity.class);
                    finish();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler.sendEmptyMessageDelayed(WHAT_TO_HOMEACTIVITY,SHOW_TO_HOMEACTIVITY_TIME);
    }
}
