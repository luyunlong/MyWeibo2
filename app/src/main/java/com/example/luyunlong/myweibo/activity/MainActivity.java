package com.example.luyunlong.myweibo.activity;

import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.example.luyunlong.myweibo.R;
import com.example.luyunlong.myweibo.fragment.FragmentController;
import com.example.luyunlong.myweibo.utils.ToastUtils;

public class MainActivity extends FragmentActivity implements View.OnClickListener ,RadioGroup.OnCheckedChangeListener{

    private FragmentController fragmentController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.rg_tab);

        findViewById(R.id.tabbar_add_button).setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);

        fragmentController =  FragmentController.getInstance(this,R.id.fl_contant);
        fragmentController.showFragment(0);
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tabbar_add_button:

                ToastUtils.showToast(this,"addAction", Toast.LENGTH_SHORT);

                break;
        }
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.tabBar_home_button:
                fragmentController.showFragment(0);
                break;
            case R.id.tabBar_msg_button:
                fragmentController.showFragment(1);
                break;
            case R.id.tabBar_square_button:
                fragmentController.showFragment(2);
                break;
            case R.id.tabBar_me_button:
                fragmentController.showFragment(3);
                break;

        }
    }
}
