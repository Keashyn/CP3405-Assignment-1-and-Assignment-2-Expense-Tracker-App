package com.cp3405b1.expensetrackerapp.budget

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "budget_table")
data class Budget(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val category: String,
    val repeat: String,
    val amount: Int
): Parcelable