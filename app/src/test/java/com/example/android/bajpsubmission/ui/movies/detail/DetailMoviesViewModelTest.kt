package com.example.android.bajpsubmission.ui.movies.detail

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.bajpsubmission.utils.DataDummy
import junit.framework.TestCase.assertNotNull
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class DetailMoviesViewModelTest {

    private lateinit var viewModel: DetailMoviesViewModel
    private val dummyMovies = DataDummy.generateDummyMovies()[0]

    @Before
    fun setUp() {
        viewModel = DetailMoviesViewModel()
        viewModel.getDetailMovie(dummyMovies)
    }

    @Test
    fun getDetailMovies() {
        val detailMovies = viewModel.detailMovies.value
        assertNotNull(detailMovies)
        assertThat(dummyMovies.moviesId, `is`(detailMovies?.moviesId))
        assertThat(dummyMovies.title, `is`(detailMovies?.title))
        assertThat(dummyMovies.year, `is`(detailMovies?.year))
        assertThat(dummyMovies.description, `is`(detailMovies?.description))
        assertThat(dummyMovies.poster, `is`(detailMovies?.poster))
        assertThat(dummyMovies.backdrop, `is`(detailMovies?.backdrop))
        assertThat(dummyMovies.director, `is`(detailMovies?.director))
        assertThat(dummyMovies.cast, `is`(detailMovies?.cast))
    }
}