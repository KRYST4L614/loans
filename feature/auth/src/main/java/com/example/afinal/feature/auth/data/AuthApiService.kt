package com.example.afinal.feature.auth.data

import com.example.afinal.feature.auth.domain.entities.LoggedUser
import com.example.afinal.feature.auth.domain.entities.LoginUser
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("auth/login")
    fun login(
        @Body requestBody: LoginUser
    ): Call<String>

    @POST("auth/registration")
    fun registration(
        @Body requestBody: LoginUser
    ): Call<LoggedUser>
}