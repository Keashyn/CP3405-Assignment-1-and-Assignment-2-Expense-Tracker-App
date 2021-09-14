package com.cp3405b1.expensetrackerapp.view.budget

import com.cp3405b1.expensetrackerapp.model.Budget

sealed class BudgetDetailState {
    object Loading : BudgetDetailState()
    object Empty : BudgetDetailState()
    data class Success(val budget: Budget) : BudgetDetailState()
    data class Error(val exception: Throwable) : BudgetDetailState()
}