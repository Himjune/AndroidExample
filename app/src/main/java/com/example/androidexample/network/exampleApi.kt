package com.example.androidexample.network

import com.example.androidexample.model.Author
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ExampleApi {
    @GET("author")
    suspend fun getAuthor(): Author

    companion object RetrofitBuilder{
        private const val BASE_URL = "https://mocki.io/v1/f1f2f233-b520-43c9-990a-4749a49dd8d0"

        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val api: ExampleApi = getRetrofit().create()
    }
}