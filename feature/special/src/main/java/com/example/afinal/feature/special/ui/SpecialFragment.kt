package com.example.afinal.feature.special.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.afinal.feature.special.databinding.FragmentSpecialBinding
import com.example.afinal.feature.special.di.DaggerSpecialComponent
import com.example.afinal.feature.special.presentation.SpecialViewModel
import com.example.afinal.shared.fragmentDependencies.FragmentDependenciesStore
import javax.inject.Inject

class SpecialFragment : Fragment() {
    companion object {
        fun newInstance() = SpecialFragment()
    }

    private var _binding: FragmentSpecialBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<SpecialViewModel> { viewModelFactory }

    private val onBackPressedCallback: OnBackPressedCallback =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                viewModel.close()
            }
        }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerSpecialComponent
            .builder()
            .dependencies(FragmentDependenciesStore.dependencies)
            .build()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpecialBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            toolbar.setNavigationOnClickListener {
                viewModel.close()
            }

            addressesButton.setOnClickListener {
                viewModel.openAddresses()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(onBackPressedCallback)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        onBackPressedCallback.remove()
        _binding = null
    }
}