package com.example.android.bajpsubmission.data.source.remote

import com.google.gson.annotations.SerializedName

data class TvShowResponseContainer<T>(
    @SerializedName("results")
    val tvShowResult: List<T>? = null
)

data class TvShowResponse(

    @field:SerializedName("id")
    val tvShowId: Long? = 0,

    @field:SerializedName("name")
    val title: String? = null,

    @field:SerializedName("original_name")
    val originalTitle: String? = null,

    @field:SerializedName("first_air_date")
    val year: String? = null,

    @field:SerializedName("overview")
    val overview: String? = null,

    @field:SerializedName("poster_path")
    val poster: String? = null,

    @field:SerializedName("backdrop_path")
    val backdrop: String? = null,

    @field:SerializedName("vote_average")
    val rating: Double? = null,
)
