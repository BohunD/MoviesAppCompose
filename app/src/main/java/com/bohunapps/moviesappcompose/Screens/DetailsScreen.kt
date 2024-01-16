package com.bohunapps.moviesappcompose.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.bohunapps.moviesappcompose.MainViewModel
import com.bohunapps.moviesappcompose.utils.HtmlText

@Composable
fun DetailsScreen(viewModel: MainViewModel, itemId: String) {
    val currentItem =
        viewModel.allMovies.observeAsState(listOf()).value.firstOrNull { it.id == itemId.toInt() }
    if (currentItem != null) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            LazyColumn(content = {
                item {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        AsyncImage(
                            model = currentItem.image.original,
                            contentDescription = null,
                            modifier = Modifier
                                .height(512.dp)
                                .clip(RoundedCornerShape(10.dp)),
                        )
                        Text(
                            text = currentItem.name,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 32.sp,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Row(modifier = Modifier.padding(top = 10.dp)) {
                            Text(text = "Rating: ", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                            Text(text = currentItem.rating.toString(), fontSize = 20.sp)
                        }
                        Row(modifier = Modifier.padding(top = 4.dp)) {
                            Text(text = "Genre: ", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                            Text(text = currentItem.genres.toString(), fontSize = 20.sp)
                        }
                        Row(modifier = Modifier.padding(top = 10.dp)) {
                            Text(
                                text = "Language: ",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                            Text(text = currentItem.language, fontSize = 20.sp)
                        }

                        HtmlText(html = currentItem.summary, modifier = Modifier.padding(top = 10.dp))


                    }
                }
            })
        }

    }
}