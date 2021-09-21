package com.cp3405b1.expensetrackerapp.view.budget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.cp3405b1.expensetrackerapp.R
import com.cp3405b1.expensetrackerapp.budget.Budget
import kotlinx.android.synthetic.main.custom_row.view.*
import com.cp3405b1.expensetrackerapp.databinding.CustomRowBinding


class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {


    private var budgetList = emptyList<Budget>()

    class MyViewHolder(val binding: CustomRowBinding): RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            CustomRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return budgetList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = budgetList[position]
        holder.binding.apply {
            holder.itemView.category_txt.text = currentItem.category
            holder.itemView.amount_txt.text = currentItem.amount.toString()
            when (currentItem.category) {
                "Housing" -> {
                    budgetIconView.setImageResource(R.drawable.ic_housing)
                }
                "Transportation" -> {
                    budgetIconView.setImageResource(R.drawable.ic_transport)
                }
                "Food" -> {
                    budgetIconView.setImageResource(R.drawable.ic_food)
                }
                "Utilities" -> {
                    budgetIconView.setImageResource(R.drawable.ic_utilities)
                }
                "Insurance" -> {
                    budgetIconView.setImageResource(R.drawable.ic_insurance)
                }
                "Healthcare" -> {
                    budgetIconView.setImageResource(R.drawable.ic_medical)
                }
                "Saving & Debts" -> {
                    budgetIconView.setImageResource(R.drawable.ic_savings)
                }
                "Personal Spending" -> {
                    budgetIconView.setImageResource(R.drawable.ic_personal_spending)
                }
                "Entertainment" -> {
                    budgetIconView.setImageResource(R.drawable.ic_entertainment)
                }
                "Miscellaneous" -> {
                    budgetIconView.setImageResource(R.drawable.ic_others)
                }
                else -> {
                    budgetIconView.setImageResource(R.drawable.ic_others)
                }
            }
        }
    }

    fun setData(budget: List<Budget>){
        this.budgetList = budget
        notifyDataSetChanged()
    }
}