package com.helani.mob_assignment1.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var result = MutableLiveData<Double> (0.0)

    fun add(num1: Double, num2: Double){
        result.value = num1.plus(num2)
        Log.d("Add Result", result.value.toString())
    }

    fun sub(num1: Double, num2: Double){
        result.value = num1.minus(num2)
        Log.d("Subtract Result", result.value.toString())
    }

    fun multiply(num1: Double, num2: Double){
        result.value = num1.times(num2)
        Log.d("Multiply Result", result.value.toString())
    }

    fun divide(num1: Double, num2: Double){
        result.value = num1.div(num2)
        Log.d("Multiply Result", result.value.toString())
    }

}