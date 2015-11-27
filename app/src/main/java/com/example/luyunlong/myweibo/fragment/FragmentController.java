package com.example.luyunlong.myweibo.fragment;

import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.example.luyunlong.myweibo.BaseFragment;
import java.util.ArrayList;

/**
 * Created by luyunlong on 15/11/27.
 */
public class FragmentController {

    private int containerId;
    private android.support.v4.app.FragmentManager fm;
    private ArrayList<BaseFragment> fragments;

    private static FragmentController fragmentController;
    public static FragmentController getInstance(FragmentActivity activity , int containerId){
        if (fragmentController == null){
            fragmentController = new FragmentController(activity,containerId);

        }
        return  fragmentController;

    }
    private  FragmentController(FragmentActivity activity,int containerId){
            this.containerId = containerId;
            fm = activity.getSupportFragmentManager();
            initFragment();
    }
    private  void  initFragment(){
        fragments = new ArrayList<BaseFragment>();
        fragments.add(new HomeFragment());
        fragments.add(new MessageFragment());
        fragments.add(new SquareFragment());
        fragments.add(new MeFragment());

        FragmentTransaction transaction = fm.beginTransaction();
        for (BaseFragment fragment : fragments){
            transaction.add(containerId,fragment);
        }
        transaction.commit();
    }
    public void showFragment(int postion){
        hideFragment();

        BaseFragment fragment = fragments.get(postion);
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.show(fragment);
        transaction.commit();

    }
    public void hideFragment(){
        for (BaseFragment fragment : fragments){
            FragmentTransaction transaction = fm.beginTransaction();
            if (fragment != null){
                transaction.hide(fragment);
            }
            transaction.commit();
        }

    }
    public BaseFragment getFragment(int position){
        return  fragments.get(position);
    }

}
