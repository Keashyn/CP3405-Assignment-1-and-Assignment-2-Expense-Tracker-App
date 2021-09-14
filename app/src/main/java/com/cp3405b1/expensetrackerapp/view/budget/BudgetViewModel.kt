package com.cp3405b1.expensetrackerapp.view.budget

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cp3405b1.expensetrackerapp.model.Budget
import com.cp3405b1.expensetrackerapp.repo.BudgetRepo
import com.cp3405b1.expensetrackerapp.view.budget.BudgetDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BudgetViewModel @Inject constructor(
    application: Application,
    private val budgetRepo: BudgetRepo
) :
    AndroidViewModel(application) {
    private val _budgetdetailState = MutableStateFlow<BudgetDetailState>(BudgetDetailState.Loading)

    // insert budget
    fun insertBudget(budget: Budget) = viewModelScope.launch {
        budgetRepo.insert(budget)
    }

    // update budget
    fun updateBudget(budget: Budget) = viewModelScope.launch {
        budgetRepo.update(budget)
    }

    // delete budget
    fun deleteBudget(budget: Budget) = viewModelScope.launch {
        budgetRepo.delete(budget)
    }

    // get budget by id
    fun getByID(id: Int) = viewModelScope.launch {
        budgetRepo.getByID(id).collect { result: Budget? ->
            if (result != null) {
                _budgetdetailState.value = BudgetDetailState.Success(result)
            }
        }
    }

    // delete budget
    fun deleteByID(id: Int) = viewModelScope.launch {
        budgetRepo.deleteByID(id)
    }
}