package com.cp3405b1.expensetrackerapp.repo


import com.cp3405b1.expensetrackerapp.db.AppDatabase
import com.cp3405b1.expensetrackerapp.model.Transaction
import javax.inject.Inject

class TransactionRepo @Inject constructor(private val db: AppDatabase) {

    //insert transaction
    suspend fun insert(transaction: Transaction) = db.getTransactionDao().insertTransaction(transaction)

    //updated transaction
    suspend fun update(transaction: Transaction) = db.getTransactionDao().updateTransaction(transaction)

    //delete transaction
    suspend fun delete(transaction: Transaction) = db.getTransactionDao().deleteTransaction(transaction)

    //get all transaction
    fun getAllTransactions() = db.getTransactionDao().getAllTransactions()

    // get single transaction type - Expense or Income or else overall
    fun getAllSingleTransaction(transactionType: String) = if (transactionType == "Overall"){
        getAllTransactions()
    }else{
        db.getTransactionDao().getAllSingleTransaction(transactionType)
    }

    // get transaction by ID
    fun getByID(id: Int) = db.getTransactionDao().getTransactionByID(id)

    // delete transaction by ID
    suspend fun deleteByID(id: Int) = db.getTransactionDao().deleteTransactionByID(id)
}