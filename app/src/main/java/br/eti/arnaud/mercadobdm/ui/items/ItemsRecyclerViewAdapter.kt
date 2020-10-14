package br.eti.arnaud.mercadobdm.ui.items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.eti.arnaud.mercadobdm.R
import br.eti.arnaud.mercadobdm.model.Contact
import br.eti.arnaud.mercadobdm.model.Item
import kotlinx.android.synthetic.main.item_normal.view.*

class ItemsRecyclerViewAdapter: RecyclerView.Adapter<ItemsRecyclerViewAdapter.ViewHolder>() {

    var onItemClick: ((Item) -> Unit)? = null

    var items: List<Item> = ArrayList()
        set(value) {
            notifyDataSetChanged()
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_normal,
                parent,
                false
            )
        )
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].featured) FEATURED else NORMAL
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.itemView.itemTitleTextView.text = item.title
        holder.itemView.itemDescriptionTextView.text = item.description
        holder.itemView.contact1ImageView.setImageResource(
            if (item.contact.type == Contact.PHONE)
                R.drawable.ic_baseline_phone_24
            else
                R.drawable.ic_baseline_email_24
        )
        holder.itemView.contact1TextView.text = String.format(
            "${item.contact.address} ~ ${item.contact.name}"
        )
        holder.itemView.priceTextView.text = String.format(
            holder.itemView.resources.getString(
                R.string.bdm_2_lines,
                item.price,
                if (item.unit.isNotEmpty()) "/${item.unit}" else ""
            )
        )
        holder.itemView.setOnClickListener {
            onItemClick?.let { oic -> oic(item) }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    companion object {
        const val FEATURED = 1
        const val NORMAL = 0
    }

}