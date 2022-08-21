package co.edu.udea.eplatform.ui.screen.career

import android.util.Log
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
import co.edu.udea.eplatform.model.MyRoadmap
import co.edu.udea.eplatform.navigation.AppScreens
import java.time.LocalDate

private val roadmaps: List<MyRoadmap> = listOf(
    MyRoadmap(1, "Ruta de .Net Core", "Ejemplo de descripcion","details...", "/url.com","/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyRoadmap(2, "Ruta de Java Developer", "Ejemplo de descripcion","detailes...", "/url.com","/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyRoadmap(3, "Ruta de Javascript developer", "Ejemplo de descripcion","details...", "/url.com","/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyRoadmap(4, "Ruta de Android Developer", "Ejemplo de descripcion larga", "details...", "/url.com","/url.com", true, 23, LocalDate.now(), LocalDate.now())
)


@Composable
fun CareerScreen(navController: NavController) {

    val currentCareerId = navController.currentBackStackEntry?.arguments?.getString("careerId")

    currentCareerId?.let { Log.i("CareerScreen current career", it) }

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
            //val toast = Toast.makeText(context, "Se hizo click", Toast.LENGTH_LONG)
            //toast.show()
            navController.navigate(route = AppScreens.RoadmapScreen.route + "/" + roadmap.id)
        }) {

        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            "Esto es una imagen de prueba",
            modifier = Modifier.background(MaterialTheme.colors.primary))

        Column(modifier = Modifier
            .padding(start = 8.dp)
            .fillMaxWidth()) {
            Text(text = roadmap.name, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = roadmap.description)
        }
    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun careerScreenPreview(){
    CareerScreen(rememberNavController())
}