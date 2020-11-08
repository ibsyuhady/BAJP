package com.example.android.bajpsubmission.ui.tvshow.detail

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
class DetailTvShowViewModelTest {

    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel()
        viewModel.getDetailTvShow(dummyTvShow)
    }

    @Test
    fun getDetailTvShow() {
        val detailTvShow = viewModel.detailTvShow.value
        assertNotNull(detailTvShow)
        assertThat(dummyTvShow.tvShowId, `is`(detailTvShow?.tvShowId))
        assertThat(dummyTvShow.title, `is`(detailTvShow?.title))
        assertThat(dummyTvShow.currentSeason, `is`(detailTvShow?.currentSeason))
        assertThat(dummyTvShow.description, `is`(detailTvShow?.description))
        assertThat(dummyTvShow.poster, `is`(detailTvShow?.poster))
        assertThat(dummyTvShow.backdrop, `is`(detailTvShow?.backdrop))
        assertThat(dummyTvShow.creator, `is`(detailTvShow?.creator))
        assertThat(dummyTvShow.cast, `is`(detailTvShow?.cast))
    }
}