package com.example.room_practica.addtasks.domain.repository

import com.example.room_practica.addtasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow

interface ITaskRepository {

    fun getTask(): Flow<List<TaskModel>>

    suspend fun addTask(taskModel: TaskModel)

    suspend fun deleteTask(taskModel: TaskModel)

    suspend fun updateTask(taskModel: TaskModel)
}