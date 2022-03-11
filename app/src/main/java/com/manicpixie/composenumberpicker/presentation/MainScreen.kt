package com.manicpixie.composenumberpicker.presentation

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.*

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val currentYear = Calendar.getInstance().get(Calendar.YEAR)
    val currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
    val currentMonth = Calendar.getInstance().get(Calendar.MONTH)

    val chosenYear = remember { mutableStateOf(currentYear) }
    val chosenMonth = remember { mutableStateOf(currentMonth) }
    val chosenDay = remember {
        mutableStateOf(currentDay)
    }
    val months = listOf(
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December"
    )
    val years = (1950..2050).map { it.toString() }.toList()
    val days = (1..31).map { it.toString() }.toList()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        InfiniteNumberPicker(
            modifier = Modifier.width(60.dp),
            list = days,
            firstIndex = Int.MAX_VALUE / 2 + (currentDay - 2),
            onSelect = {
                chosenDay.value = it.toInt()
            })

        InfiniteNumberPicker(
            modifier = Modifier.width(130.dp),
            list = months,
            firstIndex = Int.MAX_VALUE / 2 - 4 + currentMonth,
            onSelect = {
                chosenMonth.value = months.indexOf(it)
            })

        InfiniteNumberPicker(
            modifier = Modifier.width(60.dp),
            list = years,
            firstIndex = Int.MAX_VALUE / 2 + (currentYear - 1967),
            onSelect = {
                chosenYear.value = it.toInt()
            })

        Log.i(
            "info", "${Calendar.getInstance().get(Calendar.YEAR)} " +
                    "${Calendar.getInstance().get(Calendar.MONTH)} " +
                    "${Calendar.getInstance().get(Calendar.DAY_OF_MONTH)}"
        )

        Log.i(
            "info", "${chosenYear.value} " +
                    "${chosenMonth.value} " +
                    "${chosenDay.value}"
        )
    }

}