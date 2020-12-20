package com.example.android.bajpsubmission.data.domain

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "favorite_movies_table")
@Parcelize
data class MoviesModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var moviesId: Long? = 0,
    var title: String? = null,
    var year: String? = null,
    var overview: String? = null,
    var poster: String? = null,
    var backdrop: String? = null,
    var rating: Double? = null,
    var isFavorite: Boolean = false
) : Parcelable
