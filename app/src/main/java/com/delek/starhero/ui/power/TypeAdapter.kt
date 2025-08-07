package com.delek.starhero.ui.power

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delek.starhero.R
import com.delek.starhero.domain.model.StartPower
import javax.inject.Inject

class TypeAdapter @Inject constructor(
    private var typeList: List<StartPower> = emptyList(),
    private val onItemSelected: (StartPower) -> Unit)
    : RecyclerView.Adapter<TypeViewHolder>() {

    companion object { var selected = -1 }

    @SuppressLint("NotifyDataSetChanged")
    fun updateTypes(type: List<StartPower>){
        typeList = type
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeViewHolder {
        return TypeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_type, parent, false)
        )
    }

    override fun getItemCount(): Int = typeList.size

    override fun onBindViewHolder(holder: TypeViewHolder, position: Int) {
        holder.render(typeList[position], onItemSelected)
    }
}