package com.zoundindustries.main.presentation.component

import com.zoundindustries.main.domain.entity.CryptocurrencyResponseEntity

data class CryptocurrencyState(
    val refreshing: Boolean = false,
    val loading: Boolean = false,
    val CryptocurrencyList: List<CryptocurrencyResponseEntity> = listOf(),
    val currencyState: CurrencyState = CurrencyState.USD
)

enum class CurrencyState {
    USD, SEK
}