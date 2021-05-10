package com.kt.thepopularmoviedb.di

import android.app.Application
import com.kt.thepopularmoviedb.App
import com.kt.thepopularmoviedb.api.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ComposeModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        PersistenceModule::class]
)
interface AppComponent : AndroidInjector<DaggerApplication>{

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}
