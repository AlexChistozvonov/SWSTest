package com.example.sevenwindsstudiotest.data.menu

import com.example.sevenwindsstudiotest.core.Api
import com.example.sevenwindsstudiotest.core.util.extantion.ErrorMapper
import com.example.sevenwindsstudiotest.core.util.extantion.LoadingResult
import com.example.sevenwindsstudiotest.core.util.extantion.runLoading
import com.example.sevenwindsstudiotest.data.models.MenuResponse
import com.example.sevenwindsstudiotest.di.IoDispatcher
import com.example.sevenwindsstudiotest.domain.menu.MenuRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    private val networkService: Api,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher,
    private val errorMapper: ErrorMapper
) : MenuRepository {

    override suspend fun getMenu(id: Int): LoadingResult<List<MenuResponse>> =
        withContext(coroutineDispatcher) {
            runLoading(errorMapper) {
                networkService.getMenu(id = id)
            }
        }
}
