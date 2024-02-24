package com.org.test.randomusersapp.data.di.modules

import com.org.test.randomusersapp.data.domain.repository.users.UsersRepository
import com.org.test.randomusersapp.data.repository.usersImpl.UsersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UsersRepositoryModule {

    @Binds
    @Singleton
    abstract fun userRepository(usersRepository: UsersRepositoryImpl): UsersRepository
}