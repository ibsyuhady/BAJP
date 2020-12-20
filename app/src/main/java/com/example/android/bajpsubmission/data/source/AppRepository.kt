package com.example.android.bajpsubmission.data.source

import androidx.lifecycle.LiveData
import com.example.android.bajpsubmission.data.NetworkBoundResource
import com.example.android.bajpsubmission.data.Resource
import com.example.android.bajpsubmission.data.domain.MoviesModel
import com.example.android.bajpsubmission.data.domain.TvShowModel
import com.example.android.bajpsubmission.data.source.local.LocalDataSource
import com.example.android.bajpsubmission.data.source.remote.RemoteDataSource
import com.example.android.bajpsubmission.data.source.remote.response.ApiResponse
import com.example.android.bajpsubmission.data.source.remote.response.MoviesResponse
import com.example.android.bajpsubmission.data.source.remote.response.TvShowResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : DataSource {

    // companion object {
    //     @Volatile
    //     private var instance: AppRepository? = null
    //
    //     fun getInstance(
    //         remoteDataSource: RemoteDataSource,
    //         localDataSource: LocalDataSource
    //     ): AppRepository =
    //         instance ?: synchronized(this) {
    //             instance ?: AppRepository(
    //                 remoteDataSource,
    //                 localDataSource
    //             )
    //         }
    // }

    // Log.d("Movie", response.value.toString())

    override fun fetchMovies(): LiveData<Resource<List<MoviesModel>>> {
        return object : NetworkBoundResource<List<MoviesModel>, List<MoviesResponse>>() {
            public override fun loadFromDB(): LiveData<List<MoviesModel>> =
                localDataSource.getListMovies()

            override fun shouldFetch(data: List<MoviesModel>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MoviesResponse>>> =
                remoteDataSource.fetchMovies()

            public override fun saveCallResult(data: List<MoviesResponse>) {
                val movieList = ArrayList<MoviesModel>()
                for (response in data) {
                    val movie = MoviesModel(
                        null,
                        response.moviesId,
                        response.title,
                        response.year,
                        response.overview,
                        response.poster,
                        response.backdrop,
                        response.rating,
                        false
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun fetchTvShow(): LiveData<Resource<List<TvShowModel>>> {
        return object : NetworkBoundResource<List<TvShowModel>, List<TvShowResponse>>() {
            public override fun loadFromDB(): LiveData<List<TvShowModel>> =
                localDataSource.getListTvShow()

            override fun shouldFetch(data: List<TvShowModel>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.fetchTvShow()

            public override fun saveCallResult(data: List<TvShowResponse>) {
                val tvShowList = ArrayList<TvShowModel>()
                for (response in data) {
                    val tvShow = TvShowModel(
                        null,
                        response.tvShowId,
                        response.title,
                        response.originalTitle,
                        response.year,
                        response.overview,
                        response.poster,
                        response.backdrop,
                        response.rating,
                        false
                    )
                    tvShowList.add(tvShow)
                }
                localDataSource.insertTvShow(tvShowList)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<List<MoviesModel>> =
        localDataSource.getFavoriteMovies()

    override fun getFavoriteTvShow(): LiveData<List<TvShowModel>> =
        localDataSource.getFavoriteTvShow()

    override fun setFavoriteMovieStatus(movie: MoviesModel) {
        CoroutineScope(IO).launch {
            localDataSource.updateFavoriteMovieStatus(movie)
        }
    }

    override fun setFavoriteTvShowStatus(tvShow: TvShowModel) {
        CoroutineScope(IO).launch {
            localDataSource.updateFavoriteTvShowStatus(tvShow)
        }
    }
}
