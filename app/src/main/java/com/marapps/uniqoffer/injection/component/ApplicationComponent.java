package com.marapps.uniqoffer.injection.component;

import android.app.Application;
import android.content.Context;

import com.marapps.uniqoffer.data.DataManager;
import com.marapps.uniqoffer.data.SyncService;
import com.marapps.uniqoffer.data.local.DatabaseHelper;
import com.marapps.uniqoffer.data.local.PreferencesHelper;
import com.marapps.uniqoffer.data.remote.RibotsService;
import com.marapps.uniqoffer.injection.ApplicationContext;
import com.marapps.uniqoffer.injection.module.ApplicationModule;
import com.marapps.uniqoffer.util.RxEventBus;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(SyncService syncService);

    @ApplicationContext
    Context context();

    Application application();

    RibotsService ribotsService();

    PreferencesHelper preferencesHelper();

    DatabaseHelper databaseHelper();

    DataManager dataManager();

    RxEventBus eventBus();

}
