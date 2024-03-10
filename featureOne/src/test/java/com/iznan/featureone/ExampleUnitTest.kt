package com.iznan.featureone

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val arr = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        for (i in 0 until arr.size) {
            for (j in i + 1 until arr.size) {
                println("i,j: ${arr.get(i)} , ${arr.get(j)}")
            }
        }
    }
}