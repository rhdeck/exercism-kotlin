import java.time.LocalDateTime
import java.time.LocalDate
import java.time.Duration
data class Gigasecond(val initialDate: Any) {
    val date = (when (initialDate) { 
        is LocalDate -> initialDate.atTime(0,0)
        is LocalDateTime -> initialDate
        else -> throw IllegalArgumentException("This only takes a LocalDate or LocalDateTime")
    }).plus(Duration.ofSeconds(Math.pow(10.0,9.0).toLong()))
}