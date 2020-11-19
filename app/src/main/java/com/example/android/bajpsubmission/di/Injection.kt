package com.example.android.bajpsubmission.di

import com.example.android.bajpsubmission.data.source.AppRepository
import com.example.android.bajpsubmission.data.source.remote.RemoteDataSource

object Injection {

    fun provideRepository(): AppRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return AppRepository.getInstance(remoteDataSource)
    }
}