package br.eti.arnaud.mercadobdm.ui.items.services

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import br.eti.arnaud.mercadobdm.BaseViewModel
import br.eti.arnaud.mercadobdm.model.Contact
import br.eti.arnaud.mercadobdm.model.Product
import br.eti.arnaud.mercadobdm.model.Service

class ServicesViewModel : BaseViewModel() {

    private val _services = MutableLiveData<ArrayList<Service>>()
    val services = Transformations.map(_services){
        it
    }

    fun loadServices() {
        _services.postValue(arrayListOf(
            Service("Faxina em qualquer lugar", "lavo banheiro, roupa, passo, cozinho e arruma a casa toda", "100", "hora", "", Contact("Maria Aparecida", Contact.EMAIL, "maria.aparecida.silva@gmail.com"), false)
        ))
    }

}