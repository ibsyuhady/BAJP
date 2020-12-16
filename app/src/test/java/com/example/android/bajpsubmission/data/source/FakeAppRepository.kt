package com.example.android.bajpsubmission.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.bajpsubmission.data.domain.MoviesModel
import com.example.android.bajpsubmission.data.domain.TvShowModel
import com.example.android.bajpsubmission.data.source.remote.MoviesResponse
import com.example.android.bajpsubmission.data.source.remote.RemoteDataSource
import com.example.android.bajpsubmission.data.source.remote.TvShowResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class FakeAppRepository(
    private val remoteDataSource: RemoteDataSource
) : DataSource {

    override fun fetchMovies(): LiveData<List<MoviesModel>> {
        val listMovies = MutableLiveData<List<MoviesModel>>()
        CoroutineScope(IO).launch {
            remoteDataSource.fetchMovies(object : RemoteDataSource.FetchMoviesCallback {
                override fun onAllMoviesReceived(moviesResponse: List<MoviesResponse>) {
                    val movieList = ArrayList<MoviesModel>()
                    for (response in moviesResponse) {
                        val movie = MoviesModel(
                            response.moviesId,
                            response.title,
                            response.year,
                            response.overview,
                            response.poster,
                            response.backdrop,
                            response.rating
                        )
                        movieList.add(movie)
                    }
                    listMovies.postValue(movieList)
                }
            })
        }
        return listMovies
    }

    override fun fetchTvShow(): LiveData<List<TvShowModel>> {
        val listTvShow = MutableLiveData<List<TvShowModel>>()
        CoroutineScope(IO).launch {
            remoteDataSource.fetchTvShow(object : RemoteDataSource.FetchTvShowCallback {
                override fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse>) {
                    val tvShowList = ArrayList<TvShowModel>()
                    for (response in tvShowResponse) {
                        val tvShow = TvShowModel(
                            response.tvShowId,
                            response.title,
                            response.originalTitle,
                            response.year,
                            response.overview,
                            response.poster,
                            response.backdrop,
                            response.rating
                        )
                        tvShowList.add(tvShow)
                    }
                    listTvShow.postValue(tvShowList)
                }
            })
        }
        return listTvShow
    }
}
