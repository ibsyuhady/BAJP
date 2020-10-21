package com.example.android.bajpsubmission.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviesEntity(
    var moviesId: Long,
    var title: String,
    var year: String,
    var description: String,
    var poster: String,
    var backdrop: String,
    var director: String,
    var cast: String
) : Parcelable
