package com.delek.starhero.domain.usecase

import android.content.Context
import com.delek.starhero.data.provider.PowerProvider
import com.delek.starhero.data.repository.PowerRepository
import com.delek.starhero.domain.model.Power
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetPowerUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: PowerRepository) {

    suspend operator fun invoke(): List<Power> {
        val power = repository.getAllPower()
        return if (power.isEmpty()) {
            repository.insertAll(PowerProvider.loadPowers(context))
            power
        } else {
            repository.getAllPower()
        }
    }


}