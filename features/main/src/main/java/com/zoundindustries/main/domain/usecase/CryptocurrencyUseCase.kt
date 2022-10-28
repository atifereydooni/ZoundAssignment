package com.zoundindustries.main.domain.usecase

import com.zoundindustries.main.domain.entity.CryptocurrencyResponseEntity
import com.zoundindustries.main.domain.repo.CryptocurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CryptocurrencyUseCase @Inject constructor(private val repository: CryptocurrencyRepository) {

    suspend fun getCryptocurrency(): Flow<Result<List<CryptocurrencyResponseEntity>>> {
        return flow {
            emit(repository.getCryptocurrency())
        }
    }
}
