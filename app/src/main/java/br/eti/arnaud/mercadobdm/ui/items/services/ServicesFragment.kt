package br.eti.arnaud.mercadobdm.ui.items.services

import androidx.fragment.app.viewModels
import br.eti.arnaud.mercadobdm.ui.items.ItemsFragment

class ServicesFragment: ItemsFragment() {

    override val vm: ServicesViewModel by viewModels()

    override fun start() {
        vm.loadServices()
    }

    override fun observers() {
        o(vm.services){
            itemsRecyclerViewAdapter.items = it
        }
    }

    companion object {
        fun newInstance() = ServicesFragment()
    }
}