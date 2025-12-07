package com.delek.starhero.ui.dwelling

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.starhero.R
import com.delek.starhero.databinding.ItemNativeBinding
import com.delek.starhero.domain.model.Native
import java.lang.reflect.Field


class NativeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemNativeBinding.bind(view)

    fun render(native: Native, onItemSelected: (Native) -> Unit){
        val id = getResId(native.image, R.drawable::class.java)
        binding.ivNative.setImageResource(id)
        binding.nameNative.text = native.name
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