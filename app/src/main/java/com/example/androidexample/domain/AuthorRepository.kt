package com.example.androidexample.domain

import com.example.androidexample.model.Author
import kotlinx.coroutines.flow.Flow

interface AuthorRepository {
    fun getAuthor(): Flow<Author>
}