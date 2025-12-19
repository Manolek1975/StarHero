package com.delek.starhero.domain.usecase

import android.content.Context
import com.delek.starhero.data.provider.TreasureProvider
import com.delek.starhero.data.repository.TreasureRepository
import com.delek.starhero.domain.model.Treasure
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetTreasureUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: TreasureRepository
) {

    suspend operator fun invoke(): List<Treasure> {
        val treasure = repository.getAllTreasures()
        return if (treasure.isEmpty()) {
            repository.insertAll(TreasureProvider.loadTreasures(context))
            treasure
        } else {
            repository.getAllTreasures()
        }
    }
}