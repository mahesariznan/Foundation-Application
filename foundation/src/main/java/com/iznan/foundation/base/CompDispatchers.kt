package com.iznan.foundation.base

import kotlinx.coroutines.CoroutineDispatcher

class CompDispatchers(
    val default: CoroutineDispatcher,
    val main: CoroutineDispatcher,
    val io: CoroutineDispatcher
)