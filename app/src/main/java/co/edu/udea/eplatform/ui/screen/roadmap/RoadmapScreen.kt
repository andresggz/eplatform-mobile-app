package co.edu.udea.eplatform.ui.screen.roadmap

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import co.edu.udea.eplatform.R
import co.edu.udea.eplatform.model.MyCourse
import java.time.LocalDate

private val courses: List<MyCourse> = listOf(
    MyCourse(1, "Curso de .Net Core", "Ejemplo de descripcion","details...", "/url.com","/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyCourse(2, "Curso de Java Developer", "Ejemplo de descripcion","detailes...", "/url.com","/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyCourse(3, "Curso de Javascript developer", "Ejemplo de descripcion","details...", "/url.com","/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyCourse(4, "Curso de Android Developer", "Ejemplo de descripcion larga", "details...", "/url.com","/url.com", true, 23, LocalDate.now(), LocalDate.now())
)


@Composable
fun RoadmapScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Volver",
                modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Roadmap")
        }
    }) {

        Column {
            DetailsContent("Desarrollo e Ingeniería")

            Spacer(modifier = Modifier.height(10.dp))

            BodyContent(navController)
        }

    }
}

@Composable
fun DetailsContent(title: String){

    Column(Modifier.padding(start = 6.dp)) {
        Text(
            text = title,
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Text(
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                    " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                    " when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        )
    }


}

@Composable
fun BodyContent(navController: NavController){
    MyCourses(courses = courses, navController)
}

@Composable
fun MyCourses(courses: List<MyCourse>, navController: NavController){
    LazyColumn{
        items(courses) { course -> Course(course = course, navController)
        }
    }
}

@Composable
fun Course(course: MyCourse, navController: NavController){
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
            Text(text = course.name, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = course.description)
        }
    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun roadmapScreenPreview(){
    RoadmapScreen(rememberNavController())
}