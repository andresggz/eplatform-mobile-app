package co.edu.udea.eplatform.model

import java.time.LocalDate

data class MyCareer(
    val id: Long = 0,
    val name: String = "",
    val description: String = "",
    val iconId: String = "",
    val active: Boolean = false,
    val totalRoadMaps: Int = 0,
    val createDate: LocalDate = LocalDate.now(),
    val updateDate: LocalDate = LocalDate.now(),
    val roadmaps: List<MyRoadmap> = emptyList()
)