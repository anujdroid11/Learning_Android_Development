package com.anujdroid.app3

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anujdroid.app3.ui.theme.App3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App3Theme {


                }
            }
        }


    fun OnStart() {
        super.onStart()

        Log.d("MainActivity","onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.d("MainActivity", "onResume:")
    }

    override fun onPause() {
        super.onPause()

        Log.d("MainActivity", "onResume:")
    }

    override fun onRestart() {
        super.onRestart()

        Log.d("MainActivity", "onResume:")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy:")
    }
}
