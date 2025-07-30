package com.delek.starhero.domain.usecase

import android.content.Context
import com.delek.starhero.data.provider.HeroProvider
import com.delek.starhero.data.repository.HeroRepository
import com.delek.starhero.domain.model.Hero
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetHeroUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: HeroRepository) {

    suspend operator fun invoke() : List<Hero> {
        val heroes = repository.getAllHeroes()
        return if (heroes.isEmpty()) {
            repository.insertAll(HeroProvider.loadHeroes(context))
            heroes
        } else {
            repository.getAllHeroes()
        }
    }

}