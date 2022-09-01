package com.example.database_domain.usecase

import com.example.database_domain.entity.UserVisibleEntity
import com.example.database_domain.repository.UserRepository
import javax.inject.Inject

class LocalUserViewBooleanUseCase @Inject constructor(
    private val userRepository: UserRepository
): UseCase<Unit, UserVisibleEntity>() {
    override suspend fun execute(data: Unit): UserVisibleEntity =
        userRepository.fetchViewBoolean()
}