package com.example.android.bajpsubmission.di

import com.example.android.bajpsubmission.ui.movies.MoviesFragment
import com.example.android.bajpsubmission.ui.tvshow.TvShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuilderModule {

    @ContributesAndroidInjector()
    abstract fun contributeMovieFragment(): MoviesFragment

    @ContributesAndroidInjector()
    abstract fun contributeTvShowFragment(): TvShowFragment
}
