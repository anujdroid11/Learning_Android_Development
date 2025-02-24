package com.anujdroid.notesapp1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    private val _screenState = MutableStateFlow(ScreenState())
    val screenState: StateFlow<ScreenState> = _screenState.asStateFlow()

    init {
        viewModelScope.launch {
            _screenState.update { currentState ->
                currentState.copy(
                    notesList = arrayListOf("Note 1", "Note 2", "Note 3") // Initialize Notes
                )
            }
        }
    }

    fun updateNote(oldNote: String, newNote: String) {
        viewModelScope.launch {
            _screenState.update { currentState ->
                val updatedList = currentState.notesList.map {
                    if (it == oldNote) newNote else it
                }
                currentState.copy(notesList = ArrayList(updatedList))
            }
        }
    }

    fun addNote(note: String) {
        viewModelScope.launch {
            _screenState.update { currentState ->
                val updatedList = ArrayList(currentState.notesList) // Copy current list
                updatedList.add(note) // Add new note
                currentState.copy(notesList = updatedList)
            }
        }
    }

    fun removeNote(noteToRemove: String) {
        viewModelScope.launch {
            _screenState.update { currentState ->
                val updatedList = ArrayList(currentState.notesList)
                updatedList.remove(noteToRemove)
                currentState.copy(notesList = updatedList)
            }
        }
    }
}

data class ScreenState(
    val notesList: ArrayList<String> = arrayListOf() // Notes List
)
