package com.apap.sudoku.di.component

import com.apap.sudoku.di.App
import com.apap.sudoku.di.module.ActivityBuilder
import com.apap.sudoku.di.module.AppModule
import com.apap.sudoku.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityBuilder::class, AndroidInjectionModule::class, AppModule::class, ViewModelModule::class])
interface SudokuComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(app: App) : Builder
        fun build() : SudokuComponent
    }

    override fun inject(app: App)
}