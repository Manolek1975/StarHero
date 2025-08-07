package com.delek.starhero.ui.power

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.starhero.databinding.ItemPowerBinding
import com.delek.starhero.domain.model.Power

class PowerViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemPowerBinding.bind(view)

    fun render(power: Power, onItemSelected: (Power) -> Unit) {
        binding.tvPower.text = power.name
        binding.tvTarget.text = power.target
        binding.tvDuration.text = power.duration
        binding.tvShortDescription.text = power.shortDescription

        binding.itemPower.setOnClickListener { onItemSelected(power) }

    }
}