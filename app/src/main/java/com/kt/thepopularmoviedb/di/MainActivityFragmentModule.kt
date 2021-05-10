package com.kt.thepopularmoviedb.di

import com.kt.thepopularmoviedb.di.annotations.FragmentScope
import com.kt.thepopularmoviedb.view.ui.main.MovieListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeMovieListFragment(): MovieListFragment
}
