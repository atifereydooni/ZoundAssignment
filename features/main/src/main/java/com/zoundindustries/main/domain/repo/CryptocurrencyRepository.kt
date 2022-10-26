package com.zoundindustries.main.domain.repo

import com.zoundindustries.main.domain.entity.CryptocurrencyResponseEntity

interface CryptocurrencyRepository {

    suspend fun getCryptocurrency(): Result<List<CryptocurrencyResponseEntity>>

}
