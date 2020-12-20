package com.example.android.bajpsubmission.di

import com.example.android.bajpsubmission.BuildConfig.BASE_URL
import com.example.android.bajpsubmission.data.source.remote.network.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NewtworkModule {

    companion object {

        @Singleton
        @Provides
        fun provideRetrofitInstance(): ApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}
