package com.kt.thepopularmoviedb

import com.kt.thepopularmoviedb.di.DaggerAppComponent
import dagger.android.DaggerApplication
import timber.log.Timber

@Suppress("unused")
class App : DaggerApplication() {

    private val appComponent = DaggerAppComponent.factory().create(this)

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun applicationInjector() = appComponent
}
