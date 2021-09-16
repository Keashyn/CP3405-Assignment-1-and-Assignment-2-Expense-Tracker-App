package com.cp3405b1.expensetrackerapp.view.budget

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cp3405b1.expensetrackerapp.R
import com.cp3405b1.expensetrackerapp.budget.BudgetViewModel
import kotlinx.android.synthetic.main.fragment_view_budget.view.*

class ListBudgetFragment : Fragment() {

    private lateinit var mBudgetViewModel: BudgetViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_budget, container, false)

        // Recyclerview
        val adapter = ListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // BudgetViewModel
        mBudgetViewModel = ViewModelProvider(this).get(BudgetViewModel::class.java)
        mBudgetViewModel.readAllData.observe(viewLifecycleOwner, Observer { budget ->
            adapter.setData(budget)
        })

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_ViewBudgetFragment_to_AddBudgetFragment)
        }

        // Add menu
        setHasOptionsMenu(true)

        return view
    }

    private fun deleteAllBudgets() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mBudgetViewModel.deleteAllBudgets()
            Toast.makeText(
                requireContext(),
                "Successfully removed everything",
                Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete everything?")
        builder.setMessage("Are you sure you want to delete everything?")
        builder.create().show()
    }
}