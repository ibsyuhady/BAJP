package com.example.android.bajpsubmission.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowEntity(
    val tvShowId: Long? = 0,
    val title: String? = null,
    val currentSeason: String? = null,
    val description: String? = null,
    val poster: String? = null,
    val backdrop: String? = null,
    val creator: String? = null,
    val cast: String? = null
) : Parcelable
