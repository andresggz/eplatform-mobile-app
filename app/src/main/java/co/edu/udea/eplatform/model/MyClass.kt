package co.edu.udea.eplatform.model

import java.time.LocalDate

data class MyClass(
    val id: Long = 0,
    val name: String = "",
    val description: String = "",
    val teacherName: String = "",
    val teacherPictureUrl: String = "",
    val videoUrl: String = "",
    val duration: Int = 0,
    val createDate: LocalDate = LocalDate.now(),
    val updateDate: LocalDate = LocalDate.now()
)