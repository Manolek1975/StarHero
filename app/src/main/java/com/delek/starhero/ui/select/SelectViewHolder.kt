package com.delek.starhero.ui.select

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.starhero.R
import com.delek.starhero.core.Util
import com.delek.starhero.databinding.ItemHeroBinding
import com.delek.starhero.domain.model.Hero

class SelectViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHeroBinding.bind(view)

    fun render(hero: Hero, onItemClickListener: (Hero) -> Unit) {
        val id = Util.getResId(hero.image, R.drawable::class.java)
        binding.ivHero.setImageResource(id)
        binding.rvHero.text = hero.name

        binding.ivHero.setOnClickListener { onItemClickListener(hero) }

    }

}