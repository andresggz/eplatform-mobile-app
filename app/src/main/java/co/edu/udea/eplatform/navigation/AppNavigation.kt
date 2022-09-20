package co.edu.udea.eplatform.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.edu.udea.eplatform.ui.screen.career.CareerScreen
import co.edu.udea.eplatform.ui.screen.course.CourseScreen
import co.edu.udea.eplatform.ui.screen.home.HomeScreen
import co.edu.udea.eplatform.ui.screen.my_class.MyClassScreen
import co.edu.udea.eplatform.ui.screen.roadmap.RoadmapScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.HomeScreen.route
    ){
        composable(route = AppScreens.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(route = AppScreens.CareerScreen.route + "/{careerId}"){
            CareerScreen(navController)
        }
        composable(route = AppScreens.RoadmapScreen.route + "/{roadmapId}"){
            RoadmapScreen(navController)
        }

        composable(route = AppScreens.CourseScreen.route + "/{courseId}"){
            CourseScreen(navController)
        }

        composable(route = AppScreens.ClassScreen.route + "/{classId}"){
            MyClassScreen(navController)
        }
    }
}