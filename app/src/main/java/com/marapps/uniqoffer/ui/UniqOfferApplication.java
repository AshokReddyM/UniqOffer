package com.marapps.uniqoffer.ui;

import android.app.Application;
import android.content.Context;

import com.marapps.uniqoffer.BuildConfig;
import com.marapps.uniqoffer.injection.component.ApplicationComponent;
import com.marapps.uniqoffer.injection.component.DaggerApplicationComponent;
import com.marapps.uniqoffer.injection.module.ApplicationModule;

import timber.log.Timber;

public class UniqOfferApplication extends Application {

    ApplicationComponent mApplicationComponent;


    public static UniqOfferApplication get(Context context) {
        return (UniqOfferApplication) context.getApplicationContext();
    }


    @Override
    public void onCreate() {
        super.onCreate();

    /*    CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(getResources().getString(R.string.font_regular))
                .setFontAttrId(R.attr.fontPath)
                .build()
        );*/


        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            //  Fabric.with(this, new Crashlytics());
        }

    }


    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }
}