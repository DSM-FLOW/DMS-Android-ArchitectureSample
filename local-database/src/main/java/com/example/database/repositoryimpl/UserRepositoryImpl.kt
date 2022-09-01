package com.example.database.repositoryimpl

import com.example.database.storage.AuthDataStorage
import com.example.database_domain.entity.UserVisibleEntity
import com.example.database_domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val authDataStorage: AuthDataStorage
): UserRepository {
        override suspend fun fetchViewBoolean(): UserVisibleEntity = authDataStorage.fetchViewBoolean()
}