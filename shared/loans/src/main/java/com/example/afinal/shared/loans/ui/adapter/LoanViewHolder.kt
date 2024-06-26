package com.example.afinal.shared.loans.ui.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.afinal.shared.loans.R
import com.example.afinal.shared.loans.databinding.LoanItemBinding
import com.example.afinal.shared.loans.domain.entities.Loan
import com.example.afinal.shared.loans.domain.entities.Status.APPROVED
import com.example.afinal.shared.loans.domain.entities.Status.REGISTERED
import com.example.afinal.shared.loans.domain.entities.Status.REJECTED
import com.example.afinal.util.toSum
import java.text.SimpleDateFormat
import com.example.afinal.component.resources.R as ComponentR


class LoanViewHolder(
    private val binding: LoanItemBinding
) : ViewHolder(
    binding.root
) {
    @SuppressLint("SimpleDateFormat")
    fun bind(loan: Loan) {
        with(binding) {
            sum.text =
                root.context.getString(ComponentR.string.sum).format(loan.amount.toSum())
            loanId.text = root.context.getString(R.string.loan_id).format(loan.id)
            date.text = SimpleDateFormat("d MMMM, EEE").format(loan.date)
            status.text = when (loan.state) {
                APPROVED -> {
                    status.setTextColor(itemView.context.getColor(R.color.indicator_positive))
                    root.context.getString(R.string.loan_approved)
                }

                REGISTERED -> {
                    status.setTextColor(root.context.getColor(R.color.indicator_attention))
                    root.context.getString(R.string.loan_registered)
                }

                REJECTED -> {
                    status.setTextColor(root.context.getColor(ComponentR.color.fontSecondaryDay))
                    root.context.getString(R.string.loan_rejected)
                }
            }
        }
    }
}