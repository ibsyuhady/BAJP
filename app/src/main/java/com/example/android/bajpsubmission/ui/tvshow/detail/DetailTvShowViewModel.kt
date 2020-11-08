package com.example.android.bajpsubmission.ui.tvshow.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.bajpsubmission.data.TvShowEntity

class DetailTvShowViewModel : ViewModel() {

    private val _detailTvShow = MutableLiveData<TvShowEntity>()
    val detailTvShow: LiveData<TvShowEntity> = _detailTvShow

    fun getDetailTvShow(tvShow: TvShowEntity?) {
        if (_detailTvShow.value == null) {
            _detailTvShow.value = tvShow
        }
    }
}
