package com.iznan.carousell

import com.iznan.carousell.presentation.viewmodel.CarousellViewModel
import com.iznan.domain.base.Resource
import com.iznan.domain.entity.News
import com.iznan.domain.usecase.CarousellUseCase
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class CarousellViewModelTest : BaseTest() {

    private lateinit var viewModel: CarousellViewModel
    val carousellUseCase: CarousellUseCase = mockk(relaxed = true)

    override fun setUp() {
        super.setUp()

        viewModel = spyk(
            CarousellViewModel(
                carousellUseCase,
                appTestDispatcher,
            )
        )
    }

    @Test
    fun `get news list return success`() = runBlocking {
        // Given
        val expectedReturn = Resource.success(
            listOf(
                News("", "", "", 1, 1)
            )
        )
        coEvery { carousellUseCase.getNewsList() } returns flow {
            emit(expectedReturn)
        }

        // When
        viewModel.getNewsList()

        // Then
        Assert.assertEquals(viewModel.newsData.value.data, expectedReturn.data)
    }

    @Test
    fun `sort by recent`() = runBlocking {
        // Given
        val expectedReturn = Resource.success(
            listOf(
                News("", "", "", 3, 3),
                News("", "", "", 2, 2),
                News("", "", "", 1, 1)
            )
        )
        coEvery { carousellUseCase.getNewsList() } returns flow {
            emit(expectedReturn)
        }

        // When
        viewModel.getNewsList()
        viewModel.sortByRecent()

        // Then
        Assert.assertEquals(viewModel.newsData.value.data?.first()?.timeCreated, 3L)
    }

    @Test
    fun `sort by popular`() = runBlocking {
        // Given
        val expectedReturn = Resource.success(
            listOf(
                News("", "", "", 3, 3),
                News("", "", "", 2, 2),
                News("", "", "", 1, 1)
            )
        )
        coEvery { carousellUseCase.getNewsList() } returns flow {
            emit(expectedReturn)
        }

        // When
        viewModel.getNewsList()
        viewModel.sortByPopular()

        // Then
        Assert.assertEquals(viewModel.newsData.value.data?.first()?.rank, 1)
    }
}