package com.apap.sudoku.di.component

import com.apap.sudoku.di.module.HomeActivityModule
import com.apap.sudoku.view.home.HomeActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [HomeActivityModule::class])
interface HomeActivityComponent : AndroidInjector<HomeActivity?> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<HomeActivity?>()

}