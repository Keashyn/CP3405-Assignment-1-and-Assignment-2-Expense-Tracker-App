package com.cp3405b1.expensetrackerapp.budget

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BudgetViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Budget>>
    private val repository: BudgetRepository

    init {
        val budgetDao = BudgetDatabase.getDatabase(
            application
        ).budgetDao()
        repository = BudgetRepository(budgetDao)
        readAllData = repository.readAllData
    }

    fun addBudget(budget: Budget){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addBudget(budget)
        }
    }

    fun updateBudget(budget: Budget){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateBudget(budget)
        }
    }

    fun deleteBudget(budget: Budget){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteBudget(budget)
        }
    }

    fun deleteAllBudgets(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllBudgets()
        }
    }

}