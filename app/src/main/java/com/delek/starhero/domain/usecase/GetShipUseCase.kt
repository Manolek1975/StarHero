package com.delek.starhero.domain.usecase

import android.content.Context
import com.delek.starhero.data.provider.ShipProvider
import com.delek.starhero.data.repository.ShipRepository
import com.delek.starhero.domain.model.Ship
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetShipUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: ShipRepository) {

    suspend operator fun invoke() : List<Ship> {
        val ship = repository.getAll()
        return if (ship.isEmpty()) {
            repository.insertAll(ShipProvider.loadShips(context))
            ship
        } else {
            repository.getAll()
        }
    }
}