package com.example.room_practica.addtasks.data

import com.example.room_practica.addtasks.domain.repository.ITaskRepository
import com.example.room_practica.addtasks.ui.model.TaskModel
import com.example.room_practica.addtasks.ui.model.toData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskRepository @Inject constructor(private val taskDao: TaskDao): ITaskRepository {
    //Podríamos haber creado directamente una lista de TaskEntity de la siguiente forma:
    //val tasks: Flow<List<TaskModel>> = taskDao.getTasks()
    //Pero a nivel de arquitectura no es una buena práctica por el acoplamiento de capas.
    //Estamos en data, y ni dominio ni ui deberían conocer que existe un objeto TaskEntity...
    //Para desarrollarlo correctamente, vamos a generar una lista de TaskModel y mapearemos
    //los items del TaskEntity (data) al TaskModel (modelo de la ui)
    //Nosotros vamos a mantener el mismo modelo (TaskModel) para la capa de dominio y ui,
    //pero para la capa de data el modelo es diferente (TaskEntity).
    //Un mapper es cuando recibes unos datos y los devuelves transformados para cada una de las capas.
    //El método map es cómo un forEach, pero me va a devolver una lista de cada item
    //con la transformación que le hagamos mediante la expresión lambda.

    override fun getTask(): Flow<List<TaskModel>> {
        return taskDao.getTasks().map { items -> items.map { it.toDomain() } }
    }

    override suspend fun addTask(taskModel: TaskModel) {
        taskDao.addTask(taskModel.toData())
    }

    override suspend fun deleteTask(taskModel: TaskModel) {
        taskDao.deleteTask(taskModel.toData())
    }

}

fun TaskEntity.toDomain(): TaskModel {
    return TaskModel(this.id, this.task, this.selected)
}





