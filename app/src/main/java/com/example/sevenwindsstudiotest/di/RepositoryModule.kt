package com.example.sevenwindsstudiotest.di

import com.example.sevenwindsstudiotest.data.locations.LocationsRepositoryImpl
import com.example.sevenwindsstudiotest.data.login.LoginRepositoryImpl
import com.example.sevenwindsstudiotest.data.menu.MenuRepositoryImpl
import com.example.sevenwindsstudiotest.data.registration.RegistrationRepositoryImpl
import com.example.sevenwindsstudiotest.domain.locations.LocationsRepository
import com.example.sevenwindsstudiotest.domain.login.LoginRepository
import com.example.sevenwindsstudiotest.domain.menu.MenuRepository
import com.example.sevenwindsstudiotest.domain.registration.RegistrationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun registrationRepository(
        registrationRepository: RegistrationRepositoryImpl
    ): RegistrationRepository

    @Singleton
    @Binds
    abstract fun loginRepository(
        loginRepository: LoginRepositoryImpl
    ): LoginRepository

    @Singleton
    @Binds
    abstract fun locationsRepository(
        locationsRepository: LocationsRepositoryImpl
    ): LocationsRepository

    @Singleton
    @Binds
    abstract fun menuRepository(
        menuRepository: MenuRepositoryImpl
    ): MenuRepository
}
