package com.cp3405b1.expensetrackerapp.repo


import com.cp3405b1.expensetrackerapp.db.BudgetAppDatabase
import com.cp3405b1.expensetrackerapp.model.Budget
import javax.inject.Inject

class BudgetRepo @Inject constructor(private val db: BudgetAppDatabase) {

    //insert budget
    suspend fun insert(budget: Budget) = db.getBudgetDao().insertBudget(budget)

    //updated budget
    suspend fun update(budget: Budget) = db.getBudgetDao().updateBudget(budget)

    //delete budget
    suspend fun delete(budget: Budget) = db.getBudgetDao().deleteBudget(budget)

    //get all budget
    fun getAllBudgets() = db.getBudgetDao().getAllBudgets()

    // get budget by ID
    fun getByID(id: Int) = db.getBudgetDao().getBudgetByID(id)

    // delete budget by ID
    suspend fun deleteByID(id: Int) = db.getBudgetDao().deleteBudgetByID(id)
}