package com.example.android.bajpsubmission.ui.movies

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.bajpsubmission.data.domain.MoviesModel
import org.hamcrest.Matchers.`is`
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setUp() {
        viewModel = MoviesViewModel()
    }

    @Test
    fun getListMovies() {
        val movies = viewModel.getListMovies()
        assertNotNull(movies)
        assertThat(10, `is`(movies?.size))
    }

    @Test
    fun getEmptyListMovies() {
        val emptyListMovies = emptyList<MoviesModel>()
        assertThat(0, `is`(emptyListMovies.size))
    }
}