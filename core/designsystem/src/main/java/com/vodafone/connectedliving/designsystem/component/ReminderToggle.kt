package com.vodafone.connectedliving.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vodafone.connectedliving.designsystem.R
import com.vodafone.connectedliving.designsystem.icon.CLIcons
import java.util.Calendar

@Composable
fun ReminderToggle(
    toggleOn: Boolean,
    onReminderValueChanged: () -> Unit,
    reminderValue: Int,
    onToggleChangeClicked: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val toggleImage = if (toggleOn) CLIcons.ToggleOn else CLIcons.ToggleOff
            Text(
                color = MaterialTheme.colorScheme.primary,
                text = stringResource(id = R.string.set_reminder)
            )
            Image(
                modifier = Modifier
                    .height(32.dp)
                    .clickable {
                        onToggleChangeClicked.invoke(!toggleOn)
                    },
                painter = painterResource(id = toggleImage),
                contentDescription = "",
            )
        }
        val reminderValueString = when (reminderValue) {
            0 -> ""
            15 -> "15 ${stringResource(id = R.string.reminder_minutes_before)}"
            30 -> "30 ${stringResource(id = R.string.reminder_minutes_before)}"
            60 -> "1 ${stringResource(id = R.string.reminder_hour_before)}"
            else -> "2 ${stringResource(id = R.string.reminder_hours_before)}"
        }

        Column {
            TextInputField(
                value = reminderValueString,
                label = stringResource(id = R
.string.set_reminder),
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged {
                        if (it.hasFocus) {
                            onReminderValueChanged.invoke()
                        }
                    },
                enabled = toggleOn,
                readOnly = true,
            )
        }
    }
}

@Composable
fun ReminderBottomSheetLayout(
    valueClicked: (Int) -> Unit,
    closeButtonClicked: () -> Unit,
    startTime: Calendar,
    isRoutine: Boolean = false
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        val timeNow = Calendar.getInstance()
        timeNow.set(Calendar.MONTH, timeNow.get(Calendar.MONTH)+1)
        val diff: Long = startTime.timeInMillis - timeNow.timeInMillis
        val minutes = diff / 60_000
        val minutes15Possible: Boolean
        val minutes30Possible: Boolean
        val hours1Possible: Boolean
        val hours2Possible: Boolean
        val lessThanLeft: Int
        when {
            (minutes < 15) -> { minutes15Possible = false; minutes30Possible = false; hours1Possible = false; hours2Possible = false; lessThanLeft = 15 }
            (minutes < 30) -> { minutes15Possible = true; minutes30Possible = false; hours1Possible = false; hours2Possible = false; lessThanLeft = 30 }
            (minutes < 60) -> { minutes15Possible = true; minutes30Possible = true; hours1Possible = false; hours2Possible = false; lessThanLeft = 60 }
            (minutes <= 120) -> { minutes15Possible = true; minutes30Possible = true; hours1Possible = true; hours2Possible = false; lessThanLeft = 120 }
            else -> { minutes15Possible = true; minutes30Possible = true; hours1Possible = true; hours2Possible = true; lessThanLeft = 0 }
        }
        
        val title = if (isRoutine) stringResource(id = R
.string.set_reminder) else {
            when (lessThanLeft) {
                15 -> { stringResource(id = R
.string.reminder_less_than_minutes_left, 15) }
                30 -> { stringResource(id = R
.string.reminder_less_than_minutes_left, 30) }
                60 -> { stringResource(id = R
.string.reminder_less_than_hour_left, 1) }
                120 -> { stringResource(id = R
.string.reminder_less_than_hours_left, 2) }
                else -> { stringResource(id = R
.string.reminder_more_than_hours_left, 2) }
            }
        }
        BottomSheetTitle(
            title = title,
            closeClickedCallback = { closeButtonClicked.invoke() }
        )

        Spacer(modifier = Modifier.height(16.dp))
        ReminderValueText("15 ${stringResource(id = R
.string.reminder_minutes_before)}", minutes15Possible) { valueClicked.invoke(15) }
        BottomSheetDividerLine()
        ReminderValueText("30 ${stringResource(id = R
.string.reminder_minutes_before)}", minutes30Possible) { valueClicked.invoke(30) }
        BottomSheetDividerLine()
        ReminderValueText("1 ${stringResource(id = R
.string.reminder_hour_before)}", hours1Possible) { valueClicked.invoke(60) }
        BottomSheetDividerLine()
        ReminderValueText("2 ${stringResource(id = R
.string.reminder_hours_before)}", hours2Possible) { valueClicked.invoke(120) }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun BottomSheetDividerLine() {
    Divider(
        color = MaterialTheme.colorScheme.primary,
        thickness = 1.dp,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    )
}

@Composable
private fun ReminderValueText(
    reminderText: String,
    selectable: Boolean,
    clickedCallback: () -> Unit
) {
    val textColour = if (selectable) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary
    Text(
        text = reminderText,
        color = textColour,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable {
                if (selectable) clickedCallback.invoke()
            },
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun BottomSheetTitle(
    title: String,
    closeClickedCallback: () -> Unit
) {
    Spacer(modifier = Modifier.height(32.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyLarge,
        )
        Spacer(modifier = Modifier.requiredWidth(8.dp))
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = CLIcons.Close),
            contentDescription = "",
            modifier = Modifier
                .requiredSize(32.dp)
                .clickable {
                    closeClickedCallback.invoke()
                }
        )
        Spacer(modifier = Modifier.width(16.dp))
    }
}