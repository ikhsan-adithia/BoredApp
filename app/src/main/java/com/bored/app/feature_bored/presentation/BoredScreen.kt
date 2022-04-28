package com.bored.app.feature_bored.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bored.app.feature_bored.domain.model.RandomActivity

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BoredScreen(viewModel: BoredViewModel = hiltViewModel()) {
    val state = viewModel.state.value

    Surface(
        modifier = Modifier.fillMaxSize(),
        onClick = {
            viewModel.getRandomActivity()
        }
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            state.randomActivity?.let { ActivitySuggestion(it) }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Tap anywhere\n for a random activity",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    color = Color(0x33000000),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Black,
                    fontFamily = FontFamily.Serif
                )
            )
        }

        if (state.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0x33000000)),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}

@Composable
fun ActivitySuggestion(randomActivity: RandomActivity) {
    Column(
        modifier = Modifier.padding(30.dp, 0.dp, 30.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Activity: \n ${randomActivity.activity}",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily.Monospace
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Type: ${randomActivity.type}",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily.Monospace
            )
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Participant: ${randomActivity.participants}",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily.Monospace
            )
        )
    }
}