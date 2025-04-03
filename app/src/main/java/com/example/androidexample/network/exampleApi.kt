package com.example.androidexample.network

import com.example.androidexample.model.Author
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ExampleApi {
    // В атрибуте GET указывается непосредственно конечная часть адреса
    // которая присоединится при вызове к базовой части
    // У вас это скорее будет "authors", и тогда полный адрес получится:
    // 192.168.1.2:8000/api/authors - такой, как даст вам бекендер
    @GET("4b24931d-5646-4d85-b14e-053e051d7de4")
    suspend fun getAuthor(): Author

    companion object RetrofitBuilder{
        // Базвая часть адреса (неизменяющаяся, у вас это чаще будет 192.168.1.2:8000/api/
        // Обязательно заканчивается на /
        private const val BASE_URL = "https://mocki.io/v1/"

        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val api: ExampleApi = getRetrofit().create()
    }
}