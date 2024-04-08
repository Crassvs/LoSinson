package com.crassvs.losinson.network

import com.crassvs.losinson.models.Personaje
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("quotes?count=15")
        suspend fun obtenerPersonajes(): Response<List<Personaje>>

    @GET("quotes")
    suspend fun obtenerPersonaje(
        @Query("character") personaje: String
    ): Response<List<Personaje>>

}