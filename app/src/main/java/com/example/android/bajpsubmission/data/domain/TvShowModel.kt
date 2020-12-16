package com.example.android.bajpsubmission.data.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowModel(
    val tvShowId: Long? = 0,
    val title: String? = null,
    val originalTitle: String? = null,
    val year: String? = null,
    val overview: String? = null,
    val poster: String? = null,
    val backdrop: String? = null,
    val rating: Double? = null,
) : Parcelable
