package com.iti.oishi.splash.presenter;

import com.iti.oishi.model.repos.IRepository;
import com.iti.oishi.splash.view.ISplashFragmentView;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SplashFragmentPresenter implements ISplashFragmentPresenter {
    private final ISplashFragmentView splashFragmentView;
    private final CompositeDisposable disposables;
    private final IRepository repository;

    public SplashFragmentPresenter(ISplashFragmentView splashFragmentView, IRepository repository) {
        this.splashFragmentView = splashFragmentView;
        this.repository = repository;
        disposables = new CompositeDisposable();
    }

    @Override
    public void scheduleHomeNavigation(long delayMs) {
        Disposable disposable = Completable.timer(delayMs, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (splashFragmentView != null) {
                        boolean isLoggedIn = repository.isLoggedIn();
                        if (!isLoggedIn) {
                            splashFragmentView.navToLogin();
                        } else {
                            splashFragmentView.navToHome();
                        }
                    }
                });
        disposables.add(disposable);
    }
}