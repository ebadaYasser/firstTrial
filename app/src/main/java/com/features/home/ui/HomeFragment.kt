package com.features.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.check.firsttrial.databinding.FragmentHomeLayoutBinding
import com.extensions.setVisibility
import com.features.home.presentaion.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeLayoutBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: HomeAdapter

    private val homeViewModel: HomeViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeLayoutBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun handleProgressIndicatorVisibility(shouldShow: Boolean) {
        binding.progress.setVisibility(!shouldShow)
    }

    private fun setupHomeAdapter(setupAdapter: HomeViewModel.SetupAdapter) {
        binding.countriesRecView.setVisibility(false)
        adapter = HomeAdapter(setupAdapter.list) {
            homeViewModel.addCountryToFav(it.capital?.get(0) ?: "")
        }
        binding.countriesRecView.adapter = adapter
    }

    private fun showError(showError: HomeViewModel.ShowError) {
        Toast.makeText(context, showError.errorMessage, Toast.LENGTH_LONG).show()
    }

    private fun setupObservers() {
        with(homeViewModel) {
            showLoadingIndicator().observe(
                viewLifecycleOwner,
                (::handleProgressIndicatorVisibility)
            )
            setupAdapter().observe(viewLifecycleOwner, (::setupHomeAdapter))
            showError().observe(viewLifecycleOwner, (::showError))
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}