package com.apap.sudoku.di.module

import com.apap.sudoku.view.game.activity.SudokuActivity
import com.apap.sudoku.view.home.activity.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindHomeActivity() : HomeActivity

    @ContributesAndroidInjector
    abstract fun bindSudokuActivity() : SudokuActivity
}