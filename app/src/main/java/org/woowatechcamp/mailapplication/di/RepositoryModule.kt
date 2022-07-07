package org.woowatechcamp.mailapplication.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.woowatechcamp.mailapplication.data.repository.MailRepositoryImpl
import org.woowatechcamp.mailapplication.domain.MailRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindsMailRepository(repository: MailRepositoryImpl): MailRepository
}
