package com.apap.sudoku.di.module

import com.apap.sudoku.data.interactor.GetSudokuForDifficultyInteractor
import com.apap.sudoku.data.source.repository.SudokuRepositoryImpl
import com.apap.sudoku.di.component.HomeActivityComponent
import com.apap.sudoku.di.component.SudokuActivityComponent
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(subcomponents = [HomeActivityComponent::class, SudokuActivityComponent::class])
class AppModule {

    private val baseUrl = "https://sugoku.herokuapp.com"

    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideSudokuRepository() : SudokuRepositoryImpl = SudokuRepositoryImpl()

    @Provides
    @Singleton
    fun provideGetSudokuForDifficultyInteractor(sudokuRepository: SudokuRepositoryImpl) : GetSudokuForDifficultyInteractor {
        return GetSudokuForDifficultyInteractor(sudokuRepository)
    }

}