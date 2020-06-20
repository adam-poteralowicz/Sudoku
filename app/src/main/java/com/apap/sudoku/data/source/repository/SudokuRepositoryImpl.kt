package com.apap.sudoku.data.source.repository

import com.apap.sudoku.data.model.SudokuBoardResponse
import com.apap.sudoku.data.source.RemoteSudokuSource
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class SudokuRepositoryImpl : SudokuRepository {

    override fun getSudoku(difficultyMode: String): Observable<SudokuBoardResponse> {
        val remoteSudokuSource = RemoteSudokuSource.create()
        val call = remoteSudokuSource.getSudoku(difficultyMode)
        var responseData : Observable<SudokuBoardResponse> = Observable.empty()

        call.enqueue(object: Callback<SudokuBoardResponse> {

            override fun onFailure(call: Call<SudokuBoardResponse>, t: Throwable) {
                Timber.e("getSudoku -- Failure : $t")
            }

            override fun onResponse(
                call: Call<SudokuBoardResponse>,
                response: Response<SudokuBoardResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    responseData = Observable.just(response.body())
                }
            }
        })

        return responseData
    }
}