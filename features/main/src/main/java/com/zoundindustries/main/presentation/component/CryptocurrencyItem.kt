package com.zoundindustries.main.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import coil.compose.rememberImagePainter
import com.zoundindustries.main.R
import com.zoundindustries.main.domain.entity.CryptocurrencyResponseEntity
import com.zoundindustries.main.util.changeCurrency
import com.zoundindustries.theme.*
import java.util.*

@Composable
fun CryptocurrencyItem(
    state: CryptocurrencyState,
    cryptocurrencyResponseEntity: CryptocurrencyResponseEntity
) {
    val mCheckedState = remember { mutableStateOf(false) }
    Card(
        onClick = {
            mCheckedState.value = !mCheckedState.value
        },
        shape = Shapes.small,
        backgroundColor = DarkGray,
        modifier = Modifier
            .padding(start = margin10Dp, end = margin10Dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(margin16Dp)
        ) {
            CryptocurrencyItemPart1(state, cryptocurrencyResponseEntity)

            if (mCheckedState.value) {
                CryptocurrencyItemPart2(state, cryptocurrencyResponseEntity)
                CryptocurrencyItemPart3(state, cryptocurrencyResponseEntity)
            }
            Image(
                modifier = Modifier
                    .width(margin16Dp)
                    .height(margin16Dp)
                    .align(Alignment.CenterHorizontally),
                painter = if (mCheckedState.value) rememberImagePainter(R.drawable.ic_arrow_up) else rememberImagePainter(
                    R.drawable.ic_arrow_down
                ),
                contentDescription = null
            )
        }
    }
}

@Composable
fun CryptocurrencyItemPart1(
    state: CryptocurrencyState,
    cryptocurrencyResponseEntity: CryptocurrencyResponseEntity
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = margin16Dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.Start) {
            Text(
                style = MaterialTheme.typography.h6,
                color = White,
                text = cryptocurrencyResponseEntity.baseAsset!!.uppercase(Locale.getDefault())
            )

            Text(
                style = MaterialTheme.typography.subtitle2,
                color = LightGray,
                text = cryptocurrencyResponseEntity.symbol!!
            )
        }
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                style = MaterialTheme.typography.subtitle1,
                color = White,
                text = stringResource(R.string.last_price)
            )

            Text(
                style = MaterialTheme.typography.subtitle2,
                color = Aqua,
                text = if (state.currencyState == CurrencyState.USD) {
                    "$${cryptocurrencyResponseEntity.lastPrice.toString()}"
                } else {
                    "${
                        cryptocurrencyResponseEntity.lastPrice!!.toFloat().changeCurrency()
                    } SEK"
                }
            )
        }
        Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.End) {
            Text(
                style = MaterialTheme.typography.subtitle1,
                color = White,
                text = stringResource(R.string.volume)
            )

            Text(
                style = MaterialTheme.typography.subtitle2,
                color = LightGray,
                text = cryptocurrencyResponseEntity.volume.toString()
            )
        }
    }
}

@Composable
fun CryptocurrencyItemPart2(
    state: CryptocurrencyState,
    cryptocurrencyResponseEntity: CryptocurrencyResponseEntity
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = margin16Dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(modifier = Modifier.weight(1f)) {
        }
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                style = MaterialTheme.typography.subtitle1,
                color = White,
                text = stringResource(R.string.high_price)
            )

            Text(
                style = MaterialTheme.typography.subtitle2,
                color = Lime,
                text = if (state.currencyState == CurrencyState.USD) {
                    "$${cryptocurrencyResponseEntity.highPrice.toString()}"
                } else {
                    "${
                        cryptocurrencyResponseEntity.highPrice!!.toFloat()
                            .changeCurrency()
                    } SEK"
                }
            )
        }
        Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.End) {
            Text(
                style = MaterialTheme.typography.subtitle1,
                color = White,
                text = stringResource(R.string.low_price)
            )

            Text(
                style = MaterialTheme.typography.subtitle2,
                color = Red,
                text = if (state.currencyState == CurrencyState.USD) {
                    "$${cryptocurrencyResponseEntity.lowPrice.toString()}"
                } else {
                    "${
                        cryptocurrencyResponseEntity.lowPrice!!.toFloat()
                            .changeCurrency()
                    } SEK"
                }
            )
        }
    }
}

@Composable
fun CryptocurrencyItemPart3(
    state: CryptocurrencyState,
    cryptocurrencyResponseEntity: CryptocurrencyResponseEntity
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = margin8Dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(modifier = Modifier.weight(1f)) {
        }
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                style = MaterialTheme.typography.subtitle1,
                color = White,
                text = stringResource(R.string.bid_price)
            )

            Text(
                style = MaterialTheme.typography.subtitle2,
                color = Aqua,
                text = if (state.currencyState == CurrencyState.USD) {
                    "$${cryptocurrencyResponseEntity.bidPrice.toString()}"
                } else {
                    "${
                        cryptocurrencyResponseEntity.bidPrice!!.toFloat()
                            .changeCurrency()
                    } SEK"
                }
            )
        }
        Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.End) {
            Text(
                style = MaterialTheme.typography.subtitle1,
                color = White,
                text = stringResource(R.string.ask_price)
            )

            Text(
                style = MaterialTheme.typography.subtitle2,
                color = Aqua,
                text = if (state.currencyState == CurrencyState.USD) {
                    "$${cryptocurrencyResponseEntity.askPrice.toString()}"
                } else {
                    "${
                        cryptocurrencyResponseEntity.askPrice!!.toFloat()
                            .changeCurrency()
                    } SEK"
                }
            )
        }
    }
}
