package br.eti.arnaud.mercadobdm

import android.util.Log
import androidx.annotation.StringRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel(){

    val message = MutableLiveData<@StringRes Int>()

    fun test(){
        Log.i("a","a")
    }

}