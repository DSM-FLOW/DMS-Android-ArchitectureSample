package com.example.database.repositoryimpl

import com.example.database.datasource.LocalUserDataSource
import com.example.database.param.LocalUserViewParam
import com.example.database.storage.AuthDataStorage
import com.example.database_domain.entity.UserVisibleEntity
import com.example.database_domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val authDataStorage: AuthDataStorage
): UserRepository {

    override suspend fun fetchViewBoolean(): UserVisibleEntity = authDataStorage.fetchViewBoolean()

}