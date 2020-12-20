package com.example.android.bajpsubmission.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.bajpsubmission.data.source.remote.network.ApiService
import com.example.android.bajpsubmission.data.source.remote.response.ApiResponse
import com.example.android.bajpsubmission.data.source.remote.response.MoviesResponse
import com.example.android.bajpsubmission.data.source.remote.response.TvShowResponse
import com.example.android.bajpsubmission.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.await
import java.io.IOException
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    // companion object {
    //     @Volatile
    //     private var instance: RemoteDataSource? = null
    //
    //     fun getInstance(apiService: ApiService): RemoteDataSource =
    //         instance ?: synchronized(this) {
    //             instance ?: RemoteDataSource(apiService)
    //         }
    // }

    fun fetchMovies(): LiveData<ApiResponse<List<MoviesResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MoviesResponse>>>()

        CoroutineScope(IO).launch {
            try {
                // val response = apiService.getMovies().await()
                val response = apiService.getMovies().await().moviesResult!!
                Log.d("Movie", response.toString())
                resultMovie.postValue(ApiResponse.success(response))
            } catch (e: IOException) {
                e.printStackTrace()
                resultMovie.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return resultMovie
    }

    fun fetchTvShow(): LiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        CoroutineScope(IO).launch {
            try {
                val response = apiService.getTvShow().await()
                resultTvShow.postValue(ApiResponse.success(response.tvShowResult!!))
            } catch (e: IOException) {
                e.printStackTrace()
                resultTvShow.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return resultTvShow
    }
}
