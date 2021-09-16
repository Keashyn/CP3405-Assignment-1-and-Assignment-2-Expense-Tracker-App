package com.cp3405b1.expensetrackerapp.budget

import androidx.lifecycle.LiveData

class BudgetRepository(private val budgetDao: BudgetDao) {

    val readAllData: LiveData<List<Budget>> = budgetDao.readAllData()

    suspend fun addBudget(budget: Budget){
        budgetDao.addBudget(budget)
    }

    suspend fun updateBudget(budget: Budget){
        budgetDao.updateBudget(budget)
    }

    suspend fun deleteBudget(budget: Budget){
        budgetDao.deleteBudget(budget)
    }

    suspend fun deleteAllBudgets(){
        budgetDao.deleteAllBudgets()
    }

}