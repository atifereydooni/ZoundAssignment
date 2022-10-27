package com.zoundindustries.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.zoundindustries.main.data.CryptocurrencyRepositoryImpl
import com.zoundindustries.main.data.datasource.CryptocurrencyRemoteDatasource
import com.zoundindustries.main.domain.repo.CryptocurrencyRepository
import com.zoundindustries.main.domain.usecase.CryptocurrencyUseCase
import com.zoundindustries.main.domain.usecase.getMockDataList
import com.zoundindustries.main.domain.usecase.mockSafeFold
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.spyk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class CryptocurrencyUseCaseTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()
    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    private lateinit var repository: CryptocurrencyRepository

    private lateinit var cryptocurrencyUseCase: CryptocurrencyUseCase

    @RelaxedMockK
    private lateinit var cryptocurrencyRemoteDatasource: CryptocurrencyRemoteDatasource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testCoroutineDispatcher)
        repository = spyk(CryptocurrencyRepositoryImpl(cryptocurrencyRemoteDatasource))
        cryptocurrencyUseCase = spyk(CryptocurrencyUseCase(repository))
    }

    @Test
    fun getCryptocurrencyTest() {
        testCoroutineDispatcher.runBlockingTest {
            coEvery {
                repository.getCryptocurrency()
            } returns Result.success(listOf())

            val result = cryptocurrencyUseCase.getCryptocurrency()
            assert(result.isSuccess)
        }
    }

    @Test
    fun getCryptocurrencyTest_ResponseIsNotNull() {
        testCoroutineDispatcher.runBlockingTest {
            coEvery {
                repository.getCryptocurrency()
            } answers {
                Result.success(
                    getMockDataList()
                )
            }

            val result = cryptocurrencyUseCase.getCryptocurrency()
            assert(result.getOrNull() != null)
            result.mockSafeFold(
                onSuccess = { assert(it.size == 1) },
                onFailure = {}
            )

        }
    }

    @Test
    fun getCryptocurrencyTest_ResponseReturnsCorrectData() {
        testCoroutineDispatcher.runBlockingTest {
            coEvery {
                repository.getCryptocurrency()
            } answers {
                Result.success(
                    getMockDataList()
                )
            }

            val result = cryptocurrencyUseCase.getCryptocurrency()
            assert(result.getOrNull() != null)
            result.mockSafeFold(
                onSuccess = { assert(it[0].symbol == "xrpinr") },
                onFailure = {}
            )

        }
    }
}


