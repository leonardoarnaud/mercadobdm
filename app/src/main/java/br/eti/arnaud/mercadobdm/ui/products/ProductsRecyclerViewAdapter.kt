package br.eti.arnaud.mercadobdm.ui.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.eti.arnaud.mercadobdm.R
import br.eti.arnaud.mercadobdm.model.Product
import kotlinx.android.synthetic.main.item_normal_product.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ProductsRecyclerViewAdapter: RecyclerView.Adapter<ProductsRecyclerViewAdapter.ViewHolder>() {

    var onItemClick: ((Product) -> Unit)? = null

    var products: List<Product> = ArrayList()
        set(value) {
            notifyDataSetChanged()
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_normal_product,
                parent,
                false
            )
        )
    }

    override fun getItemViewType(position: Int): Int {
        return if (products[position].featured) FEATURED else NORMAL
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = products[position]
        holder.itemView.itemTitleTextView.text = item.title
        holder.itemView.itemDescriptionTextView.text = item.description
        holder.itemView.contact1ImageView.setImageResource(R.drawable.ic_baseline_phone_24)
        holder.itemView.contact1TextView.text = String.format(
            "${item.contact.address} ~ ${item.contact.name}"
        )
        holder.itemView.priceTextView.text = String.format(holder.itemView.resources.getString(
            R.string.bdm_2_lines, item.price)
        )
        holder.itemView.setOnClickListener {
            onItemClick?.let { oic -> oic(item) }
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    companion object {
        const val FEATURED = 1
        const val NORMAL = 0
    }

}