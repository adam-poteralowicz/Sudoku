package com.apap.sudoku.data.source.repository

import androidx.lifecycle.MutableLiveData
import com.apap.sudoku.data.model.SudokuBoardResponse
import com.apap.sudoku.data.source.RemoteSudokuSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class SudokuRepositoryImpl : SudokuRepository {

    override fun getSudoku(difficultyMode: String): MutableLiveData<SudokuBoardResponse> {
        val remoteSudokuSource = RemoteSudokuSource.create()
        val call = remoteSudokuSource.getSudoku(difficultyMode)
        val responseData : MutableLiveData<SudokuBoardResponse> = MutableLiveData()

        call.enqueue(object: Callback<SudokuBoardResponse> {

            override fun onFailure(call: Call<SudokuBoardResponse>, t: Throwable) {
                Timber.e("${javaClass.name}|| getSudoku -- Failure : $t")
            }

            override fun onResponse(
                call: Call<SudokuBoardResponse>,
                response: Response<SudokuBoardResponse>
            ) {
                if (response.isSuccessful) {
                    responseData.value = response.body()
                }
            }
        })

        return responseData
    }
}