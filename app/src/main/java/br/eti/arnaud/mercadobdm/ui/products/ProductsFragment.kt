package br.eti.arnaud.mercadobdm.ui.products

import android.content.Intent
import android.provider.ContactsContract
import android.provider.ContactsContract.CommonDataKinds
import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.eti.arnaud.mercadobdm.R
import br.eti.arnaud.mercadobdm.model.Contact
import br.eti.arnaud.mercadobdm.ui.main.BaseFragment
import kotlinx.android.synthetic.main.fragment_products.*


class ProductsFragment: BaseFragment(R.layout.fragment_products) {

    override val vm: ProductsViewModel by viewModels()
    private val productsRecyclerViewAdapter = ProductsRecyclerViewAdapter()

    override fun setupView() {
        productsRecyclerView.apply{
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = productsRecyclerViewAdapter
        }
    }

    override fun start() {
        vm.loadProducts()
    }

    override fun listeners() {
        productsRecyclerViewAdapter.onItemClick = { product ->
            when(product.contact.type){
                Contact.PHONE -> ContactsContract.Intents.Insert.PHONE
                Contact.EMAIL -> ContactsContract.Intents.Insert.EMAIL
                else -> null
            }?.let{
                startActivity(Intent(ContactsContract.Intents.Insert.ACTION).apply {
                    type = ContactsContract.RawContacts.CONTENT_TYPE
                    putExtra(it, product.contact.address)
                    putExtra(ContactsContract.Intents.Insert.NAME, product.contact.name)
                })
            }
        }
    }

    override fun observers() {
        o(vm.products){
            productsRecyclerViewAdapter.products = it
        }
    }

    companion object {
        fun newInstance() = ProductsFragment()
    }
}