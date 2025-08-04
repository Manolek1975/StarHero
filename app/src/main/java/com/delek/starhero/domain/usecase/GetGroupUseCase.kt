package com.delek.starhero.domain.usecase

import android.content.Context
import com.delek.starhero.data.provider.GroupProvider
import com.delek.starhero.data.repository.GroupRepository
import com.delek.starhero.domain.model.Group
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetGroupUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val groupRepository: GroupRepository
) {

    suspend operator fun invoke(): List<Group> {
        val groups = groupRepository.getAll()
        return if (groups.isEmpty()) {
            groupRepository.insertAll(GroupProvider.loadGroups(context))
            groups
        } else {
            groupRepository.getAll()
        }
    }

}