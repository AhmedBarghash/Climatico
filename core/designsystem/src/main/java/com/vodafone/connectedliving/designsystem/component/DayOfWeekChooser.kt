package com.vodafone.connectedliving.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.util.Locale

@Composable
fun DayOfWeekChooser(
    daysActive: Array<String>,
    isEditable: Boolean, // Use this to determine whether or not they are clickable -
                        // Then there's only one component needed for add/edit and view.
) {
    val dayActiveStates: Array<Boolean> = getDaysActive(daysActive)
    Column {
        Text(text = "Select at least one day (Required)")
        Spacer(modifier = Modifier.height(16.dp))
        Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DisplayDayItem(selected = true, day = "monday") // Change "monday" to be a string resource for the days of the week.
            // This will make it localised.
            // And then we don't need the code to make it sentence case.

            DisplayDayItem(selected = false, day = "tuesday")
            DisplayDayItem(selected = false, day = "wednesday")
            DisplayDayItem(selected = false, day = "thursday")
            DisplayDayItem(selected = false, day = "friday")
            DisplayDayItem(selected = false, day = "saturday")
            DisplayDayItem(selected = false, day = "sunday")
        }
    }

}

fun getDaysActive(
    daysActive: Array<String>
): Array<Boolean> {
    val dayActiveStates: Array<Boolean> = arrayOf(
        false, // Monday
        false, // Tuesday
        false, // Wednesday
        false, // Thursday
        false, // Friday
        false, // Saturday
        false // Sunday
    )
    daysActive.forEach {
        when (it) {
            "monday" -> { dayActiveStates[0] = true }
            "tuesday" -> { dayActiveStates[1] = true }
            "wednesday" -> { dayActiveStates[2] = true }
            "thursday" -> { dayActiveStates[3] = true }
            "friday" -> { dayActiveStates[4] = true }
            "saturday" -> { dayActiveStates[5] = true }
            "sunday" -> { dayActiveStates[6] = true }
            else -> {  }
        }
    }
    return dayActiveStates
}

@Composable
fun SetDayModifier(state: String): Modifier {
    return when (state) {
        selectedDayActive -> Modifier
        unselectedDayActive -> Modifier
        selectedDayInactive -> Modifier
        unselectedDayInactive -> Modifier
        else -> Modifier
    }
}

@Composable
fun DisplayDayItem(selected: Boolean, day: String) {
    val textColour = if (selected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSecondary
    val backgroundColour = if (selected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.surface
    Box(
        modifier = Modifier
            .background(backgroundColour, CircleShape)
            .clickable { }
            .width(40.dp)
            .border(BorderStroke(1.dp, MaterialTheme.colorScheme.surfaceVariant), CircleShape)
            .height(40.dp),
    ) {
        Text(
            text = getShortDayOfWeek(day),
            modifier = Modifier.align(Alignment.Center),
            color = textColour,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
        )
    }
}

private fun getShortDayOfWeek(day: String): String {
    return day.substring(0, 3).replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
}

const val selectedDayActive = "SELECTED_ACTIVE"
const val unselectedDayActive = "UNSELECTED_ACTIVE"
const val selectedDayInactive = "SELECTED_INACTIVE"
const val unselectedDayInactive = "UNSELECTED_INACTIVE"