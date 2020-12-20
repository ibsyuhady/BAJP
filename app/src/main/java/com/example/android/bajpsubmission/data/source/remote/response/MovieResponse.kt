package com.example.android.bajpsubmission.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponseContainer<T>(
    @SerializedName("results")
    val moviesResult: List<T>? = null
)

data class MoviesResponse(

    @field:SerializedName("id")
    val moviesId: Long? = 0,

    val title: String? = null,

    @field:SerializedName("release_date")
    val year: String? = null,

    @field:SerializedName("overview")
    val overview: String? = null,

    @field:SerializedName("poster_path")
    val poster: String? = null,

    @field:SerializedName("backdrop_path")
    val backdrop: String? = null,

    @field:SerializedName("vote_average")
    val rating: Double? = null
)
