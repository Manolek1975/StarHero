package com.delek.starhero.data.provider

import android.content.Context
import com.delek.starhero.R
import com.delek.starhero.data.database.entity.RelationEntity

class RelationProvider {

    companion object{
        fun loadRelations(context: Context): List<RelationEntity> {
            val relations = mutableListOf<RelationEntity>()
            val heroId = context.resources.getStringArray(R.array.hero_id_relations)
            val groupId = context.resources.getStringArray(R.array.group_id_relations)
            val relation = context.resources.getStringArray(R.array.level_relations)

            for (i in heroId.indices) {
                val value = RelationEntity(i+1, heroId[i].toInt(), groupId[i].toInt(), relation[i].toInt())
                relations.add(value)
            }
            return relations

        }
    }
}