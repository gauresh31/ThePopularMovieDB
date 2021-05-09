package com.kt.thepopularmoviedb;

import android.app.Application;

import com.kt.thepopularmoviedb.api.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AppModule.class,
                NetworkModule.class
        }
)
public interface AppComponent {

    Application application();

    void inject(App app);

}

