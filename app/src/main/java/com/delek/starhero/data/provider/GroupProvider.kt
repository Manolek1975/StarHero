package com.delek.starhero.data.provider

import android.content.Context
import com.delek.starhero.R
import com.delek.starhero.data.database.entity.GroupEntity

class GroupProvider {

    companion object{
        fun loadGroups(context: Context): List<GroupEntity> {
            val groups = mutableListOf<GroupEntity>()
            val name = context.resources.getStringArray(R.array.name_group)
            val dwelling = context.resources.getStringArray(R.array.start_group)

            for (i in name.indices) {
                val group = GroupEntity(i + 1, name[i], dwelling[i].toInt(), 0, "")
                groups.add(group)
            }
            return groups
        }
    }
}