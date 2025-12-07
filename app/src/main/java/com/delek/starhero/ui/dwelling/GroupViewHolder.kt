package com.delek.starhero.ui.dwelling

import android.graphics.Color
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.delek.starhero.R
import com.delek.starhero.databinding.ItemGroupBinding
import com.delek.starhero.domain.model.Group
import com.delek.starhero.ui.dwelling.GroupAdapter.Companion.selected

class GroupViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemGroupBinding.bind(view)
    val context = binding.tvGroup.context!!

    fun render(group: Group, onItemSelected: (Group) -> Unit) {
        binding.tvGroup.text = group.name

        if (selected != adapterPosition) {
            binding.tvGroup.background = ContextCompat.getDrawable(context, R.drawable.layout_group_unselected)
            binding.tvGroup.setTextColor(Color.GRAY)

        } else {
            binding.tvGroup.background = ContextCompat.getDrawable(context, R.drawable.layout_group_selected)
            binding.tvGroup.setTextColor(ContextCompat.getColor(context, R.color.primaryVariant))
        }

        //binding.tvGroup.text = group.name

        binding.tvGroup.setOnClickListener {
            selected = adapterPosition
            onItemSelected(group)
        }
    }
}