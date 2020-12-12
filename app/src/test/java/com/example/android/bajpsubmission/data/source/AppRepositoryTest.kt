package com.example.android.bajpsubmission.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.android.bajpsubmission.LiveDataTestUtil
import com.example.android.bajpsubmission.data.source.remote.RemoteDataSource
import com.example.android.bajpsubmission.utils.DataDummy
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matchers.`is`
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertThat
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class AppRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val appRepository = FakeAppRepository(remote)

    private val moviesResponse = DataDummy.generateRemoteDummyMovies()
    private val tvShowResponse = DataDummy.generateRemoteDummyTvShow()

    @Test
    fun fetchMovies() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[0] as RemoteDataSource.FetchMoviesCallback).onAllMoviesReceived(
                    moviesResponse
                )
                null
            }.`when`(remote).fetchMovies(any())
            val data = LiveDataTestUtil.getValue(appRepository.fetchMovies())
            runBlocking {
                verify(remote).fetchMovies(any())
            }
            assertNotNull(data)
            assertThat(
                moviesResponse.size.toLong(), `is`(data.size.toLong())
            )
        }
    }

    @Test
    fun fetchTvShow() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[0] as RemoteDataSource.FetchTvShowCallback).onAllTvShowReceived(
                    tvShowResponse
                )
                null
            }.`when`(remote).fetchTvShow(any())
            val data = LiveDataTestUtil.getValue(appRepository.fetchTvShow())
            runBlocking {
                verify(remote).fetchTvShow(any())
            }
            assertNotNull(data)
            assertThat(
                tvShowResponse.size.toLong(), `is`(data.size.toLong())
            )
        }
    }
}