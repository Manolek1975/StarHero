package com.delek.starhero.domain.usecase

import android.content.Context
import com.delek.starhero.data.provider.SkillProvider
import com.delek.starhero.data.repository.SkillRepository
import com.delek.starhero.domain.model.Skill
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetSkillUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: SkillRepository) {

    suspend operator fun invoke() : List<Skill> {
        val skill = repository.getAll()
        return if (skill.isEmpty()) {
            repository.insertAll(SkillProvider.loadSkills(context))
            skill
        } else {
            repository.getAll()
        }
    }

}