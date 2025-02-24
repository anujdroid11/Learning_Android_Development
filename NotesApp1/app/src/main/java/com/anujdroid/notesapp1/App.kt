package com.anujdroid.notesapp1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(viewModel: MyViewModel) {
    val state by viewModel.screenState.collectAsStateWithLifecycle()
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Notes App", fontWeight = FontWeight.Bold) }, // Bold title
                actions = {
                    IconButton(onClick = { /* TODO: Menu action */ }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true },
                modifier = Modifier.padding(16.dp),
                containerColor = MaterialTheme.colorScheme.primary // Use primary color
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Note")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background) // Background color
        ) {

            if (showDialog) {
                AddDialog(
                    onDismiss = { showDialog = false },
                    onNoteAdded = { note ->
                        viewModel.addNote(note)
                        showDialog = false
                    }
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(state.notesList) { note ->
                    NoteCard(note)
                }
            }
        }
    }
}

@Composable
fun NoteCard(note: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp) // Add elevation
    ) {
        Text(
            text = note,
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.onSurface // Text color
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDialog(
    onDismiss: () -> Unit,
    onNoteAdded: (String) -> Unit,
) {
    var noteText by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier.padding(16.dp),
            shape = MaterialTheme.shapes.medium,
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // Elevation for dialog
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Add Note",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold // Bold dialog title
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = noteText,
                    onValueChange = { noteText = it },
                    placeholder = { Text("Enter your note") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary, // Primary color for focus
                        cursorColor = MaterialTheme.colorScheme.primary // Primary color for cursor
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically // Align buttons vertically
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel", color = MaterialTheme.colorScheme.primary) // Primary color for cancel
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            if (noteText.isNotBlank()) {
                                onNoteAdded(noteText)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary // Primary color for add
                        )
                    ) {
                        Text("Add", color = Color.White) // White text on primary button
                    }
                }
            }
        }
    }
}