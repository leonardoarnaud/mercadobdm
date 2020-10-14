package br.eti.arnaud.mercadobdm.ui.items.products

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import br.eti.arnaud.mercadobdm.BaseViewModel
import br.eti.arnaud.mercadobdm.model.Contact
import br.eti.arnaud.mercadobdm.model.Product

class ProductsViewModel : BaseViewModel() {

    private val _products = MutableLiveData<ArrayList<Product>>()
    val products = Transformations.map(_products){
        it
    }

    fun loadProducts() {
        _products.postValue(arrayListOf(
            Product("Vendo apartamento", "sala cozinha quarto banheiro tudo de bom", "10000", "m2", "", Contact("Leo", 0, "(21) 97266-8312"), false)
        ))
    }

}