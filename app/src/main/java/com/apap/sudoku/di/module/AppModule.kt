package com.apap.sudoku.di.module

import com.apap.sudoku.di.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideApp() = app
}