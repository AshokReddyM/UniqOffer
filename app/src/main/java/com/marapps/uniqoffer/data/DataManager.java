package com.marapps.uniqoffer.data;

import com.marapps.uniqoffer.data.local.DatabaseHelper;
import com.marapps.uniqoffer.data.local.PreferencesHelper;
import com.marapps.uniqoffer.data.remote.RibotsService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager {

    private final RibotsService mRibotsService;
    private final DatabaseHelper mDatabaseHelper;
    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public DataManager(RibotsService ribotsService, PreferencesHelper preferencesHelper,
                       DatabaseHelper databaseHelper) {
        mRibotsService = ribotsService;
        mPreferencesHelper = preferencesHelper;
        mDatabaseHelper = databaseHelper;
    }

    public PreferencesHelper getPreferencesHelper() {
        return mPreferencesHelper;
    }


}
