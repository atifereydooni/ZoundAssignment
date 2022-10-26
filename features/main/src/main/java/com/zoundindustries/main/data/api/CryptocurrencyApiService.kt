package com.zoundindustries.main.data.api

import com.zoundindustries.main.domain.entity.CryptocurrencyResponseEntity
import retrofit2.http.GET

interface CryptocurrencyApiService {

    @GET("tickers/24hr")
    suspend fun getCryptocurrency(): List<CryptocurrencyResponseEntity>

}
