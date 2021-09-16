package com.cp3405b1.expensetrackerapp.view.budget

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cp3405b1.expensetrackerapp.R
import com.cp3405b1.expensetrackerapp.budget.Budget
import com.cp3405b1.expensetrackerapp.budget.BudgetViewModel
import kotlinx.android.synthetic.main.fragment_add_budget.*
import kotlinx.android.synthetic.main.fragment_add_budget.view.*

class AddBudgetFragment : Fragment() {

    private lateinit var mBudgetViewModel: BudgetViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_budget, container, false)

        mBudgetViewModel = ViewModelProvider(this).get(BudgetViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val category = addCategory_et.selectedItem.toString()
        val repeat = addRepeat_et.selectedItem.toString()
        val amount = addAmount_et.text

        if(inputCheck(category, repeat, amount)){
            // Create Budget Object
            val budget = Budget(
                0,
                category,
                repeat,
                Integer.parseInt(amount.toString())
            )
            // Add Data to Database
            mBudgetViewModel.addBudget(budget)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate Back
            findNavController().navigate(R.id.action_AddBudgetFragment_to_ViewBudgetFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(category: String, repeat: String, amount: Editable): Boolean{
        return !(TextUtils.isEmpty(category) && TextUtils.isEmpty(repeat) && amount.isEmpty())
    }

}