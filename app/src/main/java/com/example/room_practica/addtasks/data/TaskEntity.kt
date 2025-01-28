package com.example.room_practica.addtasks.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//Nuestro modelo de datos...
@Entity(tableName = "TaskEntity")
data class TaskEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val task: String,
    var selected: Boolean = false
)