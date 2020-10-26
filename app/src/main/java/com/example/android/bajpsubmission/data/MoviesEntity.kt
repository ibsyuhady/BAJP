package com.example.android.bajpsubmission.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviesEntity(
    var moviesId: Long? = 0,
    var title: String? = null,
    var year: String? = null,
    var description: String? = null,
    var poster: String? = null,
    var backdrop: String? = null,
    var director: String? = null,
    var cast: String? = null
) : Parcelable
