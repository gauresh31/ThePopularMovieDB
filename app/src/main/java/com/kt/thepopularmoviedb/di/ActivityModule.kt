package com.kt.thepopularmoviedb.di

import com.kt.thepopularmoviedb.di.annotations.ActivityScope
import com.kt.thepopularmoviedb.view.ui.MovieDetailActivity
import com.kt.thepopularmoviedb.view.ui.main.MainActivity
import dagger.Module

import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityFragmentModule::class])
    internal abstract fun contributeMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun contributeMovieDetailActivity(): MovieDetailActivity

}
