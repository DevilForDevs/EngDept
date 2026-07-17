package com.ancp.engdept.db.entitydao.userprofile.studentprofile

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "students")
data class StudentEntity(
    @PrimaryKey
    val id: Int,
    val userId: Int,
    val classRoll: Int,
    val registrationNo: Long,
    val universityRoll: Long,
    val session: String
)