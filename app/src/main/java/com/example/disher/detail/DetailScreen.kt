package com.example.disher.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.disher.R
import com.example.disher.detail.viewmodel.DetailViewModel

@OptIn(ExperimentalCoilApi::class)
@Composable
fun DetailScreen(
    viewmodel: DetailViewModel = hiltViewModel(),
    mealId: String?
) {

    //SIDE EFFECT
    DisposableEffect(key1 = Unit) {
        if (!mealId.isNullOrBlank()) {
            viewmodel.getDetailsForDishId(mealId)
        }
        onDispose { }
    }

    val singleDish by remember { viewmodel.meal }
    val uriHandler = LocalUriHandler.current

    singleDish?.let {
        Column(modifier = Modifier) {
            Text(it.strMeal)
            Text(it.strArea)
            //TODO ic_heart_outline
            Image(
                modifier = Modifier
                    .size(64.dp)
                    .clickable {
                        viewmodel.saveToFavourites(it)
                    },
                painter = painterResource(R.drawable.ic_heart),
                contentDescription = null
            )
            Image(
                modifier = Modifier.size(80.dp), painter = rememberImagePainter(
                    it.strMealThumb
                ), contentDescription = null
            )
            //TODO clickable link
            ClickableText(text = AnnotatedString(it.strYoutube), onClick = { _ ->
                uriHandler.openUri(it.strYoutube)
            })


            InstructionTextBlock(
                instructions = it.strInstructions
            )

        }
    }
}

fun Modifier.`if`(
    condition: Boolean,
    then: Modifier.() -> Modifier
): Modifier =
    if (condition) {
        then()
    } else {
        this
    }


@Composable
fun InstructionTextBlock(modifier: Modifier = Modifier, instructions: String) {
    var showmore by remember {
        mutableStateOf(false)
    }
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .verticalScroll(scrollState)

    ) {
        Text(modifier = Modifier
            .`if`(!showmore) {
                height(100.dp)
            }
            .`if`(!showmore) {
                drawWithContent {
                    val colors = listOf(Color.Transparent, Color.White)
                    drawContent()
                    drawRect(
                        brush = Brush.verticalGradient(colors)
                    )
                }
            }, text = instructions
        )
        Button(onClick = {
            showmore = !showmore
        }) {
            Text(text = "Show More...")
        }

    }
}
