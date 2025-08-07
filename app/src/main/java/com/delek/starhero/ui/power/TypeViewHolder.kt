package com.delek.starhero.ui.power

import android.graphics.Color
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.delek.starhero.R
import com.delek.starhero.databinding.ItemTypeBinding
import com.delek.starhero.domain.model.StartPower
import com.delek.starhero.ui.power.TypeAdapter.Companion.selected

class TypeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemTypeBinding.bind(view)
    val context = binding.itemType.context!!

    fun render(type: StartPower, onItemSelected: (StartPower) -> Unit) {

        if (selected != -1) {
            if (selected == adapterPosition) {
                binding.tvType.background =
                    ContextCompat.getDrawable(context, R.drawable.layout_selected)
                binding.tvType.setTextColor(Color.BLACK)
            } else {
                binding.tvType.background =
                    ContextCompat.getDrawable(context, R.drawable.layout_unselected)
                binding.tvType.setTextColor(ContextCompat.getColor(context, R.color.primary))
            }
        }

        binding.tvType.text = type.powerType

        binding.itemType.setOnClickListener {
            selected = adapterPosition
            onItemSelected(type)
        }

    }

}