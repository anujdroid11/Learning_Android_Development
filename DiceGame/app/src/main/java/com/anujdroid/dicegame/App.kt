package org.anujdroid.dicegame

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anujdroid.dicegame.R


@Composable
fun App() {
    var isPlayer1 by remember { mutableStateOf(true) }
    var playerScores by remember { mutableStateOf(Array(2) { 0 }) }
    val diceImages = remember {
        listOf(
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6,
        )
    }
    var currentDiceImage by remember { mutableStateOf(R.drawable.dice_1) } // Initialize with a dice image

    Column(
        Modifier
            .fillMaxSize() // Corrected modifier
            .padding(16.dp) // Added padding for better visual appearance
    ) {
        Text(
            text = "Welcome To Ultimate Dice Game",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth() // Make Text occupy full width
                .align(Alignment.CenterHorizontally),
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(16.dp)) // Add space between title and image

        Image(
            painter = painterResource(currentDiceImage),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.CenterHorizontally) // Center the image
        )
        Spacer(modifier = Modifier.height(16.dp)) // Add space between image and button

        Button(
            onClick = {
                val randomNumber = (1..6).random()
                currentDiceImage = diceImages[randomNumber - 1]
                val updatedScores = playerScores.copyOf() // Create a copy to avoid state mutation
                if (isPlayer1) {
                    updatedScores[0] += randomNumber
                } else {
                    updatedScores[1] += randomNumber
                }
                playerScores = updatedScores // Update the state with the new array
                isPlayer1 = !isPlayer1
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = if (isPlayer1) "Roll the Dice for P1" else "Roll the Dice for P2")
        }
        Spacer(modifier = Modifier.height(16.dp)) // Add space between button and score

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text("Player 1 score \n ${playerScores[0]}", textAlign = TextAlign.Center)
            Text("Player 2 score \n ${playerScores[1]}", textAlign = TextAlign.Center)
        }

        Spacer(modifier = Modifier.weight(1f)) // Use weight to push reset button to bottom

        IconButton(
            onClick = {
                playerScores = Array(2) { 0 }
                isPlayer1 = true
                currentDiceImage = R.drawable.dice_1 // Reset to a dice image
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Icon(imageVector = Icons.Default.Refresh, contentDescription = "Reset")
        }
    }
}