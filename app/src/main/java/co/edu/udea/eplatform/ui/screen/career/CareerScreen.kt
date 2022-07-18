package co.edu.udea.eplatform.ui.screen.career

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.edu.udea.eplatform.R
import co.edu.udea.eplatform.model.MyCareer
import java.time.LocalDate

private val roadmaps: List<MyCareer> = listOf(
    MyCareer(1, "Ruta de Back-end", "Ejemplo de descripcion", "/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyCareer(2, "Ruta de Front-end", "Ejemplo de descripcion", "/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyCareer(3, "Ruta de Android developer", "Ejemplo de descripcion", "/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyCareer(4, "Ruta de AI", "Ejemplo de descripcion larga", "/url.com", true, 23, LocalDate.now(), LocalDate.now())
)


@Composable
fun CareerScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Volver",
                modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Career")
        }
    }) {
        BodyContent(navController)
    }
}

@Composable
fun BodyContent(navController: NavController){
    MyRoadmaps(roadmaps = roadmaps, navController)
}

@Composable
fun MyRoadmaps(roadmaps: List<MyCareer>, navController: NavController){
    LazyColumn{
        items(roadmaps) { career -> Roadmap(career = career, navController)
        }
    }
}

@Composable
fun Roadmap(career: MyCareer, navController: NavController){
    var context = LocalContext.current
    Row(modifier = Modifier
        .padding(8.dp)
        .clickable {
            val toast = Toast.makeText(context, "Se hizo click", Toast.LENGTH_LONG)
            toast.show()
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