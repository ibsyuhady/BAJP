package com.example.android.bajpsubmission.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowEntity(
    var tvShowId: Long,
    var title: String,
    var currentSeason: String,
    var description: String,
    var poster: String,
    var backdrop: String,
    var creator: String,
    var cast: String
) : Parcelable
