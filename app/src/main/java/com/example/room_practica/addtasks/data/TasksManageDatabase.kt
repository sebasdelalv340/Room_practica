package com.example.room_practica.addtasks.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskEntity::class], version = 1)
abstract class TasksManageDatabase: RoomDatabase() {
    //DAO
    abstract fun taskDao():TaskDao
}