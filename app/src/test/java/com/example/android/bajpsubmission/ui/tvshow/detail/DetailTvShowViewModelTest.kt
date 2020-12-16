package com.example.android.bajpsubmission.ui.tvshow.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.bajpsubmission.data.domain.TvShowModel
import com.example.android.bajpsubmission.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
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
class DetailTvShowViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]

    @Mock
    private lateinit var observer: Observer<TvShowModel>

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel()
        viewModel.getDetailTvShow(dummyTvShow)
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
    fun getDetailTvShow() {
        val detailTvShow = viewModel.detailTvShow.value
        assertNotNull(detailTvShow)
        assertThat(dummyTvShow.tvShowId, `is`(detailTvShow?.tvShowId))
        assertThat(dummyTvShow.title, `is`(detailTvShow?.title))
        assertThat(dummyTvShow.originalTitle, `is`(detailTvShow?.originalTitle))
        assertThat(dummyTvShow.year, `is`(detailTvShow?.year))
        assertThat(dummyTvShow.overview, `is`(detailTvShow?.overview))
        assertThat(dummyTvShow.poster, `is`(detailTvShow?.poster))
        assertThat(dummyTvShow.backdrop, `is`(detailTvShow?.backdrop))
        assertThat(dummyTvShow.rating, `is`(detailTvShow?.rating))

        viewModel.detailTvShow.observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}