package com.borshevskiy.moviescompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat
import coil.compose.rememberImagePainter
import com.borshevskiy.moviescompose.MainViewModel
import com.borshevskiy.moviescompose.utils.HtmlText

@Composable
fun DetailsScreen(viewModel: MainViewModel, itemId: String) {

    val currentMovie = viewModel.allMovies.observeAsState(listOf()).value.firstOrNull { it.id == itemId.toInt() }

    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {
        LazyColumn {
            item {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painter = rememberImagePainter(currentMovie?.image?.medium), contentDescription = null,
                        modifier = Modifier
                            .size(500.dp)
                            .padding(top = 20.dp))
                    Text(text = currentMovie?.name ?: "", fontWeight = FontWeight.Bold, fontSize = 32.sp, modifier = Modifier.padding(top = 20.dp))
                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Text(text = "Rating: ", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        Text(text = currentMovie?.rating?.average.toString(), fontSize = 20.sp)
                    }
                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Text(text = "Genre: ", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        currentMovie?.genres?.take(2)?.forEach {
                            Text(text = "[$it] ", fontSize = 20.sp) }
                    }
                    Text(text = HtmlCompat.fromHtml(currentMovie?.summary ?: "", HtmlCompat.FROM_HTML_MODE_COMPACT).toString(), modifier = Modifier.padding(top = 10.dp), fontSize = 15.sp)
//                    HtmlText(html = currentMovie?.summary ?: "", Modifier.padding(top = 10.dp))
                }
            }
        }
    }
}