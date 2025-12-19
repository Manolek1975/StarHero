package com.delek.starhero.ui.trade

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.starhero.R
import com.delek.starhero.core.Util
import com.delek.starhero.databinding.ItemTreasureBinding
import com.delek.starhero.domain.model.Treasure

class TradeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemTreasureBinding.bind(view)

    fun render(item: Treasure, onItemClickListener: (Treasure) -> Unit) {
        val id = Util.getResId(item.image, R.drawable::class.java)
        binding.ivImage.setImageResource(id)
        binding.tvName.text = item.name
        if (item.type == "weapon") {
            binding.tvDamage.text = String.format("DMG ${item.damage}")
        } else {
            binding.tvDamage.text = String.format("DEF ${item.def}")
        }

        binding.itemTreasure.setOnClickListener { onItemClickListener(item) }

    }
}