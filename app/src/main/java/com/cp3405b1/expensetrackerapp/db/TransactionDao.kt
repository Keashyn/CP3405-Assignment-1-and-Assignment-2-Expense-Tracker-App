package com.cp3405b1.expensetrackerapp.db

import androidx.room.*
import com.cp3405b1.expensetrackerapp.model.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction:Transaction)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)

    @Query("SELECT * FROM all_transactions ORDER by createdAt DESC")
    fun getAllTransaction() : Flow<List<Transaction>>

    @Query("SELECT * FROM all_transactions WHERE transactionType == :transactionType ORDER by createdAt DESC")
    fun getTransaction(transactionType:String) : Flow<List<Transaction>>

    @Query("SELECT * FROM all_transactions WHERE id = :id")
    fun getTransactionByID(id: Int): Flow<androidx.room.Transaction>

    @Query("DELETE FROM all_transactions WHERE id = :id")
    suspend fun deleteTransactionByID(id: Int)
}