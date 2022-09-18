package co.edu.udea.eplatform.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import co.edu.udea.eplatform.DataViewModel
import co.edu.udea.eplatform.R
import co.edu.udea.eplatform.model.MyCareer
import co.edu.udea.eplatform.navigation.AppScreens
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate

private val careers: List<MyCareer> = listOf(
    MyCareer(1, "Desarrollo e Ingeniería", "Ejemplo de descripcion", "/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyCareer(2, "Diseño UI/UX", "Ejemplo de descripcion", "/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyCareer(3, "Marketing", "Ejemplo de descripcion", "/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyCareer(4, "Contenido digital", "Ejemplo de descripcion larga", "/url.com", true, 23, LocalDate.now(), LocalDate.now())
)

@Composable
fun HomeScreen(navController: NavController, viewModel: DataViewModel = hiltViewModel()) {
    Scaffold(topBar = {
        TopAppBar {
            Text(text = "Home")
        }
    }) {
        BodyContent(navController)
    }
}

@Composable
fun BodyContent(navController: NavController){
    MyCareers(careers = careers, navController)
}

@Composable
fun MyCareers(careers: List<MyCareer>, navController: NavController){
    LazyColumn{
        items(careers) { career -> Career(career = career, navController)
        }
    }
}

@Composable
fun Career(career: MyCareer, navController: NavController){
    var context = LocalContext.current
    Row(modifier = Modifier
        .padding(8.dp)
        .clickable {
            navController.navigate(route = AppScreens.CareerScreen.route + "/" + career.id)
        }) {

       Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            "Esto es una imagen de prueba",
            modifier = Modifier.background(MaterialTheme.colors.primary))

        Column(modifier = Modifier
            .padding(start = 8.dp)
            .fillMaxWidth()) {
            Text(text = career.name)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = career.description)
        }
    }

}