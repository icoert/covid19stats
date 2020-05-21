package com.utm.cov19stats.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.utm.cov19stats.common.Utils
import com.utm.cov19stats.databinding.MenuFragmentBinding
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel


class MenuFragment : Fragment() {
    private lateinit var binding: MenuFragmentBinding
    private  val viewModel: MenuViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MenuFragmentBinding.inflate(layoutInflater)

        binding.worldTotalBtn.setOnClickListener{
            lifecycleScope.launch {
                val rawStatsResponse = viewModel.getTotalStats()
                Utils(requireContext()).showDialog(rawStatsResponse.toString())
            }
        }

        binding.customViewBtn.setOnClickListener{
            val direction =
                MenuFragmentDirections.actionMenuFragmentToCustomizeFragment()
            findNavController().navigate(direction)
        }

        return binding.root
    }
}
