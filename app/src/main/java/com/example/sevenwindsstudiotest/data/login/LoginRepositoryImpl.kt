package com.example.sevenwindsstudiotest.data.login

import com.example.sevenwindsstudiotest.core.Api
import com.example.sevenwindsstudiotest.core.util.extantion.ErrorMapper
import com.example.sevenwindsstudiotest.core.util.extantion.runLoading
import com.example.sevenwindsstudiotest.data.models.RegistrationRequest
import com.example.sevenwindsstudiotest.di.IoDispatcher
import com.example.sevenwindsstudiotest.domain.login.LoginRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val networkService: Api,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher,
    private val errorMapper: ErrorMapper
) : LoginRepository {
    override suspend fun login(login: String, password: String) = withContext(coroutineDispatcher) {
        runLoading(errorMapper) {
            networkService.login(RegistrationRequest(login = login, password = password))
        }
    }
}
