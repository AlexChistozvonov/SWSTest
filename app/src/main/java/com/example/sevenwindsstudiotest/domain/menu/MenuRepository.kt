package com.example.sevenwindsstudiotest.domain.menu

import com.example.sevenwindsstudiotest.core.util.extantion.LoadingResult
import com.example.sevenwindsstudiotest.data.models.MenuResponse

interface MenuRepository {
    suspend fun getMenu(id: Int): LoadingResult<List<MenuResponse>>
}