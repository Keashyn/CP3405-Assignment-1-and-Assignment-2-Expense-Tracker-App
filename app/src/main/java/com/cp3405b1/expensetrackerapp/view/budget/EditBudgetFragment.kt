package com.cp3405b1.expensetrackerapp.view.budget

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cp3405b1.expensetrackerapp.R
import com.cp3405b1.expensetrackerapp.budget.Budget
import com.cp3405b1.expensetrackerapp.budget.BudgetViewModel
import com.cp3405b1.expensetrackerapp.budget.EditBudgetFragmentArgs
import kotlinx.android.synthetic.main.fragment_edit_budget.*
import kotlinx.android.synthetic.main.fragment_edit_budget.view.*

class EditBudgetFragment : Fragment() {

    private val args by navArgs<EditBudgetFragmentArgs>()

    private lateinit var mBudgetViewModel: BudgetViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_edit_budget, container, false)

        mBudgetViewModel = ViewModelProvider(this).get(BudgetViewModel::class.java)

        view.updateCategory_et.tag = args.currentBudget.category
        view.updateRepeat_et.tag = args.currentBudget.repeat
        view.updateAmount_et.setText(args.currentBudget.amount.toString())

        view.update_btn.setOnClickListener {
            updateItem()
        }

        // Add menu
        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem() {
        val category = updateCategory_et.selectedItem.toString()
        val repeat = updateRepeat_et.selectedItem.toString()
        val amount = Integer.parseInt(updateAmount_et.text.toString())

        if (inputCheck(category, repeat, updateAmount_et.text)) {
            // Create Budget Object
            val updatedBudget = Budget(args.currentBudget.id, category, repeat, amount)
            // Update Current Budget
            mBudgetViewModel.updateBudget(updatedBudget)
            Toast.makeText(requireContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show()
            // Navigate Back
            findNavController().navigate(R.id.action_EditBudgetFragment_to_ViewBudgetFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun inputCheck(category: String, repeat: String, amount: Editable): Boolean {
        return !(TextUtils.isEmpty(category) && TextUtils.isEmpty(repeat) && amount.isEmpty())
    }


    private fun deleteBudget() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mBudgetViewModel.deleteBudget(args.currentBudget)
            Toast.makeText(
                requireContext(),
                "Successfully removed: ${args.currentBudget.category}",
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_EditBudgetFragment_to_ViewBudgetFragment)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ${args.currentBudget.category}?")
        builder.setMessage("Are you sure you want to delete ${args.currentBudget.category}?")
        builder.create().show()
    }
}