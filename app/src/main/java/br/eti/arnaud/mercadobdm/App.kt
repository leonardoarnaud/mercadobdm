package br.eti.arnaud.mercadobdm

import android.app.Application
import br.eti.arnaud.mercadobdm.ui.main.MainViewModel
import br.eti.arnaud.mercadobdm.ui.items.products.ProductsViewModel

class App: Application() {

    override fun onCreate() {
        super.onCreate()
    }

    companion object{

        val applicationViewModels = arrayListOf(
            ProductsViewModel::class.java,
            MainViewModel::class.java,
        )
    }
}