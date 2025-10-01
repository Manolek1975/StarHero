package com.delek.starhero.ui.star

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delek.starhero.R
import com.delek.starhero.domain.model.Planet

class PlanetAdapter(
    private var planets: List<Planet> = emptyList(),
    private val onItemClickListener: (Planet) -> Unit) :
    RecyclerView.Adapter<PlanetViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Planet>){
        planets = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        return PlanetViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_planet, parent, false)
        )
    }

    override fun getItemCount() = planets.size

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        holder.render(planets[position], onItemClickListener)
    }
}