package com.example.afinal.feature.home.ui

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.afinal.feature.home.R
import com.example.afinal.feature.home.databinding.FragmentHomePageBinding
import com.example.afinal.feature.home.di.DaggerHomeComponent
import com.example.afinal.feature.home.presentation.HomeViewModel
import com.example.afinal.feature.home.presentation.UIState.Content
import com.example.afinal.feature.home.ui.adapter.LoanItemAdapter
import com.example.afinal.shared.fragmentDependencies.FragmentDependenciesStore
import javax.inject.Inject

class HomePageFragment : Fragment() {
    companion object {
        fun newInstance() = HomePageFragment()
    }

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<HomeViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerHomeComponent
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
        _binding = FragmentHomePageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSlider()
        setupLoansList()

        viewModel.state.observe(viewLifecycleOwner) {
            if (it is Content) {
                observeContentState(it)
            }
        }

        viewModel.getLoans()

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.getLoans()
        }
    }

    private fun setupSlider() {
        with(binding) {
            sumSlider.progress = 5
            sumSlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    if (fromUser) {
                        binding.sum.text =
                            Editable.Factory.getInstance()
                                .newEditable((progress * 100).toString() + " ₽")
                    }
                    sumMessage.text =
                        if (progress * 100 < 500) getString(R.string.l_bound_sum) else null
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    binding.swipeRefresh.isEnabled = false
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    binding.swipeRefresh.isEnabled = true
                }

            })

            sum.doOnTextChanged { text, _, _, _ ->
                sumSlider.progress = text.toString().dropLast(2).toInt() / 100
                sumMessage.text =
                    if (text.toString().dropLast(2)
                            .toInt() > 10000
                    ) getString(R.string.u_bound_sum) else null
            }
        }
    }

    private fun setupLoansList() {
        with(binding) {
            myLoansCard.loans.adapter = LoanItemAdapter(emptyList())
            myLoansCard.loans.layoutManager =
                object : LinearLayoutManager(requireContext()) {
                    override fun canScrollVertically() = false
                }
        }
    }

    private fun observeContentState(content: Content) {
        with(binding) {
            if (content.data.isEmpty()) {
                myLoansBody.isVisible = true
                myLoansCard.root.isVisible = false
            } else {
                myLoansCard.root.isVisible = true
                myLoansBody.isVisible = false
                (myLoansCard.loans.adapter as LoanItemAdapter).updateData(content.data)
            }
            swipeRefresh.isRefreshing = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}