package com.anujdroid.app2

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation // Import for password masking
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Login() {

    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") } // State for password
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome To Login Page",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = username.value,
            onValueChange = { username.value = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)        )

        TextField(
            value = password.value,  // Bind to password state
            onValueChange = { password.value = it },  // Update password state
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(), // Mask the password
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)         )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (username.value.isBlank() || password.value.isBlank()) {
                    Toast.makeText(context, "Username and password cannot be empty", Toast.LENGTH_SHORT).show()
                } else {
                    // Perform your login logic here
                    println("Username: ${username.value}, Password: ${password.value}")
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                    // Navigate to the next screen or perform other actions
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
        {
            Text(text = "Login")
        }

    }
}

