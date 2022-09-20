package co.edu.udea.eplatform.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import co.edu.udea.eplatform.DataViewModel
import co.edu.udea.eplatform.model.MyCareer
import co.edu.udea.eplatform.navigation.AppScreens
import coil.compose.rememberAsyncImagePainter


@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar {
            Text(text = "Home")
        }
    }) {
        BodyContent(navController)
    }
}

@Composable
fun BodyContent(navController: NavController) {
    MyCareers(navController)
}

@Composable
fun MyCareers(navController: NavController, viewModel: DataViewModel = hiltViewModel()) {
    viewModel.getCareers()
    val careersState by viewModel.careers.collectAsState()
    LazyColumn {
        items(careersState) { career ->
            Career(career = career, navController)
        }
    }
}

@Composable
fun Career(career: MyCareer, navController: NavController) {
    var context = LocalContext.current
    Row(modifier = Modifier
        .padding(8.dp)
        .clickable {
            navController.navigate(route = AppScreens.CareerScreen.route + "/" + career.id)
        }) {

        Image(
            painter = rememberAsyncImagePainter(career.iconId),
            null,
            modifier = Modifier.size(110.dp)
        )

        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .fillMaxWidth()
        ) {
            Text(text = career.name)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = career.description)
        }
    }

}