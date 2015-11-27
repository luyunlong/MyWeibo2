package com.example.luyunlong.myweibo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.luyunlong.myweibo.BaseActivity;
import com.example.luyunlong.myweibo.R;
import com.example.luyunlong.myweibo.constants.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;


/**
 * Created by luyunlong ron 15/11/26.
 */
public class SplashActivity extends BaseActivity {

    private static final int  SHOW_TO_HOMEACTIVITY_TIME  = 1000;
    private static final int  WHAT_TO_HOMEACTIVITY = 1;
    private static final int  WHAT_INTENT2LOGINACTIVITY = 2;

    private Oauth2AccessToken accessToken;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case WHAT_TO_HOMEACTIVITY:
                    intentToActivity(MainActivity.class);
                    finish();
                    break;
                case WHAT_INTENT2LOGINACTIVITY:
                    intentToActivity(LoginActivity.class);
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
        accessToken = AccessTokenKeeper.readAccessToken(this);
        if(accessToken.isSessionValid()) {
            handler.sendEmptyMessageDelayed(WHAT_TO_HOMEACTIVITY, SHOW_TO_HOMEACTIVITY_TIME);
        } else {
            handler.sendEmptyMessageDelayed(WHAT_INTENT2LOGINACTIVITY, SHOW_TO_HOMEACTIVITY_TIME);
        }
    }
}
