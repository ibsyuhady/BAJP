package com.example.android.bajpsubmission.ui.tvshow

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.bajpsubmission.data.domain.TvShowModel
import junit.framework.TestCase.assertNotNull
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getListTvShow() {
        val tvShow = viewModel.getListTvShow()
        assertNotNull(tvShow)
        assertThat(10, `is`(tvShow?.size))
    }

    @Test
    fun getEmptyListTvShow() {
        val emptyListTvShow = emptyList<TvShowModel>()
        assertThat(0, `is`(emptyListTvShow.size))
    }
}