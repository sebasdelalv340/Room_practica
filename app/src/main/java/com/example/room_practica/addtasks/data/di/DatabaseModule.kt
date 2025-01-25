package com.example.room_practica.addtasks.data.di

import android.content.Context
import androidx.room.Room
import androidx.test.espresso.core.internal.deps.dagger.Module
import androidx.test.espresso.core.internal.deps.dagger.Provides
import com.example.room_practica.addtasks.data.TaskDao
import com.example.room_practica.addtasks.data.TasksManageDatabase
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//Debe ser un Singleton	para que la base de datos sea única en nuestro proyecto.
//Utilizaremos la notación de Hilt con @Provides.
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    //Aquí va a recibir la base de datos mediante la inyección de Dagger Hilt...
    //es una caja negra para nosotros, las maravillas de la inyección de dependencias...
    //una especie de "magia" que va a realizar Dagger Hilt por nosotros gracias a las anotaciones
    //va a proveer las clases que necesite...
    @Provides
    fun provideTaskDao(tasksManageDatabase: TasksManageDatabase): TaskDao {
        //Por eso en TasksManageDatabase estaba esta función abstract fun taskDao():TaskDao
        //para que esto automáticamente me devuelva el DAO (objeto de tipo TaskDao)
        return tasksManageDatabase.taskDao()
    }

    @Provides
    @Singleton
    fun provideTasksManageDatabase(@ApplicationContext appContext: Context): TasksManageDatabase {
        //Aquí realmente es dónde estamos CREANDO la base de datos...
        return Room.databaseBuilder(appContext, TasksManageDatabase::class.java, "TaskDatabase").build()
    }
}
