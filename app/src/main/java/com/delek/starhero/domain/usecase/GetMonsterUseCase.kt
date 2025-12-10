package com.delek.starhero.domain.usecase

import android.content.Context
import com.delek.starhero.data.provider.MonsterProvider
import com.delek.starhero.data.repository.MonsterRepository
import com.delek.starhero.domain.model.Monster
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetMonsterUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: MonsterRepository
) {

    suspend operator fun invoke(): List<Monster> {
        val monster = repository.getAllMonsters()
        return if (monster.isEmpty()) {
            repository.insertMonsters(MonsterProvider.loadMonsters(context))
            monster
        } else {
            repository.getAllMonsters()
        }
    }
}