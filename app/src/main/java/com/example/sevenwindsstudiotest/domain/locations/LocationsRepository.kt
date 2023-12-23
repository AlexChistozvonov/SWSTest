package com.example.sevenwindsstudiotest.domain.locations

import com.example.sevenwindsstudiotest.core.util.extantion.LoadingResult
import com.example.sevenwindsstudiotest.data.models.LocationsResponse

interface LocationsRepository {
    suspend fun getLocations(): LoadingResult<List<LocationsResponse>>
}