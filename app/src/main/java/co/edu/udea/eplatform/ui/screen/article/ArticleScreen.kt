package co.edu.udea.eplatform.ui.screen.article

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import co.edu.udea.eplatform.DataViewModel
import co.edu.udea.eplatform.model.MyArticle


@Composable
fun ArticleScreen(navController: NavController, viewModel: DataViewModel = hiltViewModel()) {

    val currentArticleId = navController.currentBackStackEntry?.arguments?.getString("articleId")

    currentArticleId?.let { viewModel.getArticleById(Integer.valueOf(it)) }

    val articleState = viewModel.article.collectAsState()

    Scaffold(topBar = {
        TopAppBar {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Volver",
                modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Artículo")
        }
    }) {

        Column {
            DetailsContent(articleState.value)
        }

    }
}

@Composable
fun DetailsContent(career: MyArticle) {

    Column(Modifier.padding(start = 6.dp)) {
        Text(
            text = career.name,
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = career.content
        )
    }


}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun articleScreenPreview() {
    ArticleScreen(rememberNavController())
}