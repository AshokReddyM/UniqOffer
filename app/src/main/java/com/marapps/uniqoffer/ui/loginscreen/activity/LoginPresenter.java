package com.marapps.uniqoffer.ui.loginscreen.activity;

import com.marapps.uniqoffer.data.DataManager;
import com.marapps.uniqoffer.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * Created by arun on 19/1/18.
 */

public class LoginPresenter extends BasePresenter<LoginMvpView> {

    private final DataManager mDataManager;
    private Disposable mDisposable;

    @Inject
    public LoginPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(LoginMvpView loginMvpView) {
        super.attachView(loginMvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        mDisposable.dispose();
    }


}


