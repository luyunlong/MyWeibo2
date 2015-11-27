package com.example.luyunlong.myweibo;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.example.luyunlong.myweibo.activity.MainActivity;

/**
 * Created by luyunlong on 15/11/26.
 */
public class BaseFragment extends Fragment {

    protected MainActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = (MainActivity) getActivity();
    }

    protected void intent2Activity(Class<? extends Activity> tarActivity) {
        Intent intent = new Intent(activity,tarActivity);
        startActivity(intent);
    }
}
