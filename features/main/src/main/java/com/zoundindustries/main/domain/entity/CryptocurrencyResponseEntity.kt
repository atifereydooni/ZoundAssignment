package com.zoundindustries.main.domain.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CryptocurrencyResponseEntity(
    @Json(name = "askPrice")
    val askPrice: String?,
    @Json(name = "at")
    val at: Long?,
    @Json(name = "baseAsset")
    val baseAsset: String?,
    @Json(name = "bidPrice")
    val bidPrice: String?,
    @Json(name = "highPrice")
    val highPrice: String?,
    @Json(name = "lastPrice")
    val lastPrice: String?,
    @Json(name = "lowPrice")
    val lowPrice: String?,
    @Json(name = "openPrice")
    val openPrice: String?,
    @Json(name = "quoteAsset")
    val quoteAsset: String?,
    @Json(name = "symbol")
    val symbol: String?,
    @Json(name = "volume")
    val volume: String?
)