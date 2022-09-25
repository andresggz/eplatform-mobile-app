package co.edu.udea.eplatform.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import co.edu.udea.eplatform.DataViewModel
import co.edu.udea.eplatform.model.MyArticle
import co.edu.udea.eplatform.model.MyCareer
import co.edu.udea.eplatform.navigation.AppScreens
import coil.compose.rememberAsyncImagePainter


@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar {
            Text(text = "Inicio")
        }
    }) {

        Column {
            Welcome()

            MyArticles(navController)

            Spacer(modifier = Modifier.height(16.dp))

            BodyContent(navController)


        }
    }
}

@Composable
fun Welcome(){

    Column() {
        Text(text = """
        Tú decides a dónde quieres llegar
    """.trimIndent(), Modifier.padding(5.dp, 5.dp, 5.dp, 5.dp),
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold)

        Text(text = """
        Especialízate en las áreas con mayor demanda laboral y aprende lo que necesitas para desarrollar tu perfil profesional
    """.trimIndent(), Modifier.padding(20.dp, 5.dp, 5.dp, 20.dp))
    }




}

@Composable
fun BodyContent(navController: NavController) {

    Column() {
        Text(text = """
        Explora ahora mismo todas las carreras disponibles!
    """.trimIndent(), Modifier.padding(5.dp, 5.dp, 5.dp, 5.dp),
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold)
    }

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



@Composable
fun Article(article: MyArticle, navController: NavController) {
    var context = LocalContext.current


    Text(text = article.name, modifier = Modifier
        .widthIn(0.dp, 135.dp)
        .padding(start = 5.dp, end = 5.dp)
        .clickable {
            navController.navigate(route = AppScreens.CareerScreen.route + "/" + article.id)
        }, maxLines = 5, fontWeight = FontWeight.Bold)

}

@Composable
fun MyArticles(navController: NavController, viewModel: DataViewModel = hiltViewModel()) {

    Column() {
        Text(text = """
        Últimos artículos
    """.trimIndent(), Modifier.padding(5.dp, 5.dp, 5.dp, 5.dp),
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold)
    }

    viewModel.getArticles()
    val articlesState by viewModel.articles.collectAsState()
    LazyRow(Modifier.padding(start = 10.dp)) {
        items(articlesState) { article ->
            Article(article = article, navController)
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun pre(){
}