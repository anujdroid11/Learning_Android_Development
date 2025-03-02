package com.anujdroid.app4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anujdroid.app4.ui.theme.App4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column (modifier = Modifier.fillMaxSize().padding(innerPadding).fillMaxWidth()){

//                        Text(text = "Hello World")
//                        Text(text = "Hello World")
//                        Text(text = "Hello World")
//                        Text(text = "Hello World")
//                        Text(text = "Hello World")
//                        Text(text = "Hello World")
//                        Text(text = "Hello World")
//                        Text(text = "Hello World")
//                        Text(text = "Hello World")
//                        Text(text = "Hello World")

                        repeat(10){
                            Text(text = "Hello World")
                        }

                        var i = 1
                        while (i<=10) {
                            Text(text = "Hello Anuj Singh $i")
                            i++
                        }

                    }
                }
            }
        }
    }
}
