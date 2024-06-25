package com.example.afinal.feature.homepage.ui.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.afinal.feature.homepage.R
import com.example.afinal.feature.homepage.databinding.LoanItemBinding
import com.example.afinal.feature.homepage.domain.entities.Loan
import com.example.afinal.feature.homepage.domain.entities.Status
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Locale
import com.example.afinal.component.resources.R as ComponentR


class LoanViewHolder(
    private val binding: LoanItemBinding
) : ViewHolder(
    binding.root
) {
    @SuppressLint("SimpleDateFormat")
    fun bind(loan: Loan) {
        with(binding) {
            val formatter = NumberFormat.getInstance(Locale.US) as DecimalFormat
            val symbols: DecimalFormatSymbols = formatter.decimalFormatSymbols

            symbols.setGroupingSeparator(' ')
            formatter.decimalFormatSymbols = symbols

            sum.text =
                root.context.getString(ComponentR.string.sum).format(formatter.format(loan.amount))
            loanId.text = root.context.getString(R.string.loan_id).format(loan.id)
            date.text = SimpleDateFormat("d MMMM, EEE").format(loan.date)
            status.text = when (loan.state) {
                Status.APPROVED -> {
                    status.setTextColor(itemView.context.getColor(R.color.indicator_positive))
                    root.context.getString(R.string.loan_approved)
                }

                Status.REGISTERED -> {
                    status.setTextColor(root.context.getColor(R.color.indicator_attention))
                    root.context.getString(R.string.loan_registered)
                }

                Status.REJECTED -> {
                    status.setTextColor(root.context.getColor(ComponentR.color.onSecondary))
                    root.context.getString(R.string.loan_rejected)
                }
            }
        }
    }
}