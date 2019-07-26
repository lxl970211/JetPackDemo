package com.googlex.lxl.jetpackdemo

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        var lists = listOf<Person>(Person("google"), Person("micro", age = 30))
        val oldest = lists.maxBy {
            it.age ?:0
        }
        println("oldest ${oldest.name}")

    }
}

data class Person(val name : String, val age : Int = 0)