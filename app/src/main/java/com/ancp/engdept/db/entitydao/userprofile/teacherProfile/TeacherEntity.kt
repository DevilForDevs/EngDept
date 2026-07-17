package com.ancp.engdept.db.entitydao.userprofile.teacherProfile

import androidx.room.PrimaryKey

data class TeacherEntity(
    @PrimaryKey
    val id: Int,
    val userId: Int,
    val designation: String,
    val phone: String,
)