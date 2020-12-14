package com.example.android.bajpsubmission.ui.movies.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.bajpsubmission.data.domain.MoviesModel
import com.example.android.bajpsubmission.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class DetailMoviesViewModelTest {

    private lateinit var viewModel: DetailMoviesViewModel
    private val dummyMovies = DataDummy.generateDummyMovies()[0]

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<MoviesModel>

    @Before
    fun setUp() {
        viewModel = DetailMoviesViewModel()
        viewModel.getDetailMovie(dummyMovies)
    }

    @Before
    fun setUpMockito() {
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun tearDownMockito() {
        Mockito.validateMockitoUsage()
    }

    @Test
    fun getDetailMovies() {
        val detailMovies = viewModel.detailMovies.value
        assertNotNull(detailMovies)
        assertThat(dummyMovies.moviesId, `is`(detailMovies?.moviesId))
        assertThat(dummyMovies.title, `is`(detailMovies?.title))
        assertThat(dummyMovies.year, `is`(detailMovies?.year))
        assertThat(dummyMovies.overview, `is`(detailMovies?.overview))
        assertThat(dummyMovies.poster, `is`(detailMovies?.poster))
        assertThat(dummyMovies.backdrop, `is`(detailMovies?.backdrop))
        assertThat(dummyMovies.rating, `is`(detailMovies?.rating))

        viewModel.detailMovies.observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}