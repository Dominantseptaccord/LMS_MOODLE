package com.example.myapplication

import java.util.Calendar

enum class WeekDay {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;

    companion object {
        fun from(dayOfWeek: Int): WeekDay {
            return when (dayOfWeek) {
                Calendar.SUNDAY -> SUNDAY
                Calendar.MONDAY -> MONDAY
                Calendar.TUESDAY -> TUESDAY
                Calendar.WEDNESDAY -> WEDNESDAY
                Calendar.THURSDAY -> THURSDAY
                Calendar.FRIDAY -> FRIDAY
                Calendar.SATURDAY -> SATURDAY
                else -> throw IllegalArgumentException("Invalid day of the week")
            }
        }
    }
}