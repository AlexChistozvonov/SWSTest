package com.example.sevenwindsstudiotest.core

import com.example.sevenwindsstudiotest.data.models.LocationsResponse
import com.example.sevenwindsstudiotest.data.models.MenuResponse
import com.example.sevenwindsstudiotest.data.models.RegistrationRequest
import com.example.sevenwindsstudiotest.data.models.RegistrationResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {
    @POST("/auth/register")
    suspend fun registration(@Body registrationRequest: RegistrationRequest): RegistrationResponse

    @POST("/auth/login")
    suspend fun login(@Body loginRequest: RegistrationRequest): RegistrationResponse

    @GET("/locations")
    suspend fun getLocations(): List<LocationsResponse>

    @GET("location/{id}/menu")
    suspend fun getMenu(@Path("id") id: Int): List<MenuResponse>
}
