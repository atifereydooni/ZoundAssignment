package com.zoundindustries.main.data.datasource

import com.zoundindustries.main.domain.entity.CryptocurrencyResponseEntity


interface CryptocurrencyRemoteDatasource {

    suspend fun getCryptocurrency(): Result<List<CryptocurrencyResponseEntity>>

}
