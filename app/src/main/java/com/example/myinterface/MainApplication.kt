package com.example.myinterface

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import timber.log.Timber
import javax.inject.Inject


class MainApplication : Application() {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        AppInjector.init(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector
}