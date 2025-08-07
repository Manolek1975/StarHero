package com.delek.starhero.ui.power

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delek.starhero.R
import com.delek.starhero.domain.model.Power
import javax.inject.Inject

class PowerAdapter @Inject constructor(
    private var powerList: List<Power> = emptyList(),
    private val onItemSelected: (Power) -> Unit
) : RecyclerView.Adapter<PowerViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updatePowers(power: List<Power>) {
        powerList = power
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PowerViewHolder {
        return PowerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_power, parent, false)
        )
    }

    override fun getItemCount(): Int = powerList.size

    override fun onBindViewHolder(holder: PowerViewHolder, position: Int) {
        holder.render(powerList[position], onItemSelected)
    }
}