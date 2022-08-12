package com.renarosantos.ecommerceapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class ProductViewModelTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
}