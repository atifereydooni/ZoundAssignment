package com.zoundindustries.main.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zoundindustries.main.domain.usecase.CryptocurrencyUseCase
import com.zoundindustries.main.presentation.component.CryptocurrencyState
import com.zoundindustries.main.presentation.component.CurrencyState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    private val cryptocurrencyUseCase: CryptocurrencyUseCase
) : ViewModel() {

    val cryptocurrencyState: MutableState<CryptocurrencyState> =
        mutableStateOf(CryptocurrencyState())

    init {
        getCryptocurrencies()
    }


    private fun getCryptocurrencies() {
        cryptocurrencyState.value =
            cryptocurrencyState.value.copy(
                refreshing = true
            )
        viewModelScope.launch {
            cryptocurrencyUseCase.getCryptocurrency().onSuccess {
                cryptocurrencyState.value =
                    cryptocurrencyState.value.copy(
                        CryptocurrencyList = listOf()
                    )
                cryptocurrencyState.value =
                    cryptocurrencyState.value.copy(
                        CryptocurrencyList = it.filter { cryptocurrency ->
                            cryptocurrency.quoteAsset == "usdt"
                        },
                        refreshing = false
                    )
            }.onFailure {

            }
        }
    }

    fun onListRefresh() {
        getCryptocurrencies()
    }

    fun onCurrencyChanged(currencyState: Boolean) {
        cryptocurrencyState.value =
            cryptocurrencyState.value.copy(
                currencyState = if (currencyState) CurrencyState.SEK else CurrencyState.USD
            )
    }

}

