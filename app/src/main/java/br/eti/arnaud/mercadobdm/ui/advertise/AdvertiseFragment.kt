package br.eti.arnaud.mercadobdm.ui.advertise

import androidx.fragment.app.viewModels
import br.eti.arnaud.mercadobdm.R
import br.eti.arnaud.mercadobdm.ui.main.BaseFragment

class AdvertiseFragment: BaseFragment(R.layout.fragment_advertise){

    override val vm: AdvertiseViewModel by viewModels()

    override fun setupView() {

    }

    override fun start() {

    }

    override fun listeners() {

    }

    override fun observers() {

    }

    companion object {
        fun newInstance() = AdvertiseFragment()
    }
}