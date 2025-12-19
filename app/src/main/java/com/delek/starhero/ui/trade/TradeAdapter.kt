package com.delek.starhero.ui.trade

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delek.starhero.R
import com.delek.starhero.domain.model.Treasure

class TradeAdapter(
    private var items: List<Treasure> = emptyList(),
    private val onItemClickListener: (Treasure) -> Unit) :
    RecyclerView.Adapter<TradeViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Treasure>) {
        items = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TradeViewHolder {
        return TradeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_treasure, parent, false)
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: TradeViewHolder, position: Int) {
        holder.render(items[position], onItemClickListener)
    }

}