package com.zoundindustries.main.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zoundindustries.main.domain.usecase.CryptocurrencyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    private val cryptocurrencyUseCase: CryptocurrencyUseCase
) : ViewModel() {

    init {
        getCryptocurrencies()
    }


    private fun getCryptocurrencies() {
        viewModelScope.launch {
            cryptocurrencyUseCase.getCryptocurrency().onSuccess {
                Log.d("MainViewModel", it.toString())
            }.onFailure {

            }
        }
    }

}

