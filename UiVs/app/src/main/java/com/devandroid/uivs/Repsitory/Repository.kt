package com.devandroid.uivs.Repsitory

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.MutableLiveData

class Repository(val application: Application) {
     val isChecked=MutableLiveData<Boolean>()

    fun clickchecksang(it:Boolean):Boolean{
        if (it){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            return true.also { isChecked.value = it }

        }
        else{
            Log.d(TAG, "clickcheck: ",)
           return false.also { isChecked.value = it }
        }
    }
    fun clickchecktoi(it1: Boolean): Boolean {
        if (it1){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            return true.also { isChecked.value = it1 }

        }
        else{
            Log.d(TAG, "clickcheck: ",)
            return false.also { isChecked.value = it1 }
        }
    }
}