package com.cp3405b1.expensetrackerapp.budget

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BudgetDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBudget(budget: Budget)

    @Update
    suspend fun updateBudget(budget: Budget)

    @Delete
    suspend fun deleteBudget(budget: Budget)

    @Query("DELETE FROM budget_table")
    suspend fun deleteAllBudgets()

    @Query("SELECT * FROM budget_table ORDER BY amount DESC")
    fun readAllData(): LiveData<List<Budget>>

}