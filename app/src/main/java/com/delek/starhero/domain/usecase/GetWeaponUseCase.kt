package com.delek.starhero.domain.usecase

import android.content.Context
import com.delek.starhero.data.provider.WeaponProvider
import com.delek.starhero.data.repository.WeaponRepository
import com.delek.starhero.domain.model.Weapon
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetWeaponUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: WeaponRepository) {

    suspend operator fun invoke() : List<Weapon> {
        val weapon = repository.getAllWeapons()
        return if (weapon.isEmpty()) {
            repository.insertAll(WeaponProvider.loadWeapons(context))
            weapon
        } else {
            repository.getAllWeapons()
        }
    }

}