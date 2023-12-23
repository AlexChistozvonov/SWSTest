package com.example.sevenwindsstudiotest.data.locations

import com.example.sevenwindsstudiotest.core.Api
import com.example.sevenwindsstudiotest.core.util.extantion.ErrorMapper
import com.example.sevenwindsstudiotest.core.util.extantion.LoadingResult
import com.example.sevenwindsstudiotest.core.util.extantion.runLoading
import com.example.sevenwindsstudiotest.data.models.LocationsResponse
import com.example.sevenwindsstudiotest.di.IoDispatcher
import com.example.sevenwindsstudiotest.domain.locations.LocationsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocationsRepositoryImpl @Inject constructor(
    private val networkService: Api,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher,
    private val errorMapper: ErrorMapper
) : LocationsRepository {
    override suspend fun getLocations(): LoadingResult<List<LocationsResponse>> =
        withContext(coroutineDispatcher) {
            runLoading(errorMapper) {
                networkService.getLocations()
            }
        }
}
