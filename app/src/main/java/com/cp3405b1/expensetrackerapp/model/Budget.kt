package com.cp3405b1.expensetrackerapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.text.DateFormat

@Entity(tableName = "all_budgets")
data class Budget(

    @ColumnInfo(name = "category")
    var category: String,
    @ColumnInfo(name = "amount")
    var amount: Double,
    @ColumnInfo(name = "repeat")
    var repeat: String,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
)