package com.delek.starhero.domain.usecase

import android.content.Context
import com.delek.starhero.data.provider.RelationProvider
import com.delek.starhero.data.repository.RelationRepository
import com.delek.starhero.domain.model.Relation
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetRelationUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: RelationRepository) {

    suspend operator fun invoke() : List<Relation> {
        val relations = repository.getAllRelations()
        return if (relations.isEmpty()) {
            repository.insertAll(RelationProvider.loadRelations(context))
            relations
        } else {
            repository.getAllRelations()
        }
    }
}