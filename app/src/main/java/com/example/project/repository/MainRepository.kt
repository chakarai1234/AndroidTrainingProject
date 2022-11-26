package com.example.project.repository

import com.example.project.api.jsonApi
import com.example.project.models.users.UsersResponse
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(private val jsonApi: jsonApi) {
    
    suspend fun getAllUsers(): Response<UsersResponse> {
        return jsonApi.getAllUsers()
    }
    
}
