package com.apap.sudoku.di.component

import com.apap.sudoku.di.App
import com.apap.sudoku.di.module.AppModule
import com.apap.sudoku.di.module.InteractorModule
import com.apap.sudoku.di.module.NetModule
import com.apap.sudoku.di.module.RepositoryModule
import com.apap.sudoku.view.game.activity.SudokuActivity
import dagger.Component

@Component(modules = [AppModule::class, RepositoryModule::class, NetModule::class, InteractorModule::class])
interface SudokuComponent {
    fun inject(app: App)
    fun inject(activity: SudokuActivity)
}