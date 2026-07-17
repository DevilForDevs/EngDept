package com.ancp.engdept.db.entitydao.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val role: String,
    val userId: Int,
    val bearerToken: String
)