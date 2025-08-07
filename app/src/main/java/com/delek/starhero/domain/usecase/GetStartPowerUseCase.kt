package com.delek.starhero.domain.usecase

import android.content.Context
import com.delek.starhero.data.provider.StartPowerProvider
import com.delek.starhero.data.repository.StartPowerRepository
import com.delek.starhero.domain.model.StartPower
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetStartPowerUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: StartPowerRepository
) {

    suspend operator fun invoke(): List<StartPower> {
        val startPowers = repository.getAllStartPowers()
        return if (startPowers.isEmpty()) {
            repository.insertStartPower(StartPowerProvider.loadStartPowers(context))
            startPowers
        } else {
            repository.getAllStartPowers()
        }
    }

}