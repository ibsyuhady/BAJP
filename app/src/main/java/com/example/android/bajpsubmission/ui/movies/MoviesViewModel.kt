package com.example.android.bajpsubmission.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.bajpsubmission.data.Resource
import com.example.android.bajpsubmission.data.domain.MoviesModel
import com.example.android.bajpsubmission.data.source.AppRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MoviesViewModel @Inject constructor(private val appRepository: AppRepository) : ViewModel() {

    private val _movies = MutableLiveData<List<MoviesModel>>()
    val movies: LiveData<List<MoviesModel>>
        get() = _movies

    private var _response = MutableLiveData<Resource<List<MoviesModel>>>()
    val response: LiveData<Resource<List<MoviesModel>>>
        get() = _response

    fun getListMovies(): LiveData<Resource<List<MoviesModel>>> {
        viewModelScope.launch {
            try {
                if (_movies.value == null) {
                    _response =
                        appRepository.fetchMovies() as MutableLiveData<Resource<List<MoviesModel>>>
                    _movies.value = _response.value?.data
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return response
    }
}