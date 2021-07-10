package com.apap.sudoku.di.component

import com.apap.sudoku.di.module.HomeActivityModule
import com.apap.sudoku.view.home.activity.HomeActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [HomeActivityModule::class])
interface HomeActivityComponent : AndroidInjector<HomeActivity?> {

    @Subcomponent.Factory
    abstract class Factory : AndroidInjector.Factory<HomeActivity?>
}