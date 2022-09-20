package co.edu.udea.eplatform.ui.screen.course

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import co.edu.udea.eplatform.DataViewModel
import co.edu.udea.eplatform.model.MyClass
import co.edu.udea.eplatform.model.MyCourse
import co.edu.udea.eplatform.navigation.AppScreens


@Composable
fun CourseScreen(navController: NavController, viewModel: DataViewModel = hiltViewModel()) {

    val currentCourseId = navController.currentBackStackEntry?.arguments?.getString("courseId")

    currentCourseId?.let { viewModel.getCourseById(Integer.valueOf(it)) }

    val courseState = viewModel.course.collectAsState()

    Scaffold(topBar = {
        TopAppBar {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Volver",
                modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Course")
        }
    }) {

        Column {
            DetailsContent(courseState.value)

            Spacer(modifier = Modifier.height(10.dp))

            BodyContent(navController, courseState.value.classes)
        }

    }
}

@Composable
fun DetailsContent(course: MyCourse){

    Column(Modifier.padding(start = 6.dp)) {
        Text(
            text = course.name,
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Text(
            text = course.description
        )

        Text(
            text = String.format("Total de clases: %s", course.totalClasses)
        )
    }


}

@Composable
fun BodyContent(navController: NavController, classes: List<MyClass>){
    MyClassC(classes = classes, navController)
}

@Composable
fun MyClassC(classes: List<MyClass>, navController: NavController){
    LazyColumn{
        items(classes) { myClass -> MyClassC(myClass = myClass, navController)
        }
    }
}

@Composable
fun MyClassC(myClass: MyClass, navController: NavController){
    var context = LocalContext.current
    Row(modifier = Modifier
        .padding(8.dp)
        .clickable {
            navController.navigate(route = AppScreens.ClassScreen.route + "/" + myClass.id)
        }) {

        Row(modifier = Modifier
            .padding(start = 8.dp)
            .fillMaxWidth().background(Color.LightGray)) {
            Icon(Icons.Default.PlayArrow, null)
            Text(text = myClass.name, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(16.dp))

            Spacer(Modifier.weight(1f))

            Text(text = String.format("%s min", myClass.duration))

        }
    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun courseScreenPreview(){
    MyClassC(MyClass(1, "1. Instalando Git", "En esta clase..", "Marcos P.", "url...", "youtbe.com", 3), rememberNavController())
}