package org.example

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * Дымовой тест: все три задачи запускаются и ничего не падают.
 * Основные проверки расчётов лежат в TaskTest.kt.
 */
class AppTest {

    @Test
    fun `все три задачи отрабатывают без ошибок`() {
        var ok = true

        try {
            task1()
            task2()
            task3()
        } catch (e: Exception) {
            ok = false
        }

        assertTrue(ok, "ни одна из задач не должна падать с ошибкой")
    }
}
