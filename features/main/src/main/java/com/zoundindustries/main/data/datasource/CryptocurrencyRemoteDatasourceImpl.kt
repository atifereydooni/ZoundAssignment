package com.zoundindustries.main.data.datasource

import com.zoundindustries.main.data.api.CryptocurrencyApiService
import com.zoundindustries.main.domain.entity.CryptocurrencyResponseEntity
import com.zoundindustries.main.util.handleResponse

class CryptocurrencyRemoteDatasourceImpl(private val api: CryptocurrencyApiService) :
    CryptocurrencyRemoteDatasource {

    override suspend fun getCryptocurrency(): Result<List<CryptocurrencyResponseEntity>> {
        return handleResponse {
            api.getCryptocurrency()
        }
    }

}


