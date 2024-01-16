package com.bohunapps.moviesappcompose.Screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.bohunapps.moviesappcompose.MainViewModel
import com.bohunapps.moviesappcompose.data.models.Movie

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {
    val allMovies = viewModel.allMovies.observeAsState(listOf()).value
    allMovies.forEach { Log.d("checkData", it.name) }
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(modifier = Modifier.padding(5.dp),
            content = {
                items(allMovies) {
                    MovieItem(item = it)
                }
            })
    }
}

@Composable
fun MovieItem(item: Movie) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Color.LightGray)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(text = item.id.toString())
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = item.name, fontWeight = FontWeight.Bold, fontSize = 17.sp)
        Spacer(modifier = Modifier.weight(1f))
        AsyncImage(
            model = item.image.medium,
            contentDescription = null,
            modifier = Modifier
                .clip(
                    RoundedCornerShape(10.dp)
                )
                .size(80.dp),
            contentScale = ContentScale.Crop
        )
    }

}