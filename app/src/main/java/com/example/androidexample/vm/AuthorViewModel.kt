package com.example.androidexample.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidexample.domain.AuthorRepositoryImpl
import com.example.androidexample.model.Author
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineExceptionHandler

class AuthorViewModel (private val authorRepository: AuthorRepositoryImpl = AuthorRepositoryImpl()) : ViewModel() {
    private val _authorUiState = MutableStateFlow(Author("initName", "initEmail"))
    val authorUiState = _authorUiState.asStateFlow()

    fun getAuthor() {
        viewModelScope.launch(CoroutineExceptionHandler{ _, exception ->
            println("CoroutineExceptionHandler got $exception") }) {
            authorRepository.getAuthor()
                .collect { author ->
                    _authorUiState.value = author
                }
        }
    }
}