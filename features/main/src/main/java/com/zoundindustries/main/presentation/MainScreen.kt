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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import coil.compose.rememberImagePainter
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.zoundindustries.main.R
import com.zoundindustries.main.presentation.component.CryptocurrencyList
import com.zoundindustries.main.presentation.component.LoadingView
import com.zoundindustries.theme.*

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onListRefresh: () -> Unit = {},
    onCurrencyChanged: (Boolean) -> Unit = {}
) {
    Scaffold(
        topBar = {
            Toolbar()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Black),
        ) {
            if (!viewModel.cryptocurrencyState.value.loading) {
                MainContent(onCurrencyChanged)
            } else {
                LoadingView()
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

@Composable
fun Toolbar() {
    TopAppBar(
        modifier = Modifier.testTag(TAG_TOOLBAR),
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
        }
    )
}

@Composable
fun MainContent(
    onCurrencyChanged: (Boolean) -> Unit = {}
) {
    val switchState = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.padding(margin8Dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.testTag(TAG_SWITCH_CURRENCY_USD),
            style = MaterialTheme.typography.subtitle1,
            color = White,
            text = "USD"
        )
        Switch(
            modifier = Modifier
                .padding(start = margin16Dp, end = margin16Dp)
                .testTag(TAG_SWITCH),
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
            modifier = Modifier.testTag(TAG_SWITCH_CURRENCY_SEK),
            style = MaterialTheme.typography.subtitle1,
            color = White,
            text = "SEK"
        )
    }
}

const val TAG_TOOLBAR = "TAG_TOOLBAR"
const val TAG_SWITCH = "TAG_SWITCH"
const val TAG_SWITCH_CURRENCY_USD = "TAG_SWITCH_CURRENCY_USD"
const val TAG_SWITCH_CURRENCY_SEK = "TAG_SWITCH_CURRENCY_SEK"