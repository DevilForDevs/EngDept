package com.ancp.engdept.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ancp.engdept.db.entitydao.user.UserDao
import com.ancp.engdept.db.entitydao.user.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}