package com.bohunapps.moviesappcompose.Screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bohunapps.moviesappcompose.MainViewModel
import com.bohunapps.moviesappcompose.navigation.Destination
import com.bohunapps.moviesappcompose.ui.theme.MoviesAppComposeTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, viewModel: MainViewModel) {
    val startAnimate = remember {
        mutableStateOf(false)
    }
    val alphaAnimation = animateFloatAsState(
        targetValue = if(startAnimate.value) 1f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )
    LaunchedEffect(key1 = true ){
        startAnimate.value = true
        viewModel.getAllMovies()
        delay(4000)
        navController.navigate(Destination.Main.route)
    }
    Splash(alpha = alphaAnimation.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .alpha(alpha),
        contentAlignment = Alignment.Center)
    {
        Icon(
            Icons.Default.PlayArrow,
            contentDescription = "",
            modifier = Modifier.size(120.dp),
            tint = Color.Black
        )
    }
}
