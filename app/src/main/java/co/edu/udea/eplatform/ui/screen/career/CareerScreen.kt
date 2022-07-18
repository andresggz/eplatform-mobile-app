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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.edu.udea.eplatform.R
import co.edu.udea.eplatform.model.MyRoadmap
import java.time.LocalDate

private val roadmaps: List<MyRoadmap> = listOf(
    MyRoadmap(1, "Curso de Git", "Ejemplo de descripcion","details...", "/url.com","/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyRoadmap(2, "Curso básico de Javascript", "Ejemplo de descripcion","detailes...", "/url.com","/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyRoadmap(3, "Curso intermedio de Javascript", "Ejemplo de descripcion","details...", "/url.com","/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyRoadmap(4, "Curso básico de Nodejs", "Ejemplo de descripcion larga", "details...", "/url.com","/url.com", true, 23, LocalDate.now(), LocalDate.now())
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
fun MyRoadmaps(roadmaps: List<MyRoadmap>, navController: NavController){
    LazyColumn{
        items(roadmaps) { roadmap -> Roadmap(roadmap = roadmap, navController)
        }
    }
}

@Composable
fun Roadmap(roadmap: MyRoadmap, navController: NavController){
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
            Text(text = roadmap.name)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = roadmap.description)
        }
    }

}