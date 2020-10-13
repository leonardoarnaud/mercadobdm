package br.eti.arnaud.mercadobdm.ui.main

import androidx.lifecycle.MutableLiveData
import br.eti.arnaud.mercadobdm.BaseViewModel
import br.eti.arnaud.mercadobdm.R

class MainViewModel : BaseViewModel() {

    val testLabel = MutableLiveData<String>()

    fun showAppName() {
        message.postValue(R.string.app_name)
    }

    fun showTestLabel() {
        testLabel.postValue("Label Testada em ${System.currentTimeMillis()}")
    }

}