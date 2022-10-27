package com.zoundindustries.main.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.zoundindustries.theme.Black
import com.zoundindustries.theme.margin10Dp

@Composable
fun CryptocurrencyList(
    state: CryptocurrencyState
) {
    LazyColumn(
        modifier = Modifier
            .background(Black)
            .padding(top = margin10Dp),
        verticalArrangement = Arrangement.spacedBy(margin10Dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(state.CryptocurrencyList.size) { index ->
            CryptocurrencyItem(
                state,
                state.CryptocurrencyList[index],
            )
        }
    }
}