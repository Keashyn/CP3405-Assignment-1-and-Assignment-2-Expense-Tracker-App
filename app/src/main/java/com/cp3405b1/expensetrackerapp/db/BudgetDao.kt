package com.cp3405b1.expensetrackerapp.db

import androidx.room.*
import com.cp3405b1.expensetrackerapp.model.Budget
import kotlinx.coroutines.flow.Flow

@Dao
interface BudgetDao {

    // used to insert new budget
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBudget(budget: Budget)

    // used to update existing budget
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateBudget(budget: Budget)

    // used to delete budget
    @Delete
    suspend fun deleteBudget(budget: Budget)

    // get all saved budget list
    @Query("SELECT * FROM all_budgets ORDER by amount DESC")
    fun getAllBudgets(): Flow<List<Budget>>


    // get single budget by id
    @Query("SELECT * FROM all_budgets WHERE id = :id")
    fun getBudgetByID(id: Int): Flow<Budget>

    // delete budget by id
    @Query("DELETE FROM all_budgets WHERE id = :id")
    suspend fun deleteBudgetByID(id: Int)
}

