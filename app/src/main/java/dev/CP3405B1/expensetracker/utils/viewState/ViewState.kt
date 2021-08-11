package dev.CP3405B1.expensetracker.utils.viewState

import dev.CP3405B1.expensetracker.model.Transaction

sealed class ViewState {
    object Loading : ViewState()
    object Empty : ViewState()
    data class Success(val transaction: List<Transaction>) : ViewState()
    data class Error(val exception: Throwable) : ViewState()
}
