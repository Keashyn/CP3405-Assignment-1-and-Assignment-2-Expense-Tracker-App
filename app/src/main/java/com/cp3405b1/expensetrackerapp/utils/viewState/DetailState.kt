package com.cp3405b1.expensetrackerapp.utils.viewState

import com.cp3405b1.expensetrackerapp.model.Transaction

sealed class DetailState {
    object Loading : DetailState()
    object Empty : DetailState()
    data class Success(val transaction: Transaction) : DetailState()
    data class Error(val exception: Throwable) : DetailState()
}