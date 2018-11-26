package com.marapps.uniqoffer.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.marapps.uniqoffer.R;
import com.marapps.uniqoffer.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {

    private static final String EXTRA_TRIGGER_SYNC_FLAG = "ui.main.MainActivity.EXTRA_TRIGGER_SYNC_FLAG";

    @Inject
    MainPresenter mMainPresenter;

    public static Intent getStartIntent(Context context, boolean triggerDataSyncOnCreate) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(EXTRA_TRIGGER_SYNC_FLAG, triggerDataSyncOnCreate);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


}
