package com.example.room_practica.addtasks.data.di


import com.example.room_practica.addtasks.data.TaskRepository
import com.example.room_practica.addtasks.domain.repository.ITaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindTaskRepository(
        taskRepository: TaskRepository
    ): ITaskRepository
}