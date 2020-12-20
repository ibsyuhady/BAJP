package com.example.android.bajpsubmission.di

import android.app.Application
import android.content.Context
import com.example.android.bajpsubmission.data.source.AppRepository
import com.example.android.bajpsubmission.data.source.local.AppDatabase
import com.example.android.bajpsubmission.data.source.local.LocalDataSource
import com.example.android.bajpsubmission.data.source.local.dao.AppDao
import com.example.android.bajpsubmission.data.source.remote.RemoteDataSource
import com.example.android.bajpsubmission.data.source.remote.network.ApiService
import com.example.android.bajpsubmission.utils.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    companion object {

        @Singleton
        @Provides
        fun provideContext(application: Application): Context =
            application.applicationContext

        @Singleton
        @Provides
        fun provideAppDatabase(application: Application): AppDatabase =
            AppDatabase.getInstance(application)

        @Singleton
        @Provides
        fun provideAppDao(appDatabase: AppDatabase): AppDao =
            appDatabase.appDao

        @Singleton
        @Provides
        fun provideLocalDataSource(appDao: AppDao): LocalDataSource =
            LocalDataSource(appDao)

        @Singleton
        @Provides
        fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource =
            RemoteDataSource(apiService)

        @Singleton
        @Provides
        fun provideAppRepository(
            remoteDataSource: RemoteDataSource,
            localDataSource: LocalDataSource
        ): AppRepository = AppRepository(remoteDataSource, localDataSource)

        @Singleton
        @Provides
        fun provideViewModelFactory(appRepository: AppRepository): ViewModelFactory =
            ViewModelFactory(appRepository)
    }
}
