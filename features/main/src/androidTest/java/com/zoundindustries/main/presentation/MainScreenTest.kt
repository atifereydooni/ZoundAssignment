package com.zoundindustries.main.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.zoundindustries.main.getMockDataList
import com.zoundindustries.main.getMockDataList3Items
import com.zoundindustries.main.presentation.component.CryptocurrencyList
import com.zoundindustries.main.presentation.component.CryptocurrencyState
import com.zoundindustries.main.presentation.component.CurrencyState
import com.zoundindustries.main.presentation.component.TAG_LIST
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MainScreenTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun toolbarIsDisplayed() {
        composeTestRule.setContent {
            Toolbar()
        }
        composeTestRule.onNodeWithTag(TAG_TOOLBAR)
            .assertIsDisplayed()
    }

    @Test
    fun switchIsDisplayed() {
        composeTestRule.setContent {
            MainContent()
        }
        composeTestRule.onNodeWithTag(TAG_SWITCH)
            .assertIsDisplayed()
    }

    @Test
    fun switchTitlesAreDisplayed() {
        composeTestRule.setContent {
            MainContent()
        }
        composeTestRule.onNodeWithTag(TAG_SWITCH_CURRENCY_USD)
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag(TAG_SWITCH_CURRENCY_SEK)
            .assertIsDisplayed()
    }

    @Test
    fun listIsEmpty() {
        val cryptocurrencyState: MutableState<CryptocurrencyState> =
            mutableStateOf(CryptocurrencyState())
        composeTestRule.setContent {
            CryptocurrencyList(cryptocurrencyState.value)
        }
        composeTestRule.onNodeWithTag(TAG_LIST)
            .onChildren()
            .assertCountEquals(0)
    }

    @Test
    fun listSizeTest() {
        val cryptocurrencyState: MutableState<CryptocurrencyState> =
            mutableStateOf(CryptocurrencyState(CryptocurrencyList = getMockDataList()))
        composeTestRule.setContent {
            CryptocurrencyList(cryptocurrencyState.value)
        }
        composeTestRule.onNodeWithTag(TAG_LIST)
            .onChildren()
            .assertCountEquals(1)
    }

    @Test
    fun firstItemSymbolTest() {
        val cryptocurrencyState: MutableState<CryptocurrencyState> =
            mutableStateOf(CryptocurrencyState(CryptocurrencyList = getMockDataList()))
        composeTestRule.setContent {
            CryptocurrencyList(cryptocurrencyState.value)
        }
        composeTestRule.onNodeWithTag(TAG_LIST)
            .onChildren()
            .onFirst()
            .assert(hasTestTag(getMockDataList()[0].symbol!!))
    }

    @Test
    fun lastItemSymbolTest() {
        val cryptocurrencyState: MutableState<CryptocurrencyState> =
            mutableStateOf(CryptocurrencyState(CryptocurrencyList = getMockDataList3Items()))
        composeTestRule.setContent {
            CryptocurrencyList(cryptocurrencyState.value)
        }
        composeTestRule.onNodeWithTag(TAG_LIST)
            .onChildren()
            .onFirst()
            .assert(hasTestTag(getMockDataList()[getMockDataList().size - 1].symbol!!))
    }

}
