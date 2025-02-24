package com.anujdroid.notesapp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.anujdroid.notesapp1.ui.theme.NotesApp1Theme
import com.anujdroid.notesapp1.ui.theme.PurpleGrey40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesApp1Theme {
                val viewModel by viewModels<MyViewModel>()
//                val state = viewModel.state.collectAsState()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Box(
                       modifier = Modifier
                           .fillMaxSize()
                           .padding(innerPadding).background(Color.Black)
                   ) {
                       App(viewModel)
                   }
                }
            }
        }
    }
}
