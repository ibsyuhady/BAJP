package com.example.android.bajpsubmission.data.source.remote.network

import com.example.android.bajpsubmission.BuildConfig.API_KEY
import com.example.android.bajpsubmission.data.source.remote.response.MovieResponseContainer
import com.example.android.bajpsubmission.data.source.remote.response.MoviesResponse
import com.example.android.bajpsubmission.data.source.remote.response.TvShowResponse
import com.example.android.bajpsubmission.data.source.remote.response.TvShowResponseContainer
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    // companion object {
    //     fun create(): ApiService {
    //         return Retrofit.Builder()
    //             .baseUrl(BASE_URL)
    //             .addConverterFactory(GsonConverterFactory.create())
    //             .build()
    //             .create(ApiService::class.java)
    //     }
    // }

    @GET("movie/now_playing?api_key=$API_KEY")
    fun getMovies(): Call<MovieResponseContainer<MoviesResponse>>

    @GET("tv/on_the_air?api_key=$API_KEY")
    fun getTvShow(): Call<TvShowResponseContainer<TvShowResponse>>
}