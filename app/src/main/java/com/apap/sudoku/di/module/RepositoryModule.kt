package com.apap.sudoku.di.module

import com.apap.sudoku.data.source.repository.SudokuRepository
import com.apap.sudoku.data.source.repository.SudokuRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideSudokuRepository(sudokuRepository: SudokuRepositoryImpl) : SudokuRepository {
        return sudokuRepository
    }
}