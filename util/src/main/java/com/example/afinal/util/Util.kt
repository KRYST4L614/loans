package com.example.afinal.util

import android.annotation.SuppressLint
import android.text.Editable
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun CharSequence.toEditable(): Editable {
    return Editable.Factory.getInstance().newEditable(this)
}

fun Number.toSum(): String {
    val formatter = NumberFormat.getInstance(Locale.US) as DecimalFormat
    val symbols: DecimalFormatSymbols = formatter.decimalFormatSymbols

    symbols.setGroupingSeparator(' ')
    formatter.decimalFormatSymbols = symbols
    return formatter.format(this)
}

@SuppressLint("SimpleDateFormat")
fun Date.convertToString(pattern: String, locale: Locale): String {
    return SimpleDateFormat(
        pattern,
        locale
    ).format(this)
}