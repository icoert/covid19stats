package com.utm.cov19stats.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.utm.cov19stats.R
import com.utm.cov19stats.common.Utils
import com.utm.cov19stats.databinding.CustomizeFragmentBinding
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel


class CustomizeFragment : Fragment() {
    private lateinit var binding: CustomizeFragmentBinding
    private val viewModel: CustomizeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        binding = CustomizeFragmentBinding.inflate(layoutInflater)
        val cases = resources.getStringArray(R.array.case_values)
        val spinnerForCase = binding.caseSpinner
        val adapterForCase = ArrayAdapter(requireContext(),
            android.R.layout.simple_spinner_item, cases)
        spinnerForCase.adapter = adapterForCase

        lifecycleScope.launch {
            binding.countrySpinner.adapter = ArrayAdapter(requireContext(),
                android.R.layout.simple_spinner_item, viewModel.getCountryList())
        }

        binding.goBtn.setOnClickListener{
            lifecycleScope.launch {
                val selectedCountry = binding.countrySpinner.selectedItem.toString()
                var statsResponse = "No stats available for $selectedCountry. Please try again " +
                        "at a later time, or select different options."
                val objectList = viewModel.getStats(
                    selectedCountry,
                    binding.caseSpinner.selectedItem.toString()
                )

                if(objectList.isNotEmpty()) {
                    statsResponse = objectList[objectList.lastIndex-1].toString()
                }

                Utils(requireContext()).showDialog(statsResponse)
            }
        }

        // Use top icon to go back to main menu :)
        binding.imageView .setOnClickListener{
            val direction = CustomizeFragmentDirections.actionCustomizeFragmentToMenuFragment()
            findNavController().navigate(direction)
        }

        return binding.root
    }
}
