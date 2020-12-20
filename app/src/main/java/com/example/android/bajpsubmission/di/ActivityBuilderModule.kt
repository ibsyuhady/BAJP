package com.example.android.bajpsubmission.di

import com.example.android.bajpsubmission.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainFragmentBuilderModule::class])
    abstract fun contributeMainActivity(): MainActivity
}