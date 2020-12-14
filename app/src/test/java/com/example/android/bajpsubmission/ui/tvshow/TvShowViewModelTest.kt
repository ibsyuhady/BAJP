package com.example.android.bajpsubmission.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.bajpsubmission.data.domain.TvShowModel
import com.example.android.bajpsubmission.data.source.AppRepository
import com.example.android.bajpsubmission.utils.DataDummy
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
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class TvShowViewModelTest {

    private val dummyTvShow = DataDummy.generateDummyTvShow()
    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: AppRepository

    @Mock
    private lateinit var observer: Observer<List<TvShowModel>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(appRepository)
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
    fun getListTvShow() {
        val tvShow = MutableLiveData<List<TvShowModel>>()
        tvShow.value = dummyTvShow
        `when`(appRepository.fetchTvShow()).thenReturn(tvShow)

        val tvShows = viewModel.getListTvShow().value
        verify(appRepository).fetchTvShow()
        assertNotNull(tvShows)
        assertThat(10, `is`(tvShows?.size))

        viewModel.getListTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }

    @Test
    fun getEmptyListTvShow() {
        val emptyListTvShow = emptyList<TvShowModel>()
        assertThat(0, `is`(emptyListTvShow.size))
    }
}