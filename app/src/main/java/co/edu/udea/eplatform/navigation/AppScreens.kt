package co.edu.udea.eplatform.navigation

sealed class AppScreens(val route: String) {
    object HomeScreen : AppScreens("home_screen")
    object CareerScreen : AppScreens("career_screen")
    object RoadmapScreen : AppScreens("roadmap_screen")
    object CourseScreen : AppScreens("course_screen")
    object ClassScreen : AppScreens("class_screen")

}