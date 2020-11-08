package com.example.android.bajpsubmission.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviesEntity(
    val moviesId: Long? = 0,
    val title: String? = null,
    val year: String? = null,
    val description: String? = null,
    val poster: String? = null,
    val backdrop: String? = null,
    val director: String? = null,
    val cast: String? = null
) : Parcelable
