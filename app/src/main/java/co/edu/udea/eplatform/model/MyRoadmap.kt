package co.edu.udea.eplatform.model

import java.time.LocalDate

data class MyRoadmap(
    val id: Long = 0,
    val name: String = "",
    val description: String = "",
    val detail: String = "",
    val iconId: String = "",
    val bannerId: String = "",
    val active: Boolean = false,
    val totalCourses: Int = 0,
    val createDate: LocalDate = LocalDate.now(),
    val updateDate: LocalDate = LocalDate.now(),
    val courses: List<MyCourse> = emptyList()
)