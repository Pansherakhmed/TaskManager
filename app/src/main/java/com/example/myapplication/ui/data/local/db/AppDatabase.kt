package com.example.myapplication.ui.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.ui.model.Task

    @Database(entities = [Task::class], version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun taskDao(): TaskDao
    }
