package com.cp3405b1.expensetrackerapp.view.budget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.cp3405b1.expensetrackerapp.R
import com.cp3405b1.expensetrackerapp.budget.Budget
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var budgetList = emptyList<Budget>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
       return budgetList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = budgetList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.category_txt.text = currentItem.category
        holder.itemView.repeat_txt.text = currentItem.repeat
        holder.itemView.amount_txt.text = currentItem.amount.toString()

    }

    fun setData(budget: List<Budget>){
        this.budgetList = budget
        notifyDataSetChanged()
    }
}