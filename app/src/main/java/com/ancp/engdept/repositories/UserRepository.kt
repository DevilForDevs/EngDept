package com.ancp.engdept.repositories

import com.ancp.engdept.db.entitydao.user.UserDao
import com.ancp.engdept.db.entitydao.user.UserEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userDao: UserDao
) {
    suspend fun getUser() = userDao.getUser()
    suspend fun insertUser(user: UserEntity) {
        userDao.insert(user)
    }
}