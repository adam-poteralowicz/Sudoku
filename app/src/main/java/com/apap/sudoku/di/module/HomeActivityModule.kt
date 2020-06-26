package com.apap.sudoku.di.module

import com.apap.sudoku.view.home.activity.HomeActivity
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {

    @Provides
    fun provideMainView(homeActivity : HomeActivity) : HomeActivity {
        return homeActivity
    }
}