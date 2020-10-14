package br.eti.arnaud.mercadobdm.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import br.eti.arnaud.mercadobdm.R
import br.eti.arnaud.mercadobdm.ui.advertise.AdvertiseFragment
import br.eti.arnaud.mercadobdm.ui.items.products.ProductsFragment
import br.eti.arnaud.mercadobdm.ui.items.services.ServicesFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: BaseFragment(R.layout.fragment_main) {

    override val vm: MainViewModel by viewModels()

    override fun setupView() {
        mainBottomNavigation.selectedItemId = R.id.productsItem
    }

    override fun start() {

    }

    override fun listeners() {
        mainBottomNavigation.apply {
            setOnNavigationItemSelectedListener {
                childFragmentManager.beginTransaction().replace(
                    R.id.navigationContainerFrameLayout,
                    when (it.itemId) {
                        R.id.productsItem -> ProductsFragment.newInstance()
                        R.id.servicesItem -> ServicesFragment.newInstance()
                        R.id.advertiseItem -> AdvertiseFragment.newInstance()
                        else -> Fragment()
                    }
                ).commitAllowingStateLoss()
                true
            }
            selectedItemId = R.id.productsItem
        }
    }

    override fun observers() {

    }

    companion object {
        fun newInstance() = MainFragment()
    }
}