package co.edu.udea.eplatform.model

import java.time.LocalDate

data class MyCareer(
    val id: Long,
    val name: String,
    val description: String,
    val iconId: String,
    val active: Boolean,
    val totalRoadMaps: Int,
    val createDate: LocalDate,
    val updateDate: LocalDate
)