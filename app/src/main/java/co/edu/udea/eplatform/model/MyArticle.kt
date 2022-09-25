package co.edu.udea.eplatform.model

import java.time.LocalDate

data class MyArticle(
    val id: Long = 0,
    val name: String = "",
    val content: String = "",
    val createDate: LocalDate = LocalDate.now(),
    val updateDate: LocalDate = LocalDate.now(),
)