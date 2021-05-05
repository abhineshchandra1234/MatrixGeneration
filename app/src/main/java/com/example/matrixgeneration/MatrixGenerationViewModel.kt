package com.example.matrixgeneration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MatrixGenerationViewModel : ViewModel() {

    val number = MutableLiveData<Int>()

    fun getNumber(): LiveData<Int> {
        return number
    }
}