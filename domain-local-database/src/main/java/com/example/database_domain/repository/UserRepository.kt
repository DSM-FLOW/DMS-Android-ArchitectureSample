package com.example.database_domain.repository

import com.example.database_domain.entity.UserVisibleEntity

interface UserRepository {
    suspend fun fetchViewBoolean(): UserVisibleEntity
}