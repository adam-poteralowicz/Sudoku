package com.apap.sudoku.di.module

import com.apap.sudoku.data.interactor.GetSudokuForDifficultyInteractor
import com.apap.sudoku.data.source.repository.SudokuRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides @Singleton
    fun provideGetSudokuForDifficultyInteractor(sudokuRepository: SudokuRepository) : GetSudokuForDifficultyInteractor {
        return GetSudokuForDifficultyInteractor(sudokuRepository)
    }
}