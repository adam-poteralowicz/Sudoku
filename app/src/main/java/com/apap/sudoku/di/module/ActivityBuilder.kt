package com.apap.sudoku.di.module

import android.app.Activity
import com.apap.sudoku.di.component.HomeActivityComponent
import com.apap.sudoku.di.component.SudokuActivityComponent
import com.apap.sudoku.view.game.activity.SudokuActivity
import com.apap.sudoku.view.home.activity.HomeActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(HomeActivity::class)
    abstract fun bindHomeActivity(builder: HomeActivityComponent.Builder) : AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @ActivityKey(SudokuActivity::class)
    abstract fun bindSudokuActivity(builder: SudokuActivityComponent.Builder) : AndroidInjector.Factory<out Activity>

}