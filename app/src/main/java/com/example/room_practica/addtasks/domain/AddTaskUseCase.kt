package com.example.room_practica.addtasks.domain

import com.example.room_practica.addtasks.data.TaskRepository
import com.example.room_practica.addtasks.ui.model.TaskModel
import javax.inject.Inject

/**
 * Caso de uso para añadir una tarea
 */
class AddTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(taskModel: TaskModel) {
        taskRepository.addTask(taskModel)
    }
}