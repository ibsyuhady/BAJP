package com.example.android.bajpsubmission.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.android.bajpsubmission.R
import com.example.android.bajpsubmission.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.navigation_movies)).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size)
        )
    }

    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(9, click())
        )
        onView(withId(R.id.detail_movies_container)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_movies_container)).perform(swipeUp())
        onView(withId(R.id.img_detail_movies_backdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_movies_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_movies_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_movies_title)).check(matches(withText(dummyMovies[9].title)))
        onView(withId(R.id.tv_detail_movies_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_movies_release)).check(matches(withText(dummyMovies[9].year)))
        onView(withId(R.id.tv_detail_movies_director)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_movies_director)).check(matches(withText(dummyMovies[9].director)))
        onView(withId(R.id.tv_detail_movies_cast)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_movies_cast)).check(matches(withText(dummyMovies[9].cast)))
        onView(withId(R.id.tv_detail_movies_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_movies_overview)).check(matches(withText(dummyMovies[9].description)))
        pressBack()
    }

    @Test
    fun loadTvShow() {
        onView(withId(R.id.navigation_tv_show)).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size)
        )
    }

    @Test
    fun loadDetailTvShow() {
        onView(withId(R.id.navigation_tv_show)).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(9, click())
        )
        onView(withId(R.id.detail_tv_show_container)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tv_show_container)).perform(swipeUp())
        onView(withId(R.id.img_detail_tv_show_backdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_tv_show_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_tv_show_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_tv_show_title)).check(matches(withText(dummyTvShow[9].title)))
        onView(withId(R.id.tv_detail_tv_show_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_tv_show_release)).check(matches(withText(dummyTvShow[9].currentSeason)))
        onView(withId(R.id.tv_detail_tv_show_creator)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_tv_show_creator)).check(matches(withText(dummyTvShow[9].creator)))
        onView(withId(R.id.tv_detail_tv_show_cast)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_tv_show_cast)).check(matches(withText(dummyTvShow[9].cast)))
        onView(withId(R.id.tv_detail_tv_show_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_tv_show_overview)).check(matches(withText(dummyTvShow[9].description)))
        pressBack()
    }
}