package com.delek.starhero.data.provider

import android.content.Context
import com.delek.starhero.R
import com.delek.starhero.data.database.entity.SkillEntity

class SkillProvider {

    companion object {
        fun loadSkills(context: Context): List<SkillEntity> {
            val skills = mutableListOf<SkillEntity>()
            val name = context.resources.getStringArray(R.array.name_skills)
            val description = context.resources.getStringArray(R.array.advantages_description)
            //val image = context.resources.getStringArray(R.array.image_skills)
            for (i in name.indices) {
                val skill = SkillEntity(i, name[i], description[i], "")
                skills.add(skill)
            }
            return skills
        }
    }


}