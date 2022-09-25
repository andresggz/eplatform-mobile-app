package co.edu.udea.eplatform.ui.screen.roadmap

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import co.edu.udea.eplatform.DataViewModel
import co.edu.udea.eplatform.model.MyCourse
import co.edu.udea.eplatform.model.MyRoadmap
import co.edu.udea.eplatform.navigation.AppScreens
import coil.compose.rememberAsyncImagePainter


@Composable
fun RoadmapScreen(navController: NavController, viewModel: DataViewModel = hiltViewModel()) {

    val currentRoadmapId = navController.currentBackStackEntry?.arguments?.getString("roadmapId")

    currentRoadmapId?.let { viewModel.getRoadmapById(Integer.valueOf(it)) }

    val roadmapState = viewModel.roadmap.collectAsState()

    Scaffold(topBar = {
        TopAppBar {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Volver",
                modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Ruta de aprendizaje")
        }
    }) {

        Column {
            DetailsContent(roadmapState.value)

            Spacer(modifier = Modifier.height(10.dp))

            BodyContent(navController, roadmapState.value.courses)
        }

    }
}

@Composable
fun DetailsContent(roadmap: MyRoadmap) {

    Column(Modifier.padding(start = 6.dp)) {
        Text(
            text = roadmap.name,
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Text(
            text = roadmap.description
        )
    }


}

@Composable
fun BodyContent(navController: NavController, courses: List<MyCourse>) {
    MyCourses(courses = courses, navController)
}

@Composable
fun MyCourses(courses: List<MyCourse>, navController: NavController) {
    LazyColumn {
        items(courses) { course ->
            Course(course = course, navController)
        }
    }
}

@Composable
fun Course(course: MyCourse, navController: NavController) {
    var context = LocalContext.current
    Row(modifier = Modifier
        .padding(8.dp)
        .clickable {
            navController.navigate(route = AppScreens.CourseScreen.route + "/" + course.id)
        }) {

        Image(
            painter = rememberAsyncImagePainter(course.iconId),
            null,
            modifier = Modifier.size(110.dp)
        )

        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .fillMaxWidth()
        ) {
            Text(text = course.name, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = course.description)
        }
    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun roadmapScreenPreview() {
    RoadmapScreen(rememberNavController())
}