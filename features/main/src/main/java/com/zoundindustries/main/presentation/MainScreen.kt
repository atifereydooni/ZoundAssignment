package com.zoundindustries.main.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.zoundindustries.main.R
import com.zoundindustries.main.presentation.component.CryptocurrencyList
import com.zoundindustries.theme.*

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    onListRefresh: () -> Unit = {},
    onCurrencyChanged: (Boolean) -> Unit = {}
) {
    val switchState = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Black,
                content = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = rememberImagePainter(R.drawable.zound_logo),
                            contentDescription = null
                        )
                        Text(
                            modifier = Modifier.padding(start = margin8Dp),
                            style = TextStyle(
                                fontSize = font20Sp,
                                fontFamily = FontFamily(Font(R.font.helvetica_bold_italic))
                            ),
                            color = White,
                            text = "Cryptocurrency Zound"
                        )
                    }
                },

                )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Black),
        ) {
            Row(
                modifier = Modifier.padding(margin8Dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    style = MaterialTheme.typography.subtitle1,
                    color = White,
                    text = "USD"
                )
                Switch(
                    modifier = Modifier.padding(start = margin16Dp, end = margin16Dp),
                    checked = switchState.value,
                    onCheckedChange = {
                        switchState.value = it
                        onCurrencyChanged(switchState.value)
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Aqua,
                        uncheckedThumbColor = Aqua,
                        checkedTrackColor = Aqua,
                        uncheckedTrackColor = Aqua,
                    )
                )
                Text(
                    style = MaterialTheme.typography.subtitle1,
                    color = White,
                    text = "SEK"
                )
            }
            SwipeRefresh(
                state = rememberSwipeRefreshState(viewModel.cryptocurrencyState.value.refreshing),
                onRefresh = { onListRefresh() },
            ) {
                CryptocurrencyList(state = viewModel.cryptocurrencyState.value)
            }
        }
    }
}