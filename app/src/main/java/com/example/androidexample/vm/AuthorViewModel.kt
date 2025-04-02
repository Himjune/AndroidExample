package com.example.androidexample.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidexample.domain.AuthorRepositoryImpl
import com.example.androidexample.model.Author
import com.example.androidexample.network.ExampleApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineExceptionHandler

sealed interface AuthorUiState {
    data class Loaded(val photos: String) : AuthorUiState
}

class AuthorViewModel : ViewModel() {
    var authorData = Author("init","inti")
    fun getAuthor() {
        viewModelScope.launch{
            authorData = try {
                ExampleApi.api.getAuthor()
            } catch (e: Exception) {
                Author("error", e.toString())
            }
        }
    }
}