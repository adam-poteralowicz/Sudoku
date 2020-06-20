package com.apap.sudoku.di

import android.app.Application
import com.apap.sudoku.di.component.DaggerSudokuComponent
import com.apap.sudoku.di.component.SudokuComponent
import com.apap.sudoku.di.module.AppModule

class App : Application() {

    private val component: SudokuComponent by lazy {
        DaggerSudokuComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}