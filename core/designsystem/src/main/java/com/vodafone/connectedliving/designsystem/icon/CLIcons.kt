package com.vodafone.connectedliving.designsystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.vodafone.connectedliving.designsystem.R

data class ValidationIcon(
    val validIcon: Int,
    val errorIcon: Int,
)

val validationIcon = ValidationIcon(
    validIcon = R.drawable.ic_valid,
    errorIcon = R.drawable.ic_error,
)

object CLIcons {
    val SelectedForChat = R.drawable.ic_selected_for_chat
    val Confirm = R.drawable.ic_confirm
    val Error = R.drawable.ic_error
    val ChooserProfile = R.drawable.ic_profile_chooser_item
    val HowTo = R.drawable.ic_howto
    val Routines = R.drawable.ic_routines
    val Features = R.drawable.ic_feature
    val Notes = R.drawable.ic_note
    val Todo = R.drawable.ic_todo
    val Talk = R.drawable.ic_talk
    val Youtube = R.drawable.ic_youtube
    val Shop = R.drawable.ic_shop
    val MyDay = R.drawable.ic_myday
    val ChevronRightWhite = R.drawable.ic_white_chevron_right
    val PlayOutline = R.drawable.ic_play_outlined
    val EmptyScreen = R.drawable.ic_empty_screen
    val ExclamationMark = R.drawable.ic_exclamation_mark
    val AllActivitiesDone = R.drawable.ic_all_activities_done
    val EditPencil = R.drawable.ic_edit_pencil
    val TimePlaceholder = R.drawable.ic_time_placeholder
    val AlertTriangle = R.drawable.ic_alert_triangle_outlined_white
    val Close = R.drawable.ic_close_thin_black
    val ToggleOn = R.drawable.ic_active_toggle
    val ToggleOff = R.drawable.ic_inactive_toggle
    val CalendarPlaceholder = R.drawable.ic_calendar_placeholder
    val AudioSpeaker = R.drawable.ic_audio_speaker
    val IC_Chooser_OnBoarding = R.drawable.ic_chooser_onboarding
    val Add = R.drawable.ic_add
    val Delete = R.drawable.ic_delete_outlined
    val ReOrder = R.drawable.ic_reorder

    // val chat icons
    val Ic_Add = R.drawable.ic_add_user
    val Ic_Remove_Leave = R.drawable.ic_removed_left

    // HB - icons
    val Sensors_Environment = R.drawable.ic_hb_environment
    val Sensors_heart = R.drawable.ic_hb_heart_sensors
    val settings_refresh = R.drawable.ic_hb_settings_refresh
    val Sensors_voc = R.drawable.ic_hb_system_sensors_voc
    val Sensors_temperature = R.drawable.ic_hb_system_sensors_temprature
    val Sensors_humidity = R.drawable.ic_hb_system_sensors_humidity
    val Sensors_status = R.drawable.ic_hb_system_sensors_toggle
    val Sensors_CO2 = R.drawable.ic_hb_co2_gas
    val Sensors_location = R.drawable.ic_hb_location
    val Sensors_battery = R.drawable.ic_hb_battery
    val Sensors_pressure = R.drawable.ic_hb_pressure
    val Sensors_Signal = R.drawable.ic_hb_signal
    val Sensors_place_holder = R.drawable.ic_hb_placeholder_icon
    val active_devices = R.drawable.ic_active_device_icon
    val InActive = R.drawable.ic_in_active_device_icon
    val device_alarm = R.drawable.ic_device_alarm
    val property_alarm = R.drawable.ic_property_alarm
    val Device_signal = R.drawable.ic_device_signal
    val Device_Medium_signal = R.drawable.ic_device_medium_signal
    val Device_Low_signal = R.drawable.ic_device_low_signal
    val Device_low_battery = R.drawable.ic_device_low_battery
    val Device_Medium_battery = R.drawable.ic_device_medium_battery
    val Device_Height_battery = R.drawable.ic_device_height_battery
    val Full_Screen_Mode = R.drawable.ic_full_screen
    val Create_Chat = R.drawable.ic_create_chat
    val Back = R.drawable.ic_arrow_back
    val Group = R.drawable.ico_badge_group
    val Mute = R.drawable.ic_notification_mute

    val Ic_Alarm = R.drawable.ic_alert
    val CalendarPicker = R.drawable.ico_calendar
    val LeaveIcon = R.drawable.ico_logout
    val EditGroupIcon = R.drawable.ico_edit_group_chat
    val UsersOutline = R.drawable.users_outlined
}

/**
 * A sealed class to make dealing with [ImageVector] and [DrawableRes] icons easier.
 */
sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}
