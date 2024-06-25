package com.iznan.carousell

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.test.filters.SmallTest
import com.iznan.foundation.base.CompDispatchers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
@SmallTest
abstract class BaseTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    val testDispatchers = UnconfinedTestDispatcher()
    val appTestDispatcher = CompDispatchers(testDispatchers, testDispatchers, testDispatchers)

    @Before
    open fun setUp() {
        Dispatchers.setMain(testDispatchers)
    }

    @After
    open fun cleanUp() {
        Dispatchers.resetMain()
    }

    fun <T> LiveData<T>.inject(value: T) {
        (this as? MutableLiveData<T>)?.value = value
    }
}
