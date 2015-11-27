package com.example.luyunlong.myweibo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.example.luyunlong.myweibo.constants.CommonConstants;
import com.example.luyunlong.myweibo.utils.Logger;
import com.example.luyunlong.myweibo.utils.ToastUtils;

/**
 * Created by luyunlong on 15/11/26.
 */
public abstract class BaseActivity extends Activity{

    protected String TAG;
    protected BaseApplication application;
    protected SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TAG = this.getClass().getSimpleName();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        application = (BaseApplication)getApplication();
        sharedPreferences = getSharedPreferences(CommonConstants.SP_NAME,Activity.MODE_PRIVATE);

    }
    protected void intentToActivity(Class<? extends Activity> tarActivity){

        Intent intent = new Intent(this,tarActivity);
        startActivity(intent);
    }
    protected void showToast(String msg){
        ToastUtils.showToast(this, msg, Toast.LENGTH_SHORT);

    }
    protected void showLog(String msg){
        Logger.show(TAG,msg);

    }
}
