package co.edu.udea.eplatform.ui.screen.my_class

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import co.edu.udea.eplatform.DataViewModel
import co.edu.udea.eplatform.model.MyClass
import coil.compose.rememberAsyncImagePainter
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView


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
fun DetailsContent(myClass: MyClass) {


    Column(Modifier.padding(start = 6.dp)) {

        Text(
            text = myClass.name,
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )

        if (!myClass.videoUrl.equals("")) {
            VideoView(videoUri = myClass.videoUrl)
        }


        Spacer(modifier = Modifier.height(16.dp))


            Text(
                text = myClass.description
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = String.format("Duración: %s min", myClass.duration)
            )


        Spacer(modifier = Modifier.height(16.dp))

        Row() {
            Image(
                painter = rememberAsyncImagePainter(myClass.teacherPictureUrl),
                null,
                modifier = Modifier.size(50.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = myClass.teacherName
            )
        }
    }


}

@Composable
fun VideoView(videoUri: String) {
    val context = LocalContext.current

    val exoPlayer = ExoPlayer.Builder(LocalContext.current)
        .build()
        .also { exoPlayer ->
            val mediaItem = MediaItem.Builder()
                .setUri(videoUri)
                .build()
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
        }

    DisposableEffect(
        AndroidView(factory = {
            StyledPlayerView(context).apply {
                player = exoPlayer
            }
        })
    ) {
        onDispose { exoPlayer.release() }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun classScreenPreview() {
    DetailsContent(
        MyClass(
            1,
            "1. Instalando Git",
            "En esta clase..",
            "Marcos P.",
            "url...",
            "youtbe.com",
            3
        )
    )
}