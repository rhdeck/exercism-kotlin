
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Period
class Meetup(month: Int, year: Int) {
    val firstOfMonth = LocalDate.of(year, month, 1)
    fun day(dow: DayOfWeek, schedule: MeetupSchedule): LocalDate = when (schedule) {
            MeetupSchedule.LAST -> {
                val fourth = day(dow, MeetupSchedule.FOURTH)
                val fifth = fourth.plus(Period.ofDays(7))
                when { 
                    fourth.month == fifth.month -> fifth
                    else -> fourth
                }
            }
            MeetupSchedule.TEENTH -> {
                val testDate: LocalDate = day(dow, MeetupSchedule.SECOND)
                when {
                    testDate.getDayOfMonth() < 13 -> day(dow, MeetupSchedule.THIRD)
                    else -> testDate
                }
            }
            else -> firstOfMonth.plus(Period.ofDays(((dow.getValue() - firstOfMonth.getDayOfWeek().getValue()) + 7) % 7 + when (schedule) {
                MeetupSchedule.FIRST -> 0
                MeetupSchedule.SECOND -> 7
                MeetupSchedule.THIRD -> 14
                MeetupSchedule.FOURTH -> 21
                else -> throw IllegalArgumentException("Somehow you passed a bad meetup schedule")
            })) 
        }
}