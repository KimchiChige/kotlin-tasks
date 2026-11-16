package org.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Тесты на все три задачи.
 * Проверить: ./gradlew test
 */

class Task1Test {

    @Test
    fun `для обычной суммы комиссия равна 0_75 процента`() {
        assertEquals(75.0, calculateCommission(10_000.0), 0.001)
        assertEquals(750.0, calculateCommission(100_000.0), 0.001)
    }

    @Test
    fun `для маленьких сумм комиссия не меньше 35 рублей`() {
        assertEquals(35.0, calculateCommission(100.0), 0.001)
        assertEquals(35.0, calculateCommission(4_666.0), 0.001)
    }

    @Test
    fun `сразу после порога комиссия уже больше 35 рублей`() {
        // 4 667 * 0.0075 = 35,0025 — это уже больше минимальной комиссии.
        assertEquals(35.0025, calculateCommission(4_667.0), 0.001)
    }

    @Test
    fun `за нулевой перевод комиссии нет`() {
        assertEquals(0.0, calculateCommission(0.0), 0.001)
    }
}

class Task2Test {

    @Test
    fun `числа на 1 кроме 11 требуют форму человеку`() {
        assertEquals("человеку", likesEnding(1))
        assertEquals("человеку", likesEnding(21))
        assertEquals("человеку", likesEnding(41))
        assertEquals("человеку", likesEnding(101))
        assertEquals("человеку", likesEnding(1_001))
    }

    @Test
    fun `числа на 11 это исключение и требуют форму людям`() {
        assertEquals("людям", likesEnding(11))
        assertEquals("людям", likesEnding(111))
        assertEquals("людям", likesEnding(211))
    }

    @Test
    fun `все остальные числа требуют форму людям`() {
        assertEquals("людям", likesEnding(0))
        assertEquals("людям", likesEnding(2))
        assertEquals("людям", likesEnding(5))
        assertEquals("людям", likesEnding(12))
        assertEquals("людям", likesEnding(32))
        assertEquals("людям", likesEnding(100))
    }

    @Test
    fun `сообщение собирается правильно`() {
        assertEquals("Понравилось 32 людям", likesMessage(32))
        assertEquals("Понравилось 41 человеку", likesMessage(41))
        assertEquals("Понравилось 1 человеку", likesMessage(1))
        assertEquals("Понравилось 11 людям", likesMessage(11))
    }
}

class Task3Test {

    @Test
    fun `сумма из примера в задании`() {
        // 15 000 * 0.95 = 14 250, затем 14 250 * 0.99 = 14 107,5 -> 14 108.
        assertEquals(14_250, calculatePrice(15_000, false))
        assertEquals(14_108, calculatePrice(15_000, true))
    }

    @Test
    fun `до 1000 рублей скидки нет`() {
        assertEquals(500, calculatePrice(500, false))
        assertEquals(1_000, calculatePrice(1_000, false))
    }

    @Test
    fun `от 1001 до 10000 рублей скидка 100 рублей`() {
        assertEquals(901, calculatePrice(1_001, false))
        assertEquals(9_900, calculatePrice(10_000, false))
    }

    @Test
    fun `от 10001 рубля скидка 5 процентов`() {
        assertEquals(9_501, calculatePrice(10_001, false))
        assertEquals(19_000, calculatePrice(20_000, false))
    }

    @Test
    fun `постоянному покупателю дополнительно минус 1 процент`() {
        assertEquals(495, calculatePrice(500, true))
        assertEquals(990, calculatePrice(1_000, true))
        assertEquals(9_801, calculatePrice(10_000, true))
        assertEquals(18_810, calculatePrice(20_000, true))
    }
}
