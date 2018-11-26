package com.marapps.uniqoffer.injection.component;

import com.marapps.uniqoffer.injection.PerActivity;
import com.marapps.uniqoffer.injection.module.ActivityModule;
import com.marapps.uniqoffer.ui.loginscreen.activity.LoginActivity;
import com.marapps.uniqoffer.ui.main.MainActivity;

import dagger.Subcomponent;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
    void inject(LoginActivity loginActivity);

}
