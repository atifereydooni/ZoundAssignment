package com.zoundindustries.main.di

import com.zoundindustries.main.data.CryptocurrencyRepositoryImpl
import com.zoundindustries.main.data.api.CryptocurrencyApiService
import com.zoundindustries.main.data.datasource.CryptocurrencyRemoteDatasource
import com.zoundindustries.main.data.datasource.CryptocurrencyRemoteDatasourceImpl
import com.zoundindustries.main.domain.repo.CryptocurrencyRepository
import com.zoundindustries.main.domain.usecase.CryptocurrencyUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CryptocurrencyModule {

    @Singleton
    @Provides
    fun provideCryptocurrencyRepository(
        remote: CryptocurrencyRemoteDatasource
    ): CryptocurrencyRepository {
        return CryptocurrencyRepositoryImpl(remote = remote)
    }

    @Singleton
    @Provides
    fun providesCryptocurrencyRemoteData(@NormalRetrofitClient retrofit: Retrofit): CryptocurrencyRemoteDatasource {
        return CryptocurrencyRemoteDatasourceImpl(api = retrofit.create(CryptocurrencyApiService::class.java))
    }

    @Singleton
    @Provides
    fun providesCryptocurrencyUseCase(repository: CryptocurrencyRepository): CryptocurrencyUseCase {
        return CryptocurrencyUseCase(repository)
    }

}
