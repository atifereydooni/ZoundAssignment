package com.zoundindustries.main.domain.usecase

import com.zoundindustries.main.domain.entity.CryptocurrencyResponseEntity
import com.zoundindustries.main.domain.repo.CryptocurrencyRepository
import javax.inject.Inject

class CryptocurrencyUseCase @Inject constructor(private val repository: CryptocurrencyRepository) {

    suspend fun getCryptocurrency(): Result<List<CryptocurrencyResponseEntity>> {
        return repository.getCryptocurrency()
    }
}
