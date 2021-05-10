package com.kt.thepopularmoviedb.di

import com.kt.thepopularmoviedb.di.annotations.ActivityScope
import com.kt.thepopularmoviedb.di.annotations.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ComposeModule {

    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun contributeViewModelActivity(): ViewModelActivity

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeViewModelFragment(): ViewModelFragment
}
