package com.zoundindustries.main

import com.zoundindustries.main.domain.entity.CryptocurrencyResponseEntity

fun getMockDataList(): List<CryptocurrencyResponseEntity> {
    return listOf(
        CryptocurrencyResponseEntity(
            symbol = "btcusdt",
            baseAsset = "btc",
            quoteAsset = "usdt",
            openPrice = "40.08",
            lowPrice = "39.35",
            highPrice = "40.949",
            lastPrice = "39.7025",
            volume = "75777.5",
            bidPrice = "39.7226",
            askPrice = "40.4999",
            at = 1666883802000
        )
    )
}

fun getMockDataList3Items(): List<CryptocurrencyResponseEntity> {
    return listOf(
        CryptocurrencyResponseEntity(
            symbol = "btcusdt",
            baseAsset = "btc",
            quoteAsset = "usdt",
            openPrice = "40.08",
            lowPrice = "39.35",
            highPrice = "40.949",
            lastPrice = "39.7025",
            volume = "75777.5",
            bidPrice = "39.7226",
            askPrice = "40.4999",
            at = 1666883802000
        ),
        CryptocurrencyResponseEntity(
            symbol = "trxusdt",
            baseAsset = "trx",
            quoteAsset = "usdt",
            openPrice = "40.08",
            lowPrice = "39.35",
            highPrice = "40.949",
            lastPrice = "39.7025",
            volume = "75777.5",
            bidPrice = "39.7226",
            askPrice = "40.4999",
            at = 1666883802000
        ),
        CryptocurrencyResponseEntity(
            symbol = "ethusdt",
            baseAsset = "eth",
            quoteAsset = "usdt",
            openPrice = "40.08",
            lowPrice = "39.35",
            highPrice = "40.949",
            lastPrice = "39.7025",
            volume = "75777.5",
            bidPrice = "39.7226",
            askPrice = "40.4999",
            at = 1666883802000
        )
    )
}