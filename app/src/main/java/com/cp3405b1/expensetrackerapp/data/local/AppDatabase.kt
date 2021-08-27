package com.cp3405b1.expensetrackerapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cp3405b1.expensetrackerapp.model.Transaction

@Database(
    entities = [Transaction::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getTransactionDao(): com.cp3405b1.expensetrackerapp.data.local.TransactionDao

    companion object {
        @Volatile
        private var instance: com.cp3405b1.expensetrackerapp.data.local.AppDatabase? = null
        private val LOCK = Any()

        // Check for DB instance if not null then get or insert or else create new DB Instance
        operator fun invoke(context: Context) = com.cp3405b1.expensetrackerapp.data.local.AppDatabase.Companion.instance
            ?: synchronized(com.cp3405b1.expensetrackerapp.data.local.AppDatabase.Companion.LOCK) {

            com.cp3405b1.expensetrackerapp.data.local.AppDatabase.Companion.instance
                ?: com.cp3405b1.expensetrackerapp.data.local.AppDatabase.Companion.createDatabase(context)
                    .also { com.cp3405b1.expensetrackerapp.data.local.AppDatabase.Companion.instance = it }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            com.cp3405b1.expensetrackerapp.data.local.AppDatabase::class.java,
            "transaction.db"
        ).build()
    }
}
