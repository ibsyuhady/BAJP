package com.example.android.bajpsubmission.data.domain

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "favorite_tv_show_table")
@Parcelize
data class TvShowModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var tvShowId: Long? = 0,
    var title: String? = null,
    var originalTitle: String? = null,
    var year: String? = null,
    var overview: String? = null,
    var poster: String? = null,
    var backdrop: String? = null,
    var rating: Double? = null,
    var isFavorite: Boolean = false
) : Parcelable
