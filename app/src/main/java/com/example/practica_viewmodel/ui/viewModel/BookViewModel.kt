package com.example.practica_viewmodel.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica_viewmodel.data.Book
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {

    var books by mutableStateOf<List<Book>>(emptyList())

    var isLoading by mutableStateOf(false)

    fun loadBooks() {
        viewModelScope.launch {
            isLoading = true
            // Simular delay de carga
            delay(2000)
            books = listOf(
                Book("Cien años de soledad", "Gabriel García Márquez", "Realismo Mágico"),
                Book("1984", "George Orwell", "Distopía"),
                Book("El Principito", "Antoine de Saint-Exupéry", "Literatura Infantil"),
                Book("Don Quijote de la Mancha", "Miguel de Cervantes", "Novela"),
                Book("Rayuela", "Julio Cortázar", "Novela")
            )
            isLoading = false
        }
    }
}