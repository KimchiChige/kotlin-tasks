package org.example

// Задача 1. Комиссия за денежный перевод: 0.75 % от суммы, но не меньше 35 рублей.

fun calculateCommission(amount: Double): Double {
    // за перевод нулевой или отрицательной суммы комиссии нет
    if (amount <= 0.0) {
        return 0.0
    }

    // 0.75 % — это 0.75 / 100 = 0.0075 доли от суммы
    val commission = amount * 0.0075

    // комиссия не может быть меньше 35 рублей
    if (commission < 35.0) {
        return 35.0
    }

    return commission
}

fun task1() {
    // сумма перевода в рублях
    val amount = 10_000.0

    val commission = calculateCommission(amount)
    println("Сумма перевода: %.2f руб.".format(amount))
    println("Комиссия за перевод: %.2f руб.".format(commission))

    println()
    println("Комиссия для других сумм:")
    for (otherAmount in listOf(100.0, 1_000.0, 4_666.0, 4_667.0, 20_000.0)) {
        val otherCommission = calculateCommission(otherAmount)
        println("  %.2f руб. -> %.2f руб.".format(otherAmount, otherCommission))
    }
}

fun main() {
    task1()
}
