package com.example.probando_jpc_mvvm.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumeroModelView:ViewModel() {

    //No hay reactividad hacia la vista
    var numero1: Int = 0
        private set

    fun incrementarNumero1() {
        numero1++
    }

    //Con reactividad hacia la vista usando un MutatableState

    var numero2 by mutableStateOf(0)
        private set
    fun incrementarNumero2() {
        numero2++
    }

    // Reactivo con LiveData
    private val _numero3 = MutableLiveData(0)
    val numero3: LiveData<Int> get() = _numero3

    fun incrementarNumero3() {
        _numero3.value = (_numero3.value ?: 0) + 1
    }

}