package com.delek.starhero.domain.usecase

import android.content.Context
import com.delek.starhero.data.provider.AdviceChitProvider
import com.delek.starhero.data.repository.AdviceChitRepository
import com.delek.starhero.domain.model.AdviceChit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetAdviceChitUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: AdviceChitRepository
) {

    suspend operator fun invoke(): List<AdviceChit> {
        val adviceChits = repository.getAllAdviceChits()
        return if (adviceChits.isEmpty()) {
            repository.insertAdviceChits(AdviceChitProvider.loadAdvices(context))
            adviceChits
        } else {
            repository.getAllAdviceChits()
        }
    }

}