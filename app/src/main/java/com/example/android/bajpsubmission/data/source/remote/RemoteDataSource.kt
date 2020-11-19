package com.example.android.bajpsubmission.data.source.remote

import com.example.android.bajpsubmission.data.source.remote.network.ApiService
import retrofit2.await

class RemoteDataSource {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    suspend fun fetchMovies(
        callback: FetchMoviesCallback
    ) {
        ApiService.create().getMovies().await().moviesResult?.let { listMovies ->
            callback.onAllMoviesReceived(
                listMovies
            )
        }
    }

    suspend fun fetchTvShow(
        callback: FetchTvShowCallback
    ) {
        ApiService.create().getTvShow().await().tvShowResult?.let { listTvShow ->
            callback.onAllTvShowReceived(
                listTvShow
            )
        }
    }

    interface FetchMoviesCallback {
        fun onAllMoviesReceived(moviesResponse: List<MoviesResponse>)
    }

    interface FetchTvShowCallback {
        fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse>)
    }
}