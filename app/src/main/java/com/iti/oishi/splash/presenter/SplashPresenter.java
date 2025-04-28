package com.iti.oishi.splash.presenter;

import com.iti.oishi.splash.view.ISplashFragmentView;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SplashPresenter implements ISplashPresenterView {
    private final ISplashFragmentView splashFragmentView;
    private final CompositeDisposable disposables;

    public SplashPresenter(ISplashFragmentView splashFragmentView) {
        this.splashFragmentView = splashFragmentView;
        disposables = new CompositeDisposable();
    }

    @Override
    public void scheduleHomeNavigation(long delayMs) {
        Disposable disposable = Completable.timer(delayMs, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (splashFragmentView != null) {
                        splashFragmentView.navToNextScreen();
                        disposables.clear();
                    }
                });
        disposables.add(disposable);
    }
}
