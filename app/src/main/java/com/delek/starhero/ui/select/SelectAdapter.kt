package com.delek.starhero.ui.select

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delek.starhero.R
import com.delek.starhero.domain.model.Hero


class SelectAdapter (
    private var heroes: List<Hero> = emptyList(),
    private val onItemClickListener: (Hero) -> Unit) :
    RecyclerView.Adapter<SelectViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Hero>){
        heroes = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectViewHolder {
        return SelectViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        )
    }

    override fun getItemCount() = heroes.size

    override fun onBindViewHolder(holder: SelectViewHolder, position: Int) {
        holder.render(heroes[position], onItemClickListener)
    }
}