package com.delek.starhero.domain.usecase

import android.content.Context
import com.delek.starhero.data.provider.NativeProvider
import com.delek.starhero.data.repository.NativeRepository
import com.delek.starhero.domain.model.Native
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetNativeUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: NativeRepository
) {

    suspend operator fun invoke():List<Native>{
        val natives = repository.getNatives()
        return if(natives.isEmpty()){
            repository.insertNatives(NativeProvider.loadNatives(context))
            natives
        }else{
            repository.getNatives()
        }
    }
}