package com.delek.starhero.ui.star

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.starhero.R
import com.delek.starhero.core.Util
import com.delek.starhero.databinding.ItemPlanetBinding
import com.delek.starhero.domain.model.Planet


class PlanetViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemPlanetBinding.bind(view)

    fun render(planet: Planet, onItemClickListener: (Planet) -> Unit) {
        val id = Util.getResId(planet.image, R.drawable::class.java)
        binding.ivPlanet.setImageResource(id)
        binding.tvPlanet.text = planet.name

        binding.ivPlanet.setOnClickListener { onItemClickListener(planet) }

    }
}