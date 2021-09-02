package com.cp3405b1.expensetrackerapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cp3405b1.expensetrackerapp.model.Budget

@Database(
    entities = [Budget::class],
    version = 1,
    exportSchema = false
)
abstract class BudgetAppDatabase : RoomDatabase() {

    abstract fun getBudgetDao(): BudgetDao

    companion object {
        @Volatile
        private var instance: BudgetAppDatabase? = null
        private val LOCK = Any()

        // Check for DB instance if not null then get or insert or else create new DB Instance
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {

            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            BudgetAppDatabase::class.java,
            "budget.db"
        ).build()
    }
}
