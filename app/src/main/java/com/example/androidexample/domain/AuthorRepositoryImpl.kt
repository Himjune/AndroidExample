package com.example.androidexample.domain

import com.example.androidexample.model.Author
import com.example.androidexample.network.ExampleApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class AuthorRepositoryImpl : AuthorRepository {
    override fun getAuthor(): Flow<Author> =
        callbackFlow {
            trySendBlocking(
                ExampleApi.api.getAuthor()
            )
            awaitClose()
        }
}