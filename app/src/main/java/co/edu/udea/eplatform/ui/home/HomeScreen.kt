package co.edu.udea.eplatform.ui.home

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.edu.udea.eplatform.model.MyCareer
import co.edu.udea.eplatform.R
import java.time.LocalDate

private val careers: List<MyCareer> = listOf(
    MyCareer(1, "Desarrollo e Ingeniería", "Ejemplo de descripcion", "/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyCareer(2, "Diseño UI/UX", "Ejemplo de descripcion", "/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyCareer(3, "Marketing", "Ejemplo de descripcion", "/url.com", true, 23, LocalDate.now(), LocalDate.now()),
    MyCareer(4, "Contenido digital", "Ejemplo de descripcion larga", "/url.com", true, 23, LocalDate.now(), LocalDate.now())
)


@Composable
fun HomeScreen() {
    Scaffold {
        BodyContent()
    }
}

@Composable
fun BodyContent(){
    MyCareers(careers = careers)
}

@Composable
fun MyCareers(careers: List<MyCareer>){
    LazyColumn{
        items(careers) { career -> Career(career = career)
        }
    }
}

@Composable
fun Career(career: MyCareer){
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



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewComponent(){
    HomeScreen()
}