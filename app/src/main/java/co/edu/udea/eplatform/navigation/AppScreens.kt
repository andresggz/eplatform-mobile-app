package co.edu.udea.eplatform.navigation

sealed class AppScreens(val route: String) {
    object HomeScreen: AppScreens("home_screen")
    object CareerScreen: AppScreens("career_screen")

}