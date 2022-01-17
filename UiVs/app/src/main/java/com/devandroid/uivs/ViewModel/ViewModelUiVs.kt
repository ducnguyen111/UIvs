package com.devandroid.uivs.ViewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devandroid.uivs.Repsitory.Repository

class ViewModelUiVs(val application: Application):ViewModel() {
    private  val repository=Repository(application)
    val isChecked:LiveData<Boolean>
    init {
        isChecked=repository.isChecked
    }
    fun ischecksang(it:Boolean){
        repository.clickchecksang(it)
    }
    fun ischecktoi(it: Boolean){
        repository.clickchecktoi(it)
    }

}