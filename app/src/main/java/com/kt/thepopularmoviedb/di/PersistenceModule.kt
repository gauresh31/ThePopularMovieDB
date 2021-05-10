package com.kt.thepopularmoviedb.di

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import com.kt.thepopularmoviedb.room.AppDatabase
import com.kt.thepopularmoviedb.room.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule {

    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, "TheMovies.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(@NonNull database: AppDatabase): MovieDao {
        return database.movieDao()
    }

}
