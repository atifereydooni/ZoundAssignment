package com.zoundindustries.main.data

import com.zoundindustries.main.data.datasource.CryptocurrencyRemoteDatasource
import com.zoundindustries.main.domain.entity.CryptocurrencyResponseEntity
import com.zoundindustries.main.domain.repo.CryptocurrencyRepository
import javax.inject.Inject

class CryptocurrencyRepositoryImpl @Inject constructor(private val remote: CryptocurrencyRemoteDatasource) :
    CryptocurrencyRepository {

    override suspend fun getCryptocurrency(): Result<List<CryptocurrencyResponseEntity>> {
        return remote.getCryptocurrency()
    }

}
