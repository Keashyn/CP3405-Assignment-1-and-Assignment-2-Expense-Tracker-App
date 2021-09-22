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
import com.cp3405b1.expensetrackerapp.model.Transaction
import com.cp3405b1.expensetrackerapp.utils.SingaporeDollar


class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {


    private var budgetList = emptyList<Budget>()
    private var expenseList = emptyList<Transaction>()

    class MyViewHolder(val binding: CustomRowBinding): RecyclerView.ViewHolder(binding.root)

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
            holder.itemView.amount_txt.text = "SGD".plus(currentItem.amount)

            when (currentItem.repeat) {
                 "Yes" ->{
                     holder.itemView.repeat_txt.text = "Repeating monthly"
                 }
                "No" -> {
                    holder.itemView.repeat_txt.text = "Not on repeat"
                }
            }


            holder.itemView.gridLayout.setOnClickListener{
                val action = ListBudgetFragmentDirections.actionViewBudgetFragmentToEditBudgetFragment(currentItem)
                holder.itemView.findNavController().navigate(action)
            }
        }
    }

    fun setData(budget: List<Budget>){
        this.budgetList = budget
        notifyDataSetChanged()
    }
}