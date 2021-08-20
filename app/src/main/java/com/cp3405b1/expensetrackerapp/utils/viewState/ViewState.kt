package com.cp3405b1.expensetrackerapp.utils.viewState

import com.cp3405b1.expensetrackerapp.model.Transaction
sealed class ViewState {
    object Loading : ViewState()
    object Empty : ViewState()
    data class Success(val transaction: List<Transaction>) : ViewState()
    data class Error(val exception: Throwable) : ViewState()
}