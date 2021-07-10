package com.apap.sudoku.di

import android.app.Application
import com.apap.sudoku.di.component.DaggerSudokuComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerSudokuComponent.builder().application(this).build().inject(this)
    }

    override fun androidInjector(): DispatchingAndroidInjector<Any> = androidInjector
}