package com.marapps.uniqoffer.ui.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.marapps.uniqoffer.ui.base.BaseActivity;
import com.marapps.uniqoffer.ui.loginscreen.activity.LoginActivity;

public class SplashScreenActivity extends BaseActivity {

    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }, 2000);


    }
}