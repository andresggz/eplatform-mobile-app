package co.edu.udea.eplatform.ui.screen.career

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
import co.edu.udea.eplatform.model.MyCareer
import co.edu.udea.eplatform.model.MyRoadmap
import co.edu.udea.eplatform.navigation.AppScreens
import coil.compose.rememberAsyncImagePainter


@Composable
fun CareerScreen(navController: NavController, viewModel: DataViewModel = hiltViewModel()) {

    val currentCareerId = navController.currentBackStackEntry?.arguments?.getString("careerId")

    currentCareerId?.let { viewModel.getCareerById(Integer.valueOf(it)) }

    val careerState = viewModel.career.collectAsState()

    Scaffold(topBar = {
        TopAppBar {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Volver",
                modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Career")
        }
    }) {

        Column {
            DetailsContent(careerState.value)

            Spacer(modifier = Modifier.height(10.dp))

            BodyContent(navController, careerState.value.roadmaps)
        }

    }
}

@Composable
fun DetailsContent(career: MyCareer) {

    Column(Modifier.padding(start = 6.dp)) {
        Text(
            text = career.name,
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Text(
            text = career.description
        )
    }


}

@Composable
fun BodyContent(navController: NavController, roadmaps: List<MyRoadmap>) {
    MyRoadmaps(roadmaps = roadmaps, navController)
}

@Composable
fun MyRoadmaps(roadmaps: List<MyRoadmap>, navController: NavController) {
    LazyColumn {
        items(roadmaps) { roadmap ->
            Roadmap(roadmap = roadmap, navController)
        }
    }
}

@Composable
fun Roadmap(roadmap: MyRoadmap, navController: NavController) {
    var context = LocalContext.current
    Row(modifier = Modifier
        .padding(8.dp)
        .clickable {
            //val toast = Toast.makeText(context, "Se hizo click", Toast.LENGTH_LONG)
            //toast.show()
            navController.navigate(route = AppScreens.RoadmapScreen.route + "/" + roadmap.id)
        }) {

        Image(
            painter = rememberAsyncImagePainter(roadmap.iconId),
            null,
            modifier = Modifier.size(110.dp)
        )

        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .fillMaxWidth()
        ) {
            Text(text = roadmap.name, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = roadmap.description)
        }
    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun careerScreenPreview() {
    CareerScreen(rememberNavController())
}