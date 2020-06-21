package com.apap.sudoku.di.module

import com.apap.sudoku.view.game.activity.SudokuActivity
import dagger.Module
import dagger.Provides

@Module
class SudokuActivityModule {

    @Provides
    fun provideMainView(sudokuActivity : SudokuActivity) : SudokuActivity {
        return sudokuActivity
    }
}