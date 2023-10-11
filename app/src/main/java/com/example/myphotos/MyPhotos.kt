import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MyPhotos() {
    val imageList = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8
    )

    var selectedImage by remember { mutableStateOf(-1) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyRow {
            items(imageList) { imageResId ->
                SelectableImage(
                    image = painterResource(id = imageResId),
                    isSelected = imageResId == selectedImage,
                    onClick = {
                        selectedImage = if (imageResId == selectedImage) {
                            -1
                        } else {
                            imageResId
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun SelectableImage(image: Painter, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(if (isSelected) 350.dp else 150.dp)
            .clickable {
                onClick()
            }
            .background(MaterialTheme.colorScheme.primaryVariant),
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}