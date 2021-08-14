package com.cp3405b1.expensetrackerapp.model

import java.text.DateFormat

data class Transaction(
    var id:Int =0,
    var title:String,
    var amount:Double,
    var transactionType:String,
    var tag:String,
    var date:String,
    var note:String,
    var createdAt: Long = System.currentTimeMillis()
) {
    val createdAtDateFormat: String
    get() = DateFormat.getDateInstance().format(createdAt)
}