package com.example.android.bajpsubmission.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.android.bajpsubmission.data.domain.MoviesModel
import com.example.android.bajpsubmission.data.source.AppRepository
import com.example.android.bajpsubmission.utils.DataDummy
import org.hamcrest.Matchers.`is`
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private val dummyMovies = DataDummy.generateDummyMovies()
    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: AppRepository

    @Mock
    private lateinit var observer: Observer<List<MoviesModel>>

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(appRepository)
    }

    @Test
    fun getListMovies() {
        val movie = MutableLiveData<List<MoviesModel>>()
        movie.value = dummyMovies
        `when`(appRepository.fetchMovies()).thenReturn(movie)

        val movies = viewModel.getListMovies().value
        verify(appRepository).fetchMovies()
        assertNotNull(movies)
        assertThat(10, `is`(movies?.size))

        viewModel.getListMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun getEmptyListMovies() {
        val emptyListMovies = emptyList<MoviesModel>()
        assertThat(0, `is`(emptyListMovies.size))
    }
}