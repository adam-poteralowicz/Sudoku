package com.apap.sudoku.di.component

import com.apap.sudoku.di.module.SudokuActivityModule
import com.apap.sudoku.view.game.activity.SudokuActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [SudokuActivityModule::class])
interface SudokuActivityComponent : AndroidInjector<SudokuActivity?> {

    @Subcomponent.Factory
    abstract class Factory : AndroidInjector.Factory<SudokuActivity?>
}