package com.marapps.uniqoffer.ui.main;

import com.marapps.uniqoffer.data.DataManager;
import com.marapps.uniqoffer.injection.ConfigPersistent;
import com.marapps.uniqoffer.ui.base.BasePresenter;
import com.marapps.uniqoffer.util.RxUtil;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

@ConfigPersistent
public class MainPresenter extends BasePresenter<MainMvpView> {

    private final DataManager mDataManager;
    private Disposable mDisposable;

    @Inject
    public MainPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mDisposable != null) mDisposable.dispose();
    }

    public void loadRibots() {
        checkViewAttached();
        RxUtil.dispose(mDisposable);
   /*     mDataManager.getRibots()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe();
*/
    }

}
