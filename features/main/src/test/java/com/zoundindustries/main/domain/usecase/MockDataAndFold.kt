package com.zoundindustries.main.domain.usecase

import com.zoundindustries.main.domain.entity.CryptocurrencyResponseEntity

inline fun <R, reified T> Result<T>.mockSafeFold(
    onSuccess: (value: T) -> R,
    onFailure: (exception: Throwable) -> R
): R = when {
    isSuccess -> {
        val value = getOrNull()
        try {
            onSuccess(value as T)
        } catch (e: ClassCastException) {
            // This block of code is only executed in testing environment, when we are mocking a
            // function that returns a `Result` object.
            val valueNotNull = value!!
            if ((value as Result<*>).isSuccess) {
                valueNotNull::class.java.getDeclaredField("value").let {
                    it.isAccessible = true
                    it.get(value) as T
                }.let(onSuccess)
            } else {
                valueNotNull::class.java.getDeclaredField("value").let {
                    it.isAccessible = true
                    it.get(value)
                }.let { failure ->
                    failure!!::class.java.getDeclaredField("exception").let {
                        it.isAccessible = true
                        it.get(failure) as Exception
                    }
                }.let(onFailure)
            }
        }
    }
    else -> onFailure(exceptionOrNull() ?: Exception())
}

fun getMockDataList(): List<CryptocurrencyResponseEntity> {
    return listOf(
        CryptocurrencyResponseEntity(
            symbol = "xrpinr",
            baseAsset = "xrp",
            quoteAsset = "inr",
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