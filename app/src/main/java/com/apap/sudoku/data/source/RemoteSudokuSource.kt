package com.apap.sudoku.data.source

import com.apap.sudoku.data.model.SudokuBoardResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteSudokuSource {

    @GET("/board")
    fun getSudoku(@Query("difficulty") difficulty : String): Call<SudokuBoardResponse>

    companion object Factory {
        private const val baseUrl = "https://sugoku.herokuapp.com"

        fun create(): RemoteSudokuSource {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()

            return retrofit.create(RemoteSudokuSource::class.java)
        }
    }
}