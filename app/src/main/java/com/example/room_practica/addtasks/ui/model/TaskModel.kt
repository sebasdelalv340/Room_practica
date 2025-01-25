package com.example.room_practica.addtasks.ui.model

import com.example.room_practica.addtasks.data.TaskEntity

//Nuestro modelo de datos...
//El valor del id por defecto lo vamos a calcular con el momento en el que lo creamos, es decir, el tiempo en milisegundos.
//El valor de la casilla de verificación por defecto debería ser siempre falso cuando creamos la tarea.
data class TaskModel(
    val id: Int = System.currentTimeMillis().hashCode(),
    val task: String,
    var selected: Boolean = false
)

