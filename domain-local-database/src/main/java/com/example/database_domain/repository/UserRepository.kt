package com.example.database_domain.repository

import com.example.database_domain.entity.UserVisibleEntity
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun fetchViewBoolean(): UserVisibleEntity
}