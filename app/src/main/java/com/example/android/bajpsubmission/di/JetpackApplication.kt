package com.example.android.bajpsubmission.di

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class JetpackApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().application(this).build()
    // override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    //     val appComponent = DaggerAppComponent.builder().application(this).build()
    //     appComponent.inject(this)
    //     return appComponent
    // }
}