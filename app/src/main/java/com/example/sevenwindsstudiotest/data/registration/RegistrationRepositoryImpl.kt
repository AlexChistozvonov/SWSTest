package com.example.sevenwindsstudiotest.data.registration

import com.example.sevenwindsstudiotest.core.Api
import com.example.sevenwindsstudiotest.core.util.extantion.ErrorMapper
import com.example.sevenwindsstudiotest.core.util.extantion.LoadingResult
import com.example.sevenwindsstudiotest.core.util.extantion.runLoading
import com.example.sevenwindsstudiotest.data.models.RegistrationRequest
import com.example.sevenwindsstudiotest.data.models.RegistrationResponse
import com.example.sevenwindsstudiotest.di.IoDispatcher
import com.example.sevenwindsstudiotest.domain.registration.RegistrationRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RegistrationRepositoryImpl @Inject constructor(
    private val networkService: Api,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher,
    private val errorMapper: ErrorMapper
) : RegistrationRepository {
    override suspend fun registration(
        login: String,
        password: String,
    ): LoadingResult<RegistrationResponse> = withContext(coroutineDispatcher) {
        runLoading(errorMapper) {
            networkService.registration(RegistrationRequest(login = login, password = password))
        }
    }
}
