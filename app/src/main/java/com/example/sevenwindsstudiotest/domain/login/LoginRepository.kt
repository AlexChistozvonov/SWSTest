package com.example.sevenwindsstudiotest.domain.login

import com.example.sevenwindsstudiotest.core.util.extantion.LoadingResult
import com.example.sevenwindsstudiotest.data.models.RegistrationResponse

interface LoginRepository {
    suspend fun login(login: String, password: String): LoadingResult<RegistrationResponse>
}