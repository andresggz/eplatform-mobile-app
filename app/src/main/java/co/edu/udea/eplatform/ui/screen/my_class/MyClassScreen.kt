package co.edu.udea.eplatform.ui.screen.my_class

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import co.edu.udea.eplatform.DataViewModel
import co.edu.udea.eplatform.model.MyClass


@Composable
fun MyClassScreen(navController: NavController, viewModel: DataViewModel = hiltViewModel()) {

    val currentClassId = navController.currentBackStackEntry?.arguments?.getString("classId")

    currentClassId?.let { viewModel.getClassById(Integer.valueOf(it)) }

    val classState = viewModel.myClass.collectAsState()

    Scaffold(topBar = {
        TopAppBar {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Volver",
                modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Class")
        }
    }) {

        Column {
            DetailsContent(classState.value)

            Spacer(modifier = Modifier.height(10.dp))
        }

    }
}

@Composable
fun DetailsContent(myClass: MyClass){



    Column(Modifier.padding(start = 6.dp)) {

        Text(
            text = String.format("Aca va el video: %s", myClass.videoUrl)
        )

        Text(
            text = myClass.name,
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Text(
            text = myClass.description
        )

        Text(
            text = String.format("Duración: %s", myClass.duration)
        )

        Text(
            text = String.format("Profesor foto: %s", myClass.teacherPictureUrl)
        )

        Text(
            text = String.format("Profesor: %s", myClass.teacherName)
        )
    }


}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun classScreenPreview(){
    DetailsContent(MyClass(1, "1. Instalando Git", "En esta clase..", "Marcos P.", "url...", "youtbe.com", 3))
}