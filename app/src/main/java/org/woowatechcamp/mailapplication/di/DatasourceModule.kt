package org.woowatechcamp.mailapplication.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.woowatechcamp.mailapplication.data.datasource.MailDatasource
import org.woowatechcamp.mailapplication.data.datasource.MailDatasourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DatasourceModule {
    @Binds
    @Singleton
    fun bindsMailDatasource(datasource: MailDatasourceImpl): MailDatasource
}
