package co.edu.udea.eplatform.di

import co.edu.udea.eplatform.repository.DataRepository
import co.edu.udea.eplatform.repository.DataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun dataRepository(repo: DataRepositoryImpl): DataRepository
}