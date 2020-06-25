package com.apap.sudoku

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.apap.sudoku.view.game.activity.SudokuActivity
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SudokuActivityInstrumentedTest {

    @Rule @JvmField
    val activityRule : ActivityTestRule<SudokuActivity> = ActivityTestRule(SudokuActivity::class.java)

    @Test
    fun shouldShowEmptyBoardOnActivityStart() {
        onView(withId(R.id.sudoku_recycler_view)).check(matches(notNullValue()))
        onData(allOf(CoreMatchers.`is`(" ")))
    }

    @Test
    fun shouldShowPuzzleNotSolvedDialogOnCheckPuzzleClickWhenBoardHasBlanks() {
        onView(withId(R.id.check_puzzle_button)).perform(click())
        onView(withText(R.string.puzzle_not_solved_dialog_title)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldDisplayDigitChoiceDialogOnSudokuCellClick() {
        onView(withId(R.id.sudoku_recycler_view)).perform(click())

        onView(withText("1")).check(matches(isDisplayed()))
        onView(withText("2")).check(matches(isDisplayed()))
        onView(withText("3")).check(matches(isDisplayed()))
        onView(withText("4")).check(matches(isDisplayed()))
        onView(withText("5")).check(matches(isDisplayed()))
        onView(withText("6")).check(matches(isDisplayed()))
        onView(withText("7")).check(matches(isDisplayed()))
        onView(withText("8")).check(matches(isDisplayed()))
        onView(withText("9")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldDisplayDifficultyChoiceDialogOnGeneratePuzzleClick() {
        onView(withId(R.id.generate_puzzle_button)).perform(click())
        onView(withText(R.string.easy_difficulty_mode_text)).check(matches(isDisplayed()))
        onView(withText(R.string.medium_difficulty_mode_text)).check(matches(isDisplayed()))
        onView(withText(R.string.hard_difficulty_mode_text)).check(matches(isDisplayed()))
        onView(withText(R.string.random_difficulty_mode_text)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldDismissDigitChoiceDialogOnBackButtonClick() {
        onView(withId(R.id.sudoku_recycler_view)).perform(click())
        onView(withText(R.string.digit_1)).check(matches(isDisplayed()))
        onView(withText(R.string.digit_1)).perform(pressBack())
        onView(withId(R.id.sudoku_recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldDismissDifficultyChoiceDialogOnBackButtonClick() {
        onView(withId(R.id.generate_puzzle_button)).perform(click())
        onView(withText(R.string.easy_difficulty_mode_text)).check(matches(isDisplayed()))
        onView(withText(R.string.easy_difficulty_mode_text)).perform(pressBack())
        onView(withId(R.id.sudoku_recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldDismissPuzzleNotSolvedDialogOnBackButtonClick() {
        onView(withId(R.id.check_puzzle_button)).perform(click())
        onView(withText(R.string.puzzle_not_solved_dialog_title)).check(matches(isDisplayed()))
        onView(withText(R.string.puzzle_not_solved_dialog_title)).perform(pressBack())
        onView(withId(R.id.sudoku_recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldDismissPuzzleNotSolvedDialogOnOKClick() {
        onView(withId(R.id.check_puzzle_button)).perform(click())
        onView(withText(R.string.puzzle_not_solved_dialog_title)).check(matches(isDisplayed()))
        onView(withText(R.string.puzzle_not_solved_dialog_ok)).inRoot(RootMatchers.isDialog())
            .perform(click())
        onView(withId(R.id.sudoku_recycler_view)).check(matches(isDisplayed()))
    }
}