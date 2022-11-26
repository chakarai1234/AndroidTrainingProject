package com.example.project.api

import com.example.project.models.users.UsersResponse
import retrofit2.Response
import retrofit2.http.GET

interface jsonApi {
    
    @GET("users")
    suspend fun getAllUsers(): Response<UsersResponse>
    
}
