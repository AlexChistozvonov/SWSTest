package com.example.sevenwindsstudiotest.domain.registration

import com.example.sevenwindsstudiotest.core.util.extantion.LoadingResult
import com.example.sevenwindsstudiotest.data.models.RegistrationResponse

interface RegistrationRepository {

    suspend fun registration(
        login: String,
        password: String
    ): LoadingResult<RegistrationResponse>
}