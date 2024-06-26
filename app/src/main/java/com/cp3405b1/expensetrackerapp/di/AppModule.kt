package com.cp3405b1.expensetrackerapp.di

import android.app.Application
import com.cp3405b1.expensetrackerapp.data.local.datastore.UIModeDataStore
import com.cp3405b1.expensetrackerapp.db.AppDatabase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@InstallIn(ActivityComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun providePreferenceManager(application: Application): UIModeDataStore {
        return UIModeDataStore(application.applicationContext)
    }

    @Singleton
    @Provides
    fun provideNoteDatabase(application: Application): AppDatabase {
        return AppDatabase.invoke(application.applicationContext)
    }
}
