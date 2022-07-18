package co.edu.udea.eplatform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.edu.udea.eplatform.model.MyCareer
import co.edu.udea.eplatform.ui.theme.EplatformTheme
import java.time.LocalDate

private val careers: List<MyCareer> = listOf(
    MyCareer(1, "Desarrollo e Ingeniería", "Ejemplo de descripcion", "/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyCareer(2, "Diseño UI/UX", "Ejemplo de descripcion", "/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyCareer(3, "Marketing", "Ejemplo de descripcion", "/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyCareer(4, "Contenido digital", "Ejemplo de descripcion larga", "/url.com", true, 23, LocalDate.now(), LocalDate.now())
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            EplatformTheme() {
                MyCareers(careers = careers)
            }
        }
    }
}

@Composable
fun Career(career: MyCareer){

    Row(modifier = Modifier.padding(8.dp)) {

        Image(painterResource(R.drawable.ic_launcher_foreground),
            "Esto es una imagen de prueba",
            modifier = Modifier.background(MaterialTheme.colors.primary))

        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(text = career.name)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = career.description)
        }
    }

}

@Composable
fun MyCareers(careers: List<MyCareer>){
    LazyColumn{
        items(careers) { career -> Career(career = career)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewComponent(){

    EplatformTheme() {
        MyCareers(careers = careers)
    }
}