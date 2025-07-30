package com.delek.starhero.ui.selection

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delek.starhero.R
import com.delek.starhero.domain.model.Hero

class HeroAdapter (private var heroes: List<Hero> = emptyList()) :
    RecyclerView.Adapter<HeroViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Hero>){
        heroes = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        )
    }

    override fun getItemCount() = heroes.size

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.render(heroes[position])
    }
}