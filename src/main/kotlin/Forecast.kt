import kotlinx.serialization.json.JsonObject

data class Forecast(
    val properties: Properties
) {
    data class Properties(val periods: List<Period>)

    data class Period(
        val number: Int,
        val name: String,
        val startTime: String,
        val endTime: String,
        val isDaytime: Boolean,
        val temperature: Int,
        val temperatureUnit: String,
        val temperatureTrend: String,
        val probabilityOfPrecipitation: JsonObject,
        val windSpeed: String,
        val windDirection: String,
        val shortForecast: String,
        val detailedForecast: String,
    )
}
