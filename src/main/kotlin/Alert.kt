data class Alert(
    val features: List<Feature>
) {
    data class Feature(
        val properties: Properties
    )

    data class Properties(
        val event: String,
        val areaDesc: String,
        val severity: String,
        val description: String,
        val instruction: String?,
    )
}
