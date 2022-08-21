package co.edu.udea.eplatform.model

import java.time.LocalDate

data class MyCourse(
    val id: Long,
    val name: String,
    val description: String,
    val detail: String,
    val iconId: String,
    val bannerId: String,
    val active: Boolean,
    val totalCourses: Int,
    val createDate: LocalDate,
    val updateDate: LocalDate
)