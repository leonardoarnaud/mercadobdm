package br.eti.arnaud.mercadobdm.ui.items.products

import androidx.fragment.app.viewModels
import br.eti.arnaud.mercadobdm.ui.items.ItemsFragment

class ProductsFragment: ItemsFragment() {

    override val vm: ProductsViewModel by viewModels()

    override fun start() {
        vm.loadProducts()
    }

    override fun observers() {
        o(vm.products){
            itemsRecyclerViewAdapter.items = it
        }
    }

    companion object {
        fun newInstance() = ProductsFragment()
    }
}