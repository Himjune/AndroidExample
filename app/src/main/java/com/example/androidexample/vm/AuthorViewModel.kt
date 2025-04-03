package com.example.androidexample.vm

import android.util.Log

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidexample.model.Author
import com.example.androidexample.network.ExampleApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineExceptionHandler

class AuthorViewModel : ViewModel() {
    // Создаем объект-состояние, изменения которого будут отслеживаться во viewModel
    var authorData: Author by mutableStateOf(Author("in", "ie"))

    // При создании viewModel сразу запрашиваем данные от сервера
    init {
        getAuthor()
    }

    fun getAuthor() {
        viewModelScope.launch{
            authorData = try {
                ExampleApi.api.getAuthor()
            } catch (e: Exception) {
                Author("error", e.toString()) // Если ошибка, вписываем ее в объект вместо почты
            }
        }
    }
}