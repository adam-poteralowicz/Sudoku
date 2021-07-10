package com.apap.sudoku.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apap.sudoku.viewmodel.SudokuViewModel
import com.apap.sudoku.viewmodel.ViewModelFactory
import com.apap.sudoku.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SudokuViewModel::class)
    abstract fun bindSudokuViewModel(sudokuViewModel: SudokuViewModel) : ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory
}