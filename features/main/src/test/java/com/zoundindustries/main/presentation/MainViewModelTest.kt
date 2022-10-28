package com.zoundindustries.main.presentation


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.zoundindustries.main.domain.repo.CryptocurrencyRepository
import com.zoundindustries.main.domain.usecase.CryptocurrencyUseCase
import com.zoundindustries.main.domain.usecase.getMockDataList
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class MainViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()
    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    private lateinit var viewModel: MainViewModel

    private lateinit var cryptocurrencyUseCase: CryptocurrencyUseCase

    @RelaxedMockK
    private lateinit var repository: CryptocurrencyRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testCoroutineDispatcher)
        cryptocurrencyUseCase = spyk(CryptocurrencyUseCase(repository))
        viewModel = spyk(MainViewModel(cryptocurrencyUseCase))
    }

    @Test
    fun byOnListRefreshCetCryptocurrenciesInvoked() {
        testCoroutineDispatcher.runBlockingTest {
            viewModel.onListRefresh()
            verify { viewModel.getCryptocurrencies() }
        }
    }

    @Test
    fun getCryptocurrenciesTest() {
        testCoroutineDispatcher.runBlockingTest {
            coEvery {
                cryptocurrencyUseCase.getCryptocurrency()
            } answers {
                flow {
                    emit(
                        Result.success(
                            getMockDataList()
                        )
                    )
                }
            }

            viewModel.getCryptocurrencies()

            assert(
                viewModel.cryptocurrencyState.value.CryptocurrencyList[0].symbol ==
                        getMockDataList()[0].symbol
            )
        }
    }
}