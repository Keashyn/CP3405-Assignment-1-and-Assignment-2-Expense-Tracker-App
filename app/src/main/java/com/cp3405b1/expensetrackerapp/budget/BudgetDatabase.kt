package com.cp3405b1.expensetrackerapp.budget

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Budget::class], version = 1, exportSchema = false)
abstract class BudgetDatabase : RoomDatabase() {

    abstract fun budgetDao(): BudgetDao

    companion object {
        @Volatile
        private var INSTANCE: BudgetDatabase? = null

        fun getDatabase(context: Context): BudgetDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BudgetDatabase::class.java,
                    "budget_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}