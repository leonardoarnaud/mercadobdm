package br.eti.arnaud.mercadobdm.ui.items

import android.content.Intent
import android.provider.ContactsContract
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.eti.arnaud.mercadobdm.R
import br.eti.arnaud.mercadobdm.model.Contact
import br.eti.arnaud.mercadobdm.ui.main.BaseFragment
import kotlinx.android.synthetic.main.fragment_products.*


abstract class ItemsFragment: BaseFragment(R.layout.fragment_products) {

    val itemsRecyclerViewAdapter = ItemsRecyclerViewAdapter()

    override fun setupView() {
        productsRecyclerView.apply{
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = itemsRecyclerViewAdapter
        }
    }

    override fun listeners() {
        itemsRecyclerViewAdapter.onItemClick = { product ->
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

}