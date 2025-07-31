package com.delek.starhero.ui.select

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.starhero.R
import com.delek.starhero.databinding.ItemHeroBinding
import com.delek.starhero.domain.model.Hero
import java.lang.reflect.Field

class SelectViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHeroBinding.bind(view)

    fun render(hero: Hero, onItemclickListener: (Hero) -> Unit) {
        val id = getResId(hero.image, R.drawable::class.java)
        binding.ivHero.setImageResource(id)
        binding.rvHero.text = hero.name

        binding.ivHero.setOnClickListener { onItemclickListener(hero) }


    }

    private fun getResId(resName: String?, c: Class<*>): Int {
        try {
            val idField: Field = c.getDeclaredField(resName!!)
            return idField.getInt(idField)
        } catch (e: Exception) {
            e.printStackTrace()
            return -1
        }
    }
}